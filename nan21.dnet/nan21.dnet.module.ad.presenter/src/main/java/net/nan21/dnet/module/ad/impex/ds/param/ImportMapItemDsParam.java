/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.impex.ds.param;

import net.nan21.dnet.core.presenter.model.EmptyParam;

public class ImportMapItemDsParam extends EmptyParam {

    public static final String fIMPORTFILELOCATION = "importFileLocation";
    public static final String fIMPORTDATASOURCE = "importDataSource";

    private String importFileLocation;
    private String importDataSource;

    public String getImportFileLocation() {
        return this.importFileLocation;
    }

    public void setImportFileLocation(String importFileLocation) {
        this.importFileLocation = importFileLocation;
    }

    public String getImportDataSource() {
        return this.importDataSource;
    }

    public void setImportDataSource(String importDataSource) {
        this.importDataSource = importDataSource;
    }

}
