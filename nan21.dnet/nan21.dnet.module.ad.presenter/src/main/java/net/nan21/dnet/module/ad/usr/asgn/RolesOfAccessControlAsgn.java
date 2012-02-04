package net.nan21.dnet.module.ad.usr.asgn;

import net.nan21.dnet.core.api.annotation.SortField;

import net.nan21.dnet.core.presenter.model.AbstractAsgnModel;
import net.nan21.dnet.module.ad.usr.domain.entity.AccessControl;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = AccessControl.class, sort = { @SortField(field = RolesOfAccessControlAsgn.fNAME) })
public class RolesOfAccessControlAsgn extends AbstractAsgnModel<AccessControl> {

    public static final String fID = "id";
    public static final String fNAME = "name";

    @DsField(path = "id")
    private Long id;

    @DsField(path = "name")
    private String name;

    public RolesOfAccessControlAsgn() {
    }

    public RolesOfAccessControlAsgn(AccessControl e) {
        super();
        this.id = e.getId();
        this.name = e.getName();
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

}
