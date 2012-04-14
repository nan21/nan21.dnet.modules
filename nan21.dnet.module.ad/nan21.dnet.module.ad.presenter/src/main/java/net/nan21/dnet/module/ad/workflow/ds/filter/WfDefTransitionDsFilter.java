/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.workflow.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDsFilter;

public class WfDefTransitionDsFilter extends AbstractAuditableDsFilter {

    private Long processId;

    private Long processId_From;
    private Long processId_To;

    private String process;

    private Long sourceId;

    private Long sourceId_From;
    private Long sourceId_To;

    private String source;

    private Long targetId;

    private Long targetId_From;
    private Long targetId_To;

    private String target;

    public Long getProcessId() {
        return this.processId;
    }

    public Long getProcessId_From() {
        return this.processId_From;
    }

    public Long getProcessId_To() {
        return this.processId_To;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public void setProcessId_From(Long processId_From) {
        this.processId_From = processId_From;
    }

    public void setProcessId_To(Long processId_To) {
        this.processId_To = processId_To;
    }

    public String getProcess() {
        return this.process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Long getSourceId() {
        return this.sourceId;
    }

    public Long getSourceId_From() {
        return this.sourceId_From;
    }

    public Long getSourceId_To() {
        return this.sourceId_To;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public void setSourceId_From(Long sourceId_From) {
        this.sourceId_From = sourceId_From;
    }

    public void setSourceId_To(Long sourceId_To) {
        this.sourceId_To = sourceId_To;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getTargetId() {
        return this.targetId;
    }

    public Long getTargetId_From() {
        return this.targetId_From;
    }

    public Long getTargetId_To() {
        return this.targetId_To;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public void setTargetId_From(Long targetId_From) {
        this.targetId_From = targetId_From;
    }

    public void setTargetId_To(Long targetId_To) {
        this.targetId_To = targetId_To;
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
