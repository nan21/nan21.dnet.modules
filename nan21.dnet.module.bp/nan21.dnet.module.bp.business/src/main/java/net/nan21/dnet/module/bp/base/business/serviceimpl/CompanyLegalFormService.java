/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.base.business.serviceimpl;

import java.util.List;
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

    public CompanyLegalForm findByName(Long clientId, Country country,
            String name) {
        return (CompanyLegalForm) this.em
                .createNamedQuery(CompanyLegalForm.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pCountry", country).setParameter("pName", name)
                .getSingleResult();
    }

    public CompanyLegalForm findByName(Long clientId, Long countryId,
            String name) {
        return (CompanyLegalForm) this.em
                .createNamedQuery(CompanyLegalForm.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pCountryId", countryId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<CompanyLegalForm> findByCountry(Country country) {
        return this.findByCountryId(country.getId());
    }

    public List<CompanyLegalForm> findByCountryId(Long countryId) {
        return (List<CompanyLegalForm>) this.em
                .createQuery(
                        "select e from CompanyLegalForm e where e.country.id = :pCountryId",
                        CompanyLegalForm.class)
                .setParameter("pCountryId", countryId).getResultList();
    }

}
