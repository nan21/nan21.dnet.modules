package net.nan21.dnet.module.ad.usr.asgn;

import net.nan21.dnet.core.api.annotation.SortField;

import net.nan21.dnet.core.presenter.model.AbstractAsgnModel;
import net.nan21.dnet.module.ad.usr.domain.entity.User;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = User.class, sort = { @SortField(field = RolesOfUserAsgn.fCODE) })
public class RolesOfUserAsgn extends AbstractAsgnModel<User> {

    public static final String fID = "id";
    public static final String fCODE = "code";
    public static final String fNAME = "name";

    @DsField(path = "id")
    private Long id;

    @DsField(path = "code")
    private String code;

    @DsField(path = "name")
    private String name;

    public RolesOfUserAsgn() {
    }

    public RolesOfUserAsgn(User e) {
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
