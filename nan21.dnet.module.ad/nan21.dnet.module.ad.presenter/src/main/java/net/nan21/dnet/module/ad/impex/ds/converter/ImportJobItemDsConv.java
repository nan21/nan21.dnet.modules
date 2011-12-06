/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.impex.business.service.IImportJobService;
import net.nan21.dnet.module.ad.impex.business.service.IImportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.impex.ds.model.ImportJobItemDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportJobItem;

public class ImportJobItemDsConv extends
        AbstractDsConverter<ImportJobItemDs, ImportJobItem> implements
        IDsConverter<ImportJobItemDs, ImportJobItem> {

    protected void modelToEntityReferences(ImportJobItemDs ds, ImportJobItem e)
            throws Exception {
        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((ImportJob) this.em.find(ImportJob.class,
                        ds.getJobId()));
            }
        } else {
            this.lookup_job_ImportJob(ds, e);
        }
        if (ds.getMapId() != null) {
            if (e.getMap() == null || !e.getMap().getId().equals(ds.getMapId())) {
                e.setMap((ImportMap) this.em.find(ImportMap.class,
                        ds.getMapId()));
            }
        } else {
            this.lookup_map_ImportMap(ds, e);
        }
    }

    protected void lookup_job_ImportJob(ImportJobItemDs ds, ImportJobItem e)
            throws Exception {
        if (ds.getJobName() != null && !ds.getJobName().equals("")) {
            ImportJob x = null;
            try {
                x = ((IImportJobService) getService(IImportJobService.class))
                        .findByName(ds.getClientId(), ds.getJobName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ImportJob` reference:  `jobName` = "
                                + ds.getJobName() + "  ");
            }
            e.setJob(x);

        } else {
            e.setJob(null);
        }
    }

    protected void lookup_map_ImportMap(ImportJobItemDs ds, ImportJobItem e)
            throws Exception {
        if (ds.getMapName() != null && !ds.getMapName().equals("")) {
            ImportMap x = null;
            try {
                x = ((IImportMapService) getService(IImportMapService.class))
                        .findByName(ds.getClientId(), ds.getMapName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ImportMap` reference:  `mapName` = "
                                + ds.getMapName() + "  ");
            }
            e.setMap(x);

        } else {
            e.setMap(null);
        }
    }

}
