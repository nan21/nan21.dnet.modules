/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bp.base.domain.entity.CompanyLegalForm;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

public class BusinessPartnerService extends
        AbstractEntityService<BusinessPartner> {

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

    public BusinessPartner findByCode(String code) {
        return (BusinessPartner) this.em
                .createNamedQuery(BusinessPartner.NQ_FIND_BY_CODE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCode", code).getSingleResult();
    }

    public List<BusinessPartner> findByCountry(Country country) {
        return this.findByCountryId(country.getId());
    }

    public List<BusinessPartner> findByCountryId(Long countryId) {
        return (List<BusinessPartner>) this.em
                .createQuery(
                        "select e from BusinessPartner e where e.clientId = :pClientId and  e.country.id = :pCountryId",
                        BusinessPartner.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCountryId", countryId).getResultList();
    }

    public List<BusinessPartner> findByLegalForm(CompanyLegalForm legalForm) {
        return this.findByLegalFormId(legalForm.getId());
    }

    public List<BusinessPartner> findByLegalFormId(Long legalFormId) {
        return (List<BusinessPartner>) this.em
                .createQuery(
                        "select e from BusinessPartner e where e.clientId = :pClientId and  e.legalForm.id = :pLegalFormId",
                        BusinessPartner.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLegalFormId", legalFormId).getResultList();
    }

}
