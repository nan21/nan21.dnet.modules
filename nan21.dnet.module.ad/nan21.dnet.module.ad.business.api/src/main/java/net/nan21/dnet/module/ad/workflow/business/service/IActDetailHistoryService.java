/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.workflow.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.workflow.domain.entity.ActByteArray;

import net.nan21.dnet.module.ad.workflow.domain.entity.ActDetailHistory;

public interface IActDetailHistoryService extends
        IEntityService<ActDetailHistory> {

    public List<ActDetailHistory> findByByteArray(ActByteArray byteArray);

    public List<ActDetailHistory> findByByteArrayId(String byteArrayId);

}
