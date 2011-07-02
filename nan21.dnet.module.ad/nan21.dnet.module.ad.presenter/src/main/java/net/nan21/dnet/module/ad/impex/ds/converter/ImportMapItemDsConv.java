/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.impex.business.service.IImportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMapItem;

public class ImportMapItemDsConv extends
        AbstractDsConverter<ImportMapItemDs, ImportMapItem> implements
        IDsConverter<ImportMapItemDs, ImportMapItem> {

    protected void modelToEntityAttributes(ImportMapItemDs ds, ImportMapItem e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setSequenceNo(ds.getSequenceNo());
        e.setDataSourceName(ds.getDataSource());
        e.setFileName(ds.getFileName());
        e.setActive(ds.getActive());
    }

    protected void modelToEntityReferences(ImportMapItemDs ds, ImportMapItem e)
            throws Exception {

        if (ds.getImportMapId() != null) {
            if (e.getImportMap() == null
                    || !e.getImportMap().getId().equals(ds.getImportMapId())) {
                e.setImportMap((ImportMap) this.em.getReference(
                        ImportMap.class, ds.getImportMapId()));
            }
        } else {
            this.lookup_importMap_ImportMap(ds, e);
        }
    }

    protected void lookup_importMap_ImportMap(ImportMapItemDs ds,
            ImportMapItem e) throws Exception {
        ImportMap x = null;
        try {
            x = ((IImportMapService) getService(IImportMapService.class))
                    .findByName(ds.getClientId(), ds.getImportMapName());
        } catch (javax.persistence.NoResultException exception) {

        }
        e.setImportMap(x);
    }

    @Override
    public void entityToModel(ImportMapItem e, ImportMapItemDs ds)
            throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setSequenceNo(e.getSequenceNo());
        ds.setDataSource(e.getDataSourceName());
        ds.setFileName(e.getFileName());
        ds.setActive(e.getActive());
        ds.setImportMapId(((e.getImportMap() != null)) ? e.getImportMap()
                .getId() : null);
        ds.setImportMapName(((e.getImportMap() != null)) ? e.getImportMap()
                .getName() : null);
    }

}
