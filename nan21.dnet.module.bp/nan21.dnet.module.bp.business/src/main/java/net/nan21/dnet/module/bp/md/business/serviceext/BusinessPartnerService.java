/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.business.serviceext;

import org.eclipse.persistence.sessions.Session;

import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

public class BusinessPartnerService extends
        net.nan21.dnet.module.bp.md.business.serviceimpl.BusinessPartnerService
        implements IBusinessPartnerService {

	@Override
	protected void preInsert(BusinessPartner e) throws Exception {
		//System.out.println("BusinessPartnerService.preInsert");
		//this.em.unwrap(Session.class).getNextSequenceNumberValue(arg0)
	}
	
	@Override
	protected void onInsert(BusinessPartner e) throws Exception {
		// TODO Auto-generated method stub
		super.onInsert(e);
	}
	
	@Override
	protected void postInsert(BusinessPartner e) throws Exception {
		// TODO Auto-generated method stub
		super.postInsert(e);
	}
}
