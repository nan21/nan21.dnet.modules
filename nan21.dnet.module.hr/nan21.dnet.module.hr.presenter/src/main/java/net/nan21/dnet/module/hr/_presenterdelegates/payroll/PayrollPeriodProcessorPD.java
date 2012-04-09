package net.nan21.dnet.module.hr._presenterdelegates.payroll;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollPeriodService;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDs;

public class PayrollPeriodProcessorPD extends AbstractDsDelegate {

	public void open(PayrollPeriodDs ds) throws Exception {
		IPayrollPeriodService service = ((IPayrollPeriodService) this
				.findEntityService(PayrollPeriod.class));
		PayrollPeriod entity = service.findById(ds.getId());
		entity.setActive(true);
		service.update(entity);
		ds.setActive(true);
	}
	
	public void close(PayrollPeriodDs ds) throws Exception {
		IPayrollPeriodService service = ((IPayrollPeriodService) this
				.findEntityService(PayrollPeriod.class));
		PayrollPeriod entity = service.findById(ds.getId());
		entity.setActive(false);
		entity.setClosed(true);
		service.update(entity);
		ds.setActive(false);
		ds.setClosed(true);
	}
	
	public void process(PayrollPeriodDs ds) throws Exception {
		IPayrollPeriodService service = ((IPayrollPeriodService) this
				.findEntityService(PayrollPeriod.class));
		PayrollPeriod entity = service.findById(ds.getId());
		service.doProcess(entity);
		ds.setProcessed(true);
	}
	
	public void clear(PayrollPeriodDs ds) throws Exception {
		IPayrollPeriodService service = ((IPayrollPeriodService) this
				.findEntityService(PayrollPeriod.class));
		PayrollPeriod entity = service.findById(ds.getId());
		service.doClear(entity);
		ds.setProcessed(false);
	}
	
	
}