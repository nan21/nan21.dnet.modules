/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.standards.business.service;

import net.nan21.dnet.core.api.service.IEntityService;

import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

public interface IClassificationSystemService extends
        IEntityService<ClassificationSystem> { 

    public ClassificationSystem findByCode(String code);

    public ClassificationSystem findByName(String name);

}
