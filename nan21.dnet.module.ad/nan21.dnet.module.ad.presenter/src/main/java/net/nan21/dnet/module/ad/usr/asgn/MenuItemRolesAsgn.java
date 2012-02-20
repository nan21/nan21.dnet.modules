package net.nan21.dnet.module.ad.usr.asgn;

import net.nan21.dnet.core.api.annotation.SortField;

import net.nan21.dnet.core.presenter.model.AbstractAsgnModel;
import net.nan21.dnet.module.ad.usr.domain.entity.Role;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = Role.class, sort = { @SortField(field = MenuItemRolesAsgn.fNAME) })
public class MenuItemRolesAsgn extends AbstractAsgnModel<Role> {

    public static final String fID = "id";
    public static final String fNAME = "name";
    public static final String fDESCRIPTION = "description";

    @DsField(path = "id")
    private Long id;

    @DsField(path = "name")
    private String name;

    @DsField(path = "description")
    private String description;

    public MenuItemRolesAsgn() {
    }

    public MenuItemRolesAsgn(Role e) {
        super();
        this.id = e.getId();
        this.name = e.getName();
        this.description = e.getDescription();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
