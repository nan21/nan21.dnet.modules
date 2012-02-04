package net.nan21.dnet.module.pj.md.asgn;

import net.nan21.dnet.core.api.annotation.SortField;

import net.nan21.dnet.core.presenter.model.AbstractAsgnModel;
import net.nan21.dnet.module.pj.md.domain.entity.ProjectVersion;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProjectVersion.class, sort = { @SortField(field = IssueAffectedVersionsAsgn.fNAME) })
public class IssueAffectedVersionsAsgn extends
        AbstractAsgnModel<ProjectVersion> {

    public static final String fID = "id";
    public static final String fNAME = "name";

    @DsField(path = "id")
    private Long id;

    @DsField(path = "name")
    private String name;

    public IssueAffectedVersionsAsgn() {
    }

    public IssueAffectedVersionsAsgn(ProjectVersion e) {
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
