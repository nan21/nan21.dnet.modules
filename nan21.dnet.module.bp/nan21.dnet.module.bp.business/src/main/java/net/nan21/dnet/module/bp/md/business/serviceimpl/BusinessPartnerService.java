/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bp.md.business.service.IBusinessPartnerService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

public class BusinessPartnerService extends
        AbstractEntityService<BusinessPartner> implements
        IBusinessPartnerService {

    public BusinessPartnerService() {
        super();
    }

    public BusinessPartnerService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<BusinessPartner> getEntityClass() {
        return BusinessPartner.class;
    }

    public BusinessPartner findByCode(Long clientId, String code) {
        return (BusinessPartner) this.em
                .createNamedQuery(BusinessPartner.NQ_FIND_BY_CODE)
                .setParameter("pClientId", clientId)
                .setParameter("pCode", code).getSingleResult();
    }

    public List<BusinessPartner> findByCountry(Country country) {
        return this.findByCountryId(country.getId());
    }

    public List<BusinessPartner> findByCountryId(Long countryId) {
        return (List<BusinessPartner>) this.em
                .createQuery(
                        "select e from BusinessPartner e where e.country.id = :pCountryId",
                        BusinessPartner.class)
                .setParameter("pCountryId", countryId).getResultList();
    }

}
