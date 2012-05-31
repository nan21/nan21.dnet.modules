/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.acc.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;

public interface IAccJournalService extends IEntityService<AccJournal> {

    public AccJournal findByName(String name);

}
