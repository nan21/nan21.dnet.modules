/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.tx.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class TxDocTypeDsFilter extends AbstractTypeDsFilter {

    private Long journalId;

    private Long journalId_From;
    private Long journalId_To;

    private String journal;

    private String category;

    public Long getJournalId() {
        return this.journalId;
    }

    public Long getJournalId_From() {
        return this.journalId_From;
    }

    public Long getJournalId_To() {
        return this.journalId_To;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public void setJournalId_From(Long journalId_From) {
        this.journalId_From = journalId_From;
    }

    public void setJournalId_To(Long journalId_To) {
        this.journalId_To = journalId_To;
    }

    public String getJournal() {
        return this.journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
