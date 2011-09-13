package net.nan21.dnet.module.mm.md.asgn;

import net.nan21.dnet.core.api.annotation.SortField;

import net.nan21.dnet.core.presenter.model.AbstractAsgnModel;
import net.nan21.dnet.module.mm.md.domain.entity.ProductCategory;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;

@Ds(entity = ProductCategory.class, jpqlWhere = " e.folder = false ", sort = { @SortField(field = CategoriesOfProductAsgn.fCODE) })
public class CategoriesOfProductAsgn extends AbstractAsgnModel<ProductCategory> {

    public static final String fID = "id";
    public static final String fCODE = "code";
    public static final String fNAME = "name";

    @DsField(path = "id")
    private Long id;

    @DsField(path = "code")
    private String code;

    @DsField(path = "name")
    private String name;

    public CategoriesOfProductAsgn() {
    }

    public CategoriesOfProductAsgn(ProductCategory e) {
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
