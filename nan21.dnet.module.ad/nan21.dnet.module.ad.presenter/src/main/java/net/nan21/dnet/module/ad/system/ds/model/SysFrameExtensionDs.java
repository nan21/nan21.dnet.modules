/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.system.ds.model;

import net.nan21.dnet.core.presenter.model.base.AbstractAuditableDs;

import net.nan21.dnet.module.ad.system.domain.entity.SysFrameExtension;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = SysFrameExtension.class)
public class SysFrameExtensionDs extends AbstractAuditableDs<SysFrameExtension> {

    public static final String fFRAMEFQN = "frameFQN";
    public static final String fSEQUENCENO = "sequenceNo";
    public static final String fFILELOCATION = "fileLocation";
    public static final String fRELATIVEPATH = "relativePath";
    public static final String fACTIVE = "active";
    public static final String fDESCRIPTION = "description";

    @DsField()
    private String frameFQN;

    @DsField()
    private Integer sequenceNo;

    @DsField()
    private String fileLocation;

    @DsField()
    private Boolean relativePath;

    @DsField()
    private Boolean active;

    @DsField()
    private String description;

    public SysFrameExtensionDs() {
        super();
    }

    public SysFrameExtensionDs(SysFrameExtension e) {
        super(e);
    }

    public String getFrameFQN() {
        return this.frameFQN;
    }

    public void setFrameFQN(String frameFQN) {
        this.frameFQN = frameFQN;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getFileLocation() {
        return this.fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Boolean getRelativePath() {
        return this.relativePath;
    }

    public void setRelativePath(Boolean relativePath) {
        this.relativePath = relativePath;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
