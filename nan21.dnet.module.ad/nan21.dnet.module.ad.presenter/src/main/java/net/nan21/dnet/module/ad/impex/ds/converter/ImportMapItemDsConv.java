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

    protected void modelToEntityReferences(ImportMapItemDs ds, ImportMapItem e)
            throws Exception {
        if (ds.getImportMapId() != null) {
            if (e.getImportMap() == null
                    || !e.getImportMap().getId().equals(ds.getImportMapId())) {
                e.setImportMap((ImportMap) this.em.find(ImportMap.class,
                        ds.getImportMapId()));
            }
        } else {
            this.lookup_importMap_ImportMap(ds, e);
        }
    }

    protected void lookup_importMap_ImportMap(ImportMapItemDs ds,
            ImportMapItem e) throws Exception {
        if (ds.getImportMapName() != null && !ds.getImportMapName().equals("")) {
            ImportMap x = null;
            try {
                x = ((IImportMapService) getService(IImportMapService.class))
                        .findByName(ds.getClientId(), ds.getImportMapName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ImportMap` reference:  `importMapName` = "
                                + ds.getImportMapName() + "  ");
            }
            e.setImportMap(x);

        } else {
            e.setImportMap(null);
        }
    }

}
