package net.nan21.dnet.module.hr._presenterdelegates.payroll;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.hr.payroll.business.service.IPayrollPeriodService;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;
import net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodDs;

public class PayrollPeriodProcessorPD extends AbstractDsDelegate {

	/**
	 * Open period.
	 * @param ds
	 * @throws Exception
	 */
	public void open(PayrollPeriodDs ds) throws Exception {
		IPayrollPeriodService service = ((IPayrollPeriodService) this
				.findEntityService(PayrollPeriod.class));
		PayrollPeriod entity = service.findById(ds.getId());
		service.doOpen(entity);
	}

	/**
	 * Close period
	 * @param ds
	 * @throws Exception
	 */
	public void close(PayrollPeriodDs ds) throws Exception {
		IPayrollPeriodService service = ((IPayrollPeriodService) this
				.findEntityService(PayrollPeriod.class));
		PayrollPeriod entity = service.findById(ds.getId());
		service.doClose(entity);
	}

	/**
	 * Process period
	 * @param ds
	 * @throws Exception
	 */
	public void process(PayrollPeriodDs ds) throws Exception {
		IPayrollPeriodService service = ((IPayrollPeriodService) this
				.findEntityService(PayrollPeriod.class));
		PayrollPeriod entity = service.findById(ds.getId());
		service.doProcess(entity);
	}

	
	/**
	 * Clear period.
	 * @param ds
	 * @throws Exception
	 */
	public void clear(PayrollPeriodDs ds) throws Exception {
		IPayrollPeriodService service = ((IPayrollPeriodService) this
				.findEntityService(PayrollPeriod.class));
		PayrollPeriod entity = service.findById(ds.getId());
		service.doClear(entity);
	}

}