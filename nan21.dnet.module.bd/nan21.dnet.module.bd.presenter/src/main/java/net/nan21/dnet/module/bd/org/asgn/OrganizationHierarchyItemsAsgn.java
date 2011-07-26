package net.nan21.dnet.module.bd.org.asgn;

import net.nan21.dnet.core.presenter.model.AbstractAsgnModel;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.core.api.annotation.DsField;

public class OrganizationHierarchyItemsAsgn extends
        AbstractAsgnModel<Organization> {

    public static final String fID = "id";
    public static final String fCODE = "code";
    public static final String fNAME = "name";

    @DsField(path = "id")
    private Long id;

    @DsField(path = "code")
    private String code;

    @DsField(path = "name")
    private String name;

    public OrganizationHierarchyItemsAsgn() {
    }

    public OrganizationHierarchyItemsAsgn(Organization e) {
        super();
        this.id = e.getId();
        this.code = e.getCode();
        this.name = e.getName();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
