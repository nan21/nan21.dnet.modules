package net.nan21.dnet.module.ad._businessdelegates;

import java.util.List;
 
import net.nan21.dnet.core.api.ISystemConfig;
import net.nan21.dnet.core.api.setup.IStartupParticipant;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad.system.domain.entity.SysParam;
 
public class Startup_AD extends AbstractBusinessDelegate implements IStartupParticipant{
   
	public void execute() throws Exception {
		ISystemConfig syscfg = this.getSystemConfig();
		
		List<Client> clients = this.getEntityManager().createQuery("select e from " +Client.class.getSimpleName()+ " e", Client.class)			 
				.getResultList();			
		
		for (Client client : clients) {
			List<SysParam> params = this.getEntityManager().createQuery("select e from " +SysParam.class.getSimpleName()+ " e" +
					" where e.active = true and e.clientId = :clientId", SysParam.class)
					.setParameter("clientId", client.getId())
					.getResultList();			
			for (SysParam param: params) {
				syscfg.addSysParam(client.getCode(), param.getCode(), param.getValue());
				System.out.println(" sysconfig paramvalue: " + client.getCode() + " -> " + param.getCode() + " = "+ param.getValue() );
			}
		}
	}

	 
}
