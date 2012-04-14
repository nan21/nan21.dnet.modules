/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.data.ds.filter;

import net.nan21.dnet.core.presenter.model.base.AbstractTypeDsFilter;

public class AttachmentTypeDsFilter extends AbstractTypeDsFilter {

    private String category;

    private String uploadPath;

    private String baseUrl;

    private String useInContext;

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUploadPath() {
        return this.uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUseInContext() {
        return this.useInContext;
    }

    public void setUseInContext(String useInContext) {
        this.useInContext = useInContext;
    }

}
