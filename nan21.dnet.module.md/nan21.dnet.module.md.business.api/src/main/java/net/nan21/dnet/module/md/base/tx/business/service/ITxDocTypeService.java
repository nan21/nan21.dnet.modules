/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.acc.domain.entity.AccJournal;
import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocSequence;

import net.nan21.dnet.module.md.base.tx.domain.entity.TxDocType;

public interface ITxDocTypeService extends IEntityService<TxDocType> {

    public TxDocType findByName(String name);

    public List<TxDocType> findByDocSequence(TxDocSequence docSequence);

    public List<TxDocType> findByDocSequenceId(Long docSequenceId);

    public List<TxDocType> findByJournal(AccJournal journal);

    public List<TxDocType> findByJournalId(Long journalId);

}
