/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.impex.ds.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.base.AbstractTypeDs;
import net.nan21.dnet.module.ad.impex.domain.entity.ImportMap;

@Ds(entity = ImportMap.class, sort = { @SortField(field = ImportMapDs.fNAME) })
public class ImportMapDs extends AbstractTypeDs<ImportMap> {

    public static final String fPATH = "path";

    @DsField()
    private String path;

    public ImportMapDs() {
        super();
    }

    public ImportMapDs(ImportMap e) {
        super(e);
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
