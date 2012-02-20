/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bp.base.business.service.ICompanyLegalFormService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.bp.base.domain.entity.CompanyLegalForm;

public class CompanyLegalFormService extends
        AbstractEntityService<CompanyLegalForm> implements
        ICompanyLegalFormService {

    public CompanyLegalFormService() {
        super();
    }

    public CompanyLegalFormService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<CompanyLegalForm> getEntityClass() {
        return CompanyLegalForm.class;
    }

    public CompanyLegalForm findByName(Country country, String name) {
        return (CompanyLegalForm) this.em
                .createNamedQuery(CompanyLegalForm.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCountry", country).setParameter("pName", name)
                .getSingleResult();
    }

    public CompanyLegalForm findByName(Long countryId, String name) {
        return (CompanyLegalForm) this.em
                .createNamedQuery(CompanyLegalForm.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCountryId", countryId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<CompanyLegalForm> findByCountry(Country country) {
        return this.findByCountryId(country.getId());
    }

    public List<CompanyLegalForm> findByCountryId(Long countryId) {
        return (List<CompanyLegalForm>) this.em
                .createQuery(
                        "select e from CompanyLegalForm e where e.clientId = :pClientId and  e.country.id = :pCountryId",
                        CompanyLegalForm.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pCountryId", countryId).getResultList();
    }

}
