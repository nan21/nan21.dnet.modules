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
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElementValue;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;
import net.nan21.dnet.module.md.base.elem.domain.entity.Element;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementFormula;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementInput;

public class PayrollPeriodProcessorBD extends AbstractBusinessDelegate {

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

	private ScriptEngine scriptEngine;
	private List<Element> elements;
	private Map<String, ElementFormula> formulas;
	private IEmployeeService emplService;

	public void process(PayrollPeriod period) throws Exception {
		this.emplService = (IEmployeeService) this
				.findEntityService(Employee.class);
		String eqlEmpl = "select e from " + Employee.class.getSimpleName()
				+ " e " + " where e.clientId = :clientId "
				+ "   and e.payroll.id = :payrollId ";

		List<Employee> employees = this.emplService.getEntityManager()
				.createQuery(eqlEmpl, Employee.class).setParameter("clientId",
						Session.user.get().getClientId()).setParameter(
						"payrollId", period.getPayroll().getId()).setHint(
						QueryHints.LEFT_FETCH, "e.contacts").getResultList();

		// load elements
		String eql = "select e from " + Element.class.getSimpleName() + " e "
				+ " where e.clientId = :clientId " + "  and e.active = true "
				+ " order by e.sequenceNo ";

		this.elements = this.emplService.getEntityManager().createQuery(eql,
				Element.class).setParameter("clientId",
				Session.user.get().getClientId()).getResultList();

		// load valid formulas
		String eqlf = "select e from " + ElementFormula.class.getSimpleName()
				+ " e "
				+ " left join fetch e.element where e.clientId = :clientId "
				+ "  and e.validFrom <= :eventDate "
				+ " and (e.validTo is null or e.validTo>= :eventDate)";

		List<ElementFormula> result = this.emplService.getEntityManager()
				.createQuery(eqlf, ElementFormula.class).setParameter(
						"clientId", Session.user.get().getClientId())
				.setParameter("eventDate", new Date()).getResultList();

		// keep the formulas in a Map for later use
		this.formulas = new HashMap<String, ElementFormula>();
		for (ElementFormula formula : result) {
			this.formulas.put(formula.getElement().getCode(), formula);
		}

		// do the work for each employee
		for (Employee employee : employees) {
			this.processPayrollPeriod(period, employee);
		}

		period.setProcessed(true);
		this.getEntityManager().merge(period);
	}

	protected void processPayrollPeriod(PayrollPeriod period, Employee employee)
			throws Exception {

		Map<String, PayrollElementValue> elemValMap = new HashMap<String, PayrollElementValue>();
		ScriptEngine engine = this.getScriptEngine();
		engine.put("_employee", employee);
		for (Element element : this.elements) {
			PayrollElementValue elemVal = new PayrollElementValue();
			elemVal.setEmployee(employee);
			elemVal.setElement(element);
			elemVal.setPeriod(period);
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
							+ ") Reason is: "+e.getMessage());
				}

			}
			this.emplService.getEntityManager().persist(elemVal);
		}
	}

	protected ScriptEngine getScriptEngine() {
		if (this.scriptEngine == null) {
			ScriptEngineManager manager = new ScriptEngineManager();
			this.scriptEngine = manager.getEngineByName("JavaScript");
		}
		return this.scriptEngine;
	}
}
