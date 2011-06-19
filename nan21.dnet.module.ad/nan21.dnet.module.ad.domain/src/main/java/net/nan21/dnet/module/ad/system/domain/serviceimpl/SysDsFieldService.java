/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.domain.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.domain.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.domain.entity.SysDataSource;
import net.nan21.dnet.module.ad.system.domain.service.ISysDsFieldService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.SysDsField;

public class SysDsFieldService extends AbstractEntityService<SysDsField>
        implements ISysDsFieldService {

    public SysDsFieldService() {
        super();
    }

    public SysDsFieldService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<SysDsField> getEntityClass() {
        return SysDsField.class;
    }

    public SysDsField findByName(Long clientId, SysDataSource dataSource,
            String name) {
        return (SysDsField) this.em
                .createNamedQuery(SysDsField.NQ_FIND_BY_NAME)
                .setParameter("pClientId", clientId)
                .setParameter("pDataSource", dataSource)
                .setParameter("pName", name).getSingleResult();
    }

    public SysDsField findByName(Long clientId, Long dataSourceId, String name) {
        return (SysDsField) this.em
                .createNamedQuery(SysDsField.NQ_FIND_BY_NAME_PRIMITIVE)
                .setParameter("pClientId", clientId)
                .setParameter("pDataSourceId", dataSourceId)
                .setParameter("pName", name).getSingleResult();
    }

    public List<SysDsField> findByDataSource(SysDataSource dataSource) {
        return this.findByDataSourceId(dataSource.getId());
    }

    public List<SysDsField> findByDataSourceId(Long dataSourceId) {
        return (List<SysDsField>) this.em
                .createQuery(
                        "select e from SysDsField where e.dataSource.id = :pDataSourceId",
                        SysDsField.class)
                .setParameter("pDataSourceId", dataSourceId).getResultList();
    }

}
