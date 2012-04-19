/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.client.ds.model;

import net.nan21.dnet.core.api.service.IDsService;
import net.nan21.dnet.core.presenter.model.base.X_AbstractAuditedDs;
import net.nan21.dnet.core.presenter.service.AbstractDsService;
import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.module.ad.client.ds.param.ClientDsParam;

import net.nan21.dnet.module.ad.client.domain.entity.Client;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Client.class)
public class MyClientDs extends X_AbstractAuditedDs<Client> {

    public static final String fNAME = "name";
    public static final String fCODE = "code";
    public static final String fNOTES = "notes";
    public static final String fMAINTENANCELANGUAGE = "maintenanceLanguage";
    public static final String fADMINROLE = "adminRole";

    @DsField()
    private String name;

    @DsField()
    private String code;

    @DsField()
    private String notes;

    @DsField()
    private String maintenanceLanguage;

    @DsField()
    private String adminRole;

    public MyClientDs() {
        super();
    }

    public MyClientDs(Client e) {
        super(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMaintenanceLanguage() {
        return this.maintenanceLanguage;
    }

    public void setMaintenanceLanguage(String maintenanceLanguage) {
        this.maintenanceLanguage = maintenanceLanguage;
    }

    public String getAdminRole() {
        return this.adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

}
