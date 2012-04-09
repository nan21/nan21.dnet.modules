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
import net.nan21.dnet.module.hr.payroll.domain.entity.Element;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementFormula;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementInput;
import net.nan21.dnet.module.hr.payroll.domain.entity.ElementValue;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;

public class PayrollPeriodProcessorBD extends AbstractBusinessDelegate {

	public void clear(PayrollPeriod period) throws Exception {
		String eql = "delete from ElementValue e where e.clientId = :clientId "
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
		String eqlEmpl = "select e from Employee e "
				+ " where e.clientId = :clientId "
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

		Map<String, ElementValue> elemValMap = new HashMap<String, ElementValue>();
		ScriptEngine engine = this.getScriptEngine();
		engine.put("_employee", employee);
		for (Element element : this.elements) {
			ElementValue elemVal = new ElementValue();
			elemVal.setEmployee(employee);
			elemVal.setElement(element);
			elemVal.setPeriod(period);
			elemValMap.put(element.getCode(), elemVal);

			for (ElementInput var : element.getVariables()) {
				ElementValue v = elemValMap.get(var.getCrossReference()
						.getCode());
				if (v.getElement().getDataType().equals("number")) {
					engine.put(var.getAlias(), Double.valueOf(v.getValue()));
				}
				if (v.getElement().getDataType().equals("string")) {
					engine.put(var.getAlias(), v.getValue());
				}

			}
			if (element.getDataType().equals("number")) {
				Object result = engine.eval(this.formulas
						.get(element.getCode()).getExpression());
				if (result instanceof Double) {
					elemVal.setValue(Double.toString((Double) result));
				}
				if (result instanceof Float) {
					elemVal.setValue(Float.toString((Float) result));
				}
				if (result instanceof Integer) {
					elemVal.setValue(Integer.toString((Integer) result));
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
