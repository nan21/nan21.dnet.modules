/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.ISysDataSourceService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;

public class SysDataSourceService extends AbstractEntityService<SysDataSource>
        implements ISysDataSourceService {

    public SysDataSourceService() {
        super();
    }

    public SysDataSourceService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysDataSource> getEntityClass() {
        return SysDataSource.class;
    }

    public SysDataSource findByName(Long clientId, String name) {
        return (SysDataSource) this.em
                .createNamedQuery(SysDataSource.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pName", name).getSingleResult();
    }

    public SysDataSource findByModel(Long clientId, String model) {
        return (SysDataSource) this.em
                .createNamedQuery(SysDataSource.NQ_FIND_BY_MODEL)
                .setParameter("pClientId", clientId)
                .setParameter("pModel", model).getSingleResult();
    }

    public List<SysDataSource> findByFields(SysDsField fields) {
        return this.findByFieldsId(fields.getId());
    }

    public List<SysDataSource> findByFieldsId(Long fieldsId) {
        return (List<SysDataSource>) this.em
                .createQuery(
                        "select distinct e from SysDataSource e , IN (e.fields) c where c.id = :pFieldsId",
                        SysDataSource.class)
                .setParameter("pFieldsId", fieldsId).getResultList();
    }

    public List<SysDataSource> findByServiceMethods(SysDsService serviceMethods) {
        return this.findByServiceMethodsId(serviceMethods.getId());
    }

    public List<SysDataSource> findByServiceMethodsId(Long serviceMethodsId) {
        return (List<SysDataSource>) this.em
                .createQuery(
                        "select distinct e from SysDataSource e , IN (e.serviceMethods) c where c.id = :pServiceMethodsId",
                        SysDataSource.class)
                .setParameter("pServiceMethodsId", serviceMethodsId)
                .getResultList();
    }

}
