package net.nan21.dnet.module.ad._presenterjobs;

import net.nan21.dnet.core.presenter.job.AbstractDsJob;

public class DsDummyJobForTest extends AbstractDsJob {
	@Override
	public void execute() {
		System.out.println("-------------------------------DsDummyJobForTest**************  ");		
	}
}