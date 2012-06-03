/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.tx.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class TxDocSequenceDsFilter extends AbstractTypeDsFilter {

    private Integer firstNo;

    private Integer firstNo_From;
    private Integer firstNo_To;

    private Integer lastNo;

    private Integer lastNo_From;
    private Integer lastNo_To;

    private Integer nextNo;

    private Integer nextNo_From;
    private Integer nextNo_To;

    private Integer incrementBy;

    private Integer incrementBy_From;
    private Integer incrementBy_To;

    private String prefix;

    private String suffix;

    public Integer getFirstNo() {
        return this.firstNo;
    }

    public Integer getFirstNo_From() {
        return this.firstNo_From;
    }

    public Integer getFirstNo_To() {
        return this.firstNo_To;
    }

    public void setFirstNo(Integer firstNo) {
        this.firstNo = firstNo;
    }

    public void setFirstNo_From(Integer firstNo_From) {
        this.firstNo_From = firstNo_From;
    }

    public void setFirstNo_To(Integer firstNo_To) {
        this.firstNo_To = firstNo_To;
    }

    public Integer getLastNo() {
        return this.lastNo;
    }

    public Integer getLastNo_From() {
        return this.lastNo_From;
    }

    public Integer getLastNo_To() {
        return this.lastNo_To;
    }

    public void setLastNo(Integer lastNo) {
        this.lastNo = lastNo;
    }

    public void setLastNo_From(Integer lastNo_From) {
        this.lastNo_From = lastNo_From;
    }

    public void setLastNo_To(Integer lastNo_To) {
        this.lastNo_To = lastNo_To;
    }

    public Integer getNextNo() {
        return this.nextNo;
    }

    public Integer getNextNo_From() {
        return this.nextNo_From;
    }

    public Integer getNextNo_To() {
        return this.nextNo_To;
    }

    public void setNextNo(Integer nextNo) {
        this.nextNo = nextNo;
    }

    public void setNextNo_From(Integer nextNo_From) {
        this.nextNo_From = nextNo_From;
    }

    public void setNextNo_To(Integer nextNo_To) {
        this.nextNo_To = nextNo_To;
    }

    public Integer getIncrementBy() {
        return this.incrementBy;
    }

    public Integer getIncrementBy_From() {
        return this.incrementBy_From;
    }

    public Integer getIncrementBy_To() {
        return this.incrementBy_To;
    }

    public void setIncrementBy(Integer incrementBy) {
        this.incrementBy = incrementBy;
    }

    public void setIncrementBy_From(Integer incrementBy_From) {
        this.incrementBy_From = incrementBy_From;
    }

    public void setIncrementBy_To(Integer incrementBy_To) {
        this.incrementBy_To = incrementBy_To;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
