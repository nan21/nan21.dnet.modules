package net.nan21.dnet.module.mm.md.asgn;

import net.nan21.dnet.core.api.annotation.SortField;

import net.nan21.dnet.core.presenter.model.AbstractAsgnModel;
import net.nan21.dnet.module.mm.md.domain.entity.ProductAttribute;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductAttribute.class, sort = { @SortField(field = AttributesOfAttrGroupAsgn.fNAME) })
public class AttributesOfAttrGroupAsgn extends
        AbstractAsgnModel<ProductAttribute> {

    public static final String fID = "id";
    public static final String fNAME = "name";
    public static final String fDESCRIPTION = "description";

    @DsField(path = "id")
    private Long id;

    @DsField(path = "name")
    private String name;

    @DsField(path = "description")
    private String description;

    public AttributesOfAttrGroupAsgn() {
    }

    public AttributesOfAttrGroupAsgn(ProductAttribute e) {
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
