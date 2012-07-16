package net.nan21.dnet.module.md._presenterdelegates.base.period;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.md.base.period.business.service.IFiscalYearService;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;
import net.nan21.dnet.module.md.base.period.ds.model.FiscalYearDs;

public class PeriodPD extends AbstractDsDelegate {

	public void createMonths(FiscalYearDs ds) throws Exception {
		if (!this.canCreatePeriod("month", ds.getId())) {
			throw new Exception("There are already month periods defined for "
					+ ds.getName());
		}
		IFiscalYearService srv = (IFiscalYearService) this
				.findEntityService(FiscalYear.class);
		FiscalYear e = srv.findById(ds.getId());
		srv.doCreateMonths(e);
	}

	public void createQuarters(FiscalYearDs ds) throws Exception {
		if (!this.canCreatePeriod("quarter", ds.getId())) {
			throw new Exception(
					"There are already quarter periods defined for "
							+ ds.getName());
		}
		IFiscalYearService srv = (IFiscalYearService) this
				.findEntityService(FiscalYear.class);
		FiscalYear e = srv.findById(ds.getId());
		srv.doCreateQuarters(e);
	}

	public void createHalfYears(FiscalYearDs ds) throws Exception {
		if (!this.canCreatePeriod("half-year", ds.getId())) {
			throw new Exception(
					"There are already half-year periods defined for "
							+ ds.getName());
		}
		IFiscalYearService srv = (IFiscalYearService) this
				.findEntityService(FiscalYear.class);
		FiscalYear e = srv.findById(ds.getId());
		srv.doCreateHalfYears(e);
	}

	private boolean canCreatePeriod(String type, Long yearId) {
		return true;
	}
}
