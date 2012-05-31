/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.bp.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.md.bp.business.service.IBusinessPartnerService;
import net.nan21.dnet.module.md.bp.domain.entity.CompanyLegalForm;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.md.bp.domain.entity.BusinessPartner;
import net.nan21.dnet.module.md._businessdelegates.bp.BpCustomerAcctBD;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.md.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.md._businessdelegates.bp.BpVendorAcctBD;

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
                        "select e from BusinessPartner e where e.clientId = :pClientId and e.country.id = :pCountryId",
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
                        "select e from BusinessPartner e where e.clientId = :pClientId and e.legalForm.id = :pLegalFormId",
                        BusinessPartner.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pLegalFormId", legalFormId).getResultList();
    }

    public String getPostingCustomerAcct(BusinessPartner businessPartner,
            Organization organization, AccSchema schema) throws Exception {
        return this.getBusinessDelegate(BpCustomerAcctBD.class).getPostingAcct(
                businessPartner, organization, schema);
    }

    public String getPostingVendorAcct(BusinessPartner businessPartner,
            Organization organization, AccSchema schema) throws Exception {
        return this.getBusinessDelegate(BpVendorAcctBD.class).getPostingAcct(
                businessPartner, organization, schema);
    }

}
