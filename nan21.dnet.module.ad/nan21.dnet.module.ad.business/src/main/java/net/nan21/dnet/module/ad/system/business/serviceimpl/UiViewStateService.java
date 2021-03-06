/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.system.business.serviceimpl;

import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.system.business.service.IUiViewStateService;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.system.domain.entity.UiViewState;

public class UiViewStateService extends AbstractEntityService<UiViewState>
        implements IUiViewStateService {

    public UiViewStateService() {
        super();
    }

    public UiViewStateService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<UiViewState> getEntityClass() {
        return UiViewState.class;
    }

}
