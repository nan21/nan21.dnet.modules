package net.nan21.dnet.module.md._businessdelegates.base.period;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalPeriod;
import net.nan21.dnet.module.md.base.period.domain.entity.FiscalYear;

public class PeriodBD extends AbstractBusinessDelegate {

	public void createMonths(FiscalYear year) throws Exception {
		Date start = year.getStartDate();
		Date end = year.getEndDate();

		DateTime first = new DateTime(start).dayOfMonth().withMinimumValue();
		DateTime last = new DateTime(end).dayOfMonth().withMaximumValue();
		DateTime current = first;

		List<FiscalPeriod> periods = new ArrayList<FiscalPeriod>();
		while (current.isBefore(last)) {

			DateTime periodStart = current.dayOfMonth().withMinimumValue();
			DateTime periodEnd = current.dayOfMonth().withMaximumValue();

			FiscalPeriod p = new FiscalPeriod();

			String code = year.getCode() + "-" + periodStart.getMonthOfYear();
			String name = year.getName() + "-"
					+ periodStart.monthOfYear().getAsShortText();

			p.setType("month");
			p.setStartDate(periodStart.toDate());
			p.setEndDate(periodEnd.toDate());
			p.setPosting(true);
			p.setCode(code);
			p.setName(name);
			p.setYear(year);
			periods.add(p);

			DateTime next = current.plusMonths(1);
			current = next;
		}

		this.findEntityService(FiscalPeriod.class).insert(periods);

	}

	public void createQuarters(FiscalYear year) throws Exception {
		Date start = year.getStartDate();
		Date end = year.getEndDate();

		DateTime first = new DateTime(start).dayOfMonth().withMinimumValue();
		DateTime last = new DateTime(end).dayOfMonth().withMaximumValue();
		DateTime current = first;

		List<FiscalPeriod> periods = new ArrayList<FiscalPeriod>();
		int x = 0;
		while (current.isBefore(last)) {
			x++;
			DateTime periodStart = current.dayOfMonth().withMinimumValue();
			DateTime periodEnd = current.plusMonths(2).dayOfMonth()
					.withMaximumValue();

			FiscalPeriod p = new FiscalPeriod();

			String code = year.getCode() + "-Q" + x;
			String name = year.getName() + "-Q" + x;

			p.setType("quarter");
			p.setStartDate(periodStart.toDate());
			p.setEndDate(periodEnd.toDate());

			p.setCode(code);
			p.setName(name);
			p.setYear(year);
			periods.add(p);

			DateTime next = current.plusMonths(3);
			current = next;
		}

		this.findEntityService(FiscalPeriod.class).insert(periods);
	}

	public void createHalfYears(FiscalYear year) throws Exception {
		Date start = year.getStartDate();
		Date end = year.getEndDate();

		DateTime first = new DateTime(start).dayOfMonth().withMinimumValue();
		DateTime last = new DateTime(end).dayOfMonth().withMaximumValue();
		DateTime current = first;

		List<FiscalPeriod> periods = new ArrayList<FiscalPeriod>();
		int x = 0;
		while (current.isBefore(last)) {
			x++;
			DateTime periodStart = current.dayOfMonth().withMinimumValue();
			DateTime periodEnd = current.plusMonths(5).dayOfMonth()
					.withMaximumValue();

			FiscalPeriod p = new FiscalPeriod();

			String code = year.getCode() + "-H" + x;
			String name = year.getName() + "-H" + x;

			p.setType("half-year");
			p.setStartDate(periodStart.toDate());
			p.setEndDate(periodEnd.toDate());

			p.setCode(code);
			p.setName(name);
			p.setYear(year);
			periods.add(p);

			DateTime next = current.plusMonths(6);
			current = next;
		}

		this.findEntityService(FiscalPeriod.class).insert(periods);

	}
}
