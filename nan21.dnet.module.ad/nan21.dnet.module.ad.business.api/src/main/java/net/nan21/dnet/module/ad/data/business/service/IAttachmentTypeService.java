/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.data.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.ad.data.domain.entity.AttachmentType;

public interface IAttachmentTypeService extends IEntityService<AttachmentType> {

    public AttachmentType findByName(String name);

}
