/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ux.example.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.ux.example.business.service.ILandFormService;
import net.nan21.dnet.module.ux.example.domain.entity.LandFormType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ux.example.domain.entity.LandForm;

public class LandFormService extends AbstractEntityService<LandForm> implements
        ILandFormService {

    public LandFormService() {
        super();
    }

    public LandFormService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<LandForm> getEntityClass() {
        return LandForm.class;
    }

    public LandForm findByName(Long clientId, LandFormType type, String name) {
        return (LandForm) this.em.createNamedQuery(LandForm.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pType", type).setParameter("pName", name)
                .getSingleResult();
    }

    public LandForm findByName(Long clientId, Long typeId, String name) {
        return (LandForm) this.em
                .createNamedQuery(LandForm.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pTypeId", typeId).setParameter("pName", name)
                .getSingleResult();
    }

    public List<LandForm> findByType(LandFormType type) {
        return this.findByTypeId(type.getId());
    }

    public List<LandForm> findByTypeId(Long typeId) {
        return (List<LandForm>) this.em
                .createQuery(
                        "select e from LandForm e where e.type.id = :pTypeId",
                        LandForm.class).setParameter("pTypeId", typeId)
                .getResultList();
    }

    public List<LandForm> findByCountry(Country country) {
        return this.findByCountryId(country.getId());
    }

    public List<LandForm> findByCountryId(Long countryId) {
        return (List<LandForm>) this.em
                .createQuery(
                        "select e from LandForm e where e.country.id = :pCountryId",
                        LandForm.class).setParameter("pCountryId", countryId)
                .getResultList();
    }

}
