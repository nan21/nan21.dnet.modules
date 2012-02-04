/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.impex.business.service.IExportJobService;
import net.nan21.dnet.module.ad.impex.business.service.IExportMapService;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJob;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportMap;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.impex.ds.model.ExportJobItemDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ExportJobItem;

public class ExportJobItemDsConv extends
        AbstractDsConverter<ExportJobItemDs, ExportJobItem> implements
        IDsConverter<ExportJobItemDs, ExportJobItem> {

    protected void modelToEntityReferences(ExportJobItemDs ds, ExportJobItem e)
            throws Exception {
        if (ds.getJobId() != null) {
            if (e.getJob() == null || !e.getJob().getId().equals(ds.getJobId())) {
                e.setJob((ExportJob) this.em.find(ExportJob.class,
                        ds.getJobId()));
            }
        } else {
            this.lookup_job_ExportJob(ds, e);
        }
        if (ds.getMapId() != null) {
            if (e.getMap() == null || !e.getMap().getId().equals(ds.getMapId())) {
                e.setMap((ExportMap) this.em.find(ExportMap.class,
                        ds.getMapId()));
            }
        } else {
            this.lookup_map_ExportMap(ds, e);
        }
    }

    protected void lookup_job_ExportJob(ExportJobItemDs ds, ExportJobItem e)
            throws Exception {
        if (ds.getJobName() != null && !ds.getJobName().equals("")) {
            ExportJob x = null;
            try {
                x = ((IExportJobService) findEntityService(ExportJob.class))
                        .findByName(ds.getClientId(), ds.getJobName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ExportJob` reference:  `jobName` = "
                                + ds.getJobName() + "  ");
            }
            e.setJob(x);

        } else {
            e.setJob(null);
        }
    }

    protected void lookup_map_ExportMap(ExportJobItemDs ds, ExportJobItem e)
            throws Exception {
        if (ds.getMapName() != null && !ds.getMapName().equals("")) {
            ExportMap x = null;
            try {
                x = ((IExportMapService) findEntityService(ExportMap.class))
                        .findByName(ds.getClientId(), ds.getMapName());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `ExportMap` reference:  `mapName` = "
                                + ds.getMapName() + "  ");
            }
            e.setMap(x);

        } else {
            e.setMap(null);
        }
    }

}
