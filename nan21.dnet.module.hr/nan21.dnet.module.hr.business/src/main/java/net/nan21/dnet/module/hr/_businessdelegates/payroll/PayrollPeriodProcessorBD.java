package net.nan21.dnet.module.hr._businessdelegates.payroll;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.eclipse.persistence.config.QueryHints;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementFormula;
import net.nan21.dnet.module.bd.elem.domain.entity.ElementInput;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeAssignment;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElementValue;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

public class PayrollPeriodProcessorBD extends AbstractBusinessDelegate {

	private ScriptEngine scriptEngine;
	private List<PayrollElement> elements;
	private Map<String, ElementFormula> formulas;
	private IEmployeeService emplService;

	/**
	 * Close period
	 * 
	 * @param period
	 * @throws Exception
	 */
	public void close(PayrollPeriod period) throws Exception {

		period.setActive(false);
		period.setClosed(true);
		this.getEntityManager().merge(period);
	}

	/**
	 * Clear period
	 * 
	 * @param period
	 * @throws Exception
	 */
	public void clear(PayrollPeriod period) throws Exception {
		String eql = "delete from " + PayrollElementValue.class.getSimpleName()
				+ " e where e.clientId = :clientId "
				+ "   and e.period.id = :periodId ";
		this.getEntityManager().createQuery(eql).setParameter("clientId",
				Session.user.get().getClientId()).setParameter("periodId",
				period.getId()).executeUpdate();
		period.setProcessed(false);
		this.getEntityManager().merge(period);
	}

	/**
	 * Open period
	 * 
	 * @param period
	 * @throws Exception
	 */
	public void open(PayrollPeriod period) throws Exception {

		this.emplService = (IEmployeeService) this
				.findEntityService(Employee.class);

		String eqlEmpl = "select e from "
				+ EmployeeAssignment.class.getSimpleName() + " e "
				+ " where e.clientId = :clientId "
				+ "   and e.payroll.id = :payrollId "
				+ " and e.validFrom <= :effectiveDate "
				+ " and ( e.validTo is null or e.validTo>= :effectiveDate)";

		List<EmployeeAssignment> assignments = this.emplService
				.getEntityManager().createQuery(eqlEmpl,
						EmployeeAssignment.class).setParameter("clientId",
						Session.user.get().getClientId()).setParameter(
						"payrollId", period.getPayroll().getId()).setParameter(
						"effectiveDate", period.getStartDate()).getResultList();

		// load elements
		String eql = "select e from " + PayrollElement.class.getSimpleName()
				+ " e " + " where e.clientId = :clientId "
				+ "  and e.active = true" + " and e.calculation = 'manual' "
				+ " and e.balance = false " + " and e.engine.id = :engineId ";

		this.elements = this.emplService.getEntityManager().createQuery(eql,
				PayrollElement.class).setParameter("engineId",
				period.getPayroll().getEngine().getId()).setParameter(
				"clientId", Session.user.get().getClientId()).getResultList();

		for (EmployeeAssignment asgn : assignments) {
			for (PayrollElement element : elements) {
				PayrollElementValue elemVal = new PayrollElementValue();
				elemVal.setAssignment(asgn);
				elemVal.setElement(element);
				elemVal.setPeriod(period);
				elemVal.setOrg(asgn.getEmployee().getEmployer());
				this.emplService.getEntityManager().persist(elemVal);
			}
		}
		period.setActive(true);
		this.getEntityManager().merge(period);
	}

	/**
	 * Process period
	 * 
	 * @param period
	 * @throws Exception
	 */
	public void process(PayrollPeriod period) throws Exception {
		this.emplService = (IEmployeeService) this
				.findEntityService(Employee.class);

		String eqlEmpl = "select e from "
				+ EmployeeAssignment.class.getSimpleName() + " e "
				+ " where e.clientId = :clientId "
				+ "   and e.payroll.id = :payrollId  "
				+ " and e.validFrom <= :effectiveDate "
				+ " and ( e.validTo is null or e.validTo>= :effectiveDate)";

		List<EmployeeAssignment> assignments = this.emplService
				.getEntityManager().createQuery(eqlEmpl,
						EmployeeAssignment.class).setParameter("clientId",
						Session.user.get().getClientId()).setParameter(
						"payrollId", period.getPayroll().getId()).setParameter(
						"effectiveDate", period.getStartDate()).setHint(
						QueryHints.FETCH, "e.employee").setHint(
						QueryHints.LEFT_FETCH, "e.employee.contacts")
				.getResultList();

		// load elements
		String eql = "select e from " + PayrollElement.class.getSimpleName()
				+ " e " + " where e.clientId = :clientId "
				+ "  and e.active = true and e.calculation = 'formula' "
				+ "  and e.balance = false and e.engine.id = :engineId "
				+ " order by e.sequenceNo ";

		this.elements = this.emplService.getEntityManager().createQuery(eql,
				PayrollElement.class).setParameter("engineId",
				period.getPayroll().getEngine().getId()).setParameter(
				"clientId", Session.user.get().getClientId()).getResultList();

		// load valid formulas
		String eqlf = "select e from "
				+ ElementFormula.class.getSimpleName()
				+ " e "
				+ " left join fetch e.element where e.clientId = :clientId "
				+ "  and e.validFrom <= :eventDate and e.element.calculation = 'formula' "
				+ " and (e.validTo is null or e.validTo>= :eventDate)"
				+ " and e.element.engine.id = :engineId ";

		List<ElementFormula> result = this.emplService.getEntityManager()
				.createQuery(eqlf, ElementFormula.class).setParameter(
						"clientId", Session.user.get().getClientId())
				.setParameter("engineId",
						period.getPayroll().getEngine().getId()).setParameter(
						"eventDate", new Date()).getResultList();

		// keep the formulas in a Map for later use
		this.formulas = new HashMap<String, ElementFormula>();
		for (ElementFormula formula : result) {
			this.formulas.put(formula.getElement().getCode(), formula);
		}

		// do the work for each employee assignment
		for (EmployeeAssignment asgn : assignments) {
			this.processPayrollPeriod(period, asgn);
		}

		// calculate totals
		this.emplService.getEntityManager().flush();
		// calculate sums
		String t1 = " select e , ev.org , sum(ev.value) "
				+ "  from PayrollElementValue ev ,  PayrollElement e "
				+ " where ev.period.id = :periodId "
				+ "  and ev.element.dataType = 'number' "
				+ "  and e.sourceElement.id = ev.element.id "
				+ "  and e.balance = true " + " and e.balanceFunction = 'sum'"
				+ " group by e, ev.org ";
		//				 
		List<Object[]> t1res = this.emplService.getEntityManager().createQuery(
				t1).setParameter("periodId", period.getId()).getResultList();
		for (Object[] row : t1res) {
			PayrollElementValue ev = new PayrollElementValue();
			ev.setPeriod(period);
			ev.setElement((PayrollElement) row[0]);
			ev.setOrg((Organization) row[1]);
			ev.setValue(row[2].toString());

			this.getEntityManager().persist(ev);
		}
		period.setProcessed(true);
		this.getEntityManager().merge(period);
	}

	/**
	 * Helper processing function
	 * 
	 * @param period
	 * @param employee
	 * @throws Exception
	 */
	protected void processPayrollPeriod(PayrollPeriod period, EmployeeAssignment assignment)
			throws Exception {

		Map<String, PayrollElementValue> elemValMap = new HashMap<String, PayrollElementValue>();
		ScriptEngine engine = this.getScriptEngine();
		Employee employee = assignment.getEmployee();
		engine.put("_assignment", assignment);
		engine.put("_employee", employee);

		for (PayrollElement element : this.elements) {

			PayrollElementValue elemVal = new PayrollElementValue();
			elemVal.setAssignment(assignment);
			elemVal.setElement(element);
			elemVal.setPeriod(period);
			elemVal.setOrg(employee.getEmployer());
			elemValMap.put(element.getCode(), elemVal);

			for (ElementInput var : element.getVariables()) {
				PayrollElementValue v = elemValMap.get(var.getCrossReference()
						.getCode());
				if (v == null) {
					throw new RuntimeException("Cannot process element `"
							+ element.getCode() + "` - `" + element.getName()
							+ "` (step=" + element.getSequenceNo()
							+ ") as the required input value `"
							+ var.getCrossReference().getCode()
							+ "` has not been processed yet (step="
							+ var.getCrossReference().getSequenceNo() + ").");
				}
				if (v.getElement().getDataType().equals("number")) {
					engine.put(var.getAlias(), Double.valueOf(v.getValue()));
				}
				if (v.getElement().getDataType().equals("string")) {
					engine.put(var.getAlias(), v.getValue());
				}

			}
			if (element.getDataType().equals("number")) {
				try {
					Object result = engine.eval(this.formulas.get(
							element.getCode()).getExpression());

					if (result instanceof Double) {
						elemVal.setValue(Double.toString((Double) result));
					}
					if (result instanceof Float) {
						elemVal.setValue(Float.toString((Float) result));
					}
					if (result instanceof Integer) {
						elemVal.setValue(Integer.toString((Integer) result));
					}
				} catch (Exception e) {
					throw new RuntimeException("Cannot process element `"
							+ element.getCode() + "` - `" + element.getName()
							+ "` (step=" + element.getSequenceNo()
							+ ") Reason is: " + e.getMessage());
				}
			}
			this.emplService.getEntityManager().persist(elemVal);
		}
	}

	/**
	 * Get scripting engine
	 * 
	 * @return
	 */
	protected ScriptEngine getScriptEngine() {
		if (this.scriptEngine == null) {
			ScriptEngineManager manager = new ScriptEngineManager();
			this.scriptEngine = manager.getEngineByName("JavaScript");
		}
		return this.scriptEngine;
	}
}
