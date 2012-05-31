package net.nan21.dnet.module.ad._presenterdelegates.system;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;

import net.nan21.dnet.core.presenter.service.AbstractDsDelegate;
import net.nan21.dnet.module.ad.system.ds.filter.SysJobDsFilter;

public class SysJobPD extends AbstractDsDelegate {

	public void synchronizeCatalog(SysJobDsFilter ds) throws Exception {
		 
		//ConfigurableApplicationContext  x = (ConfigurableApplicationContext)this.getAppContext();  
		// x.getBeanFactory().getBeanDefinition("UserDsService");
		System.out.println("dddddddddddddd");
	}
}
