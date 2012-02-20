/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bd.standards.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;

import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;

public interface IClassificationCodeService extends
        IEntityService<ClassificationCode> {

    public ClassificationCode findBySyscode(ClassificationSystem classSystem,
            String code);

    public ClassificationCode findBySyscode(Long classSystemId, String code);

    public ClassificationCode findBySysname(ClassificationSystem classSystem,
            String name);

    public ClassificationCode findBySysname(Long classSystemId, String name);

    public List<ClassificationCode> findByClassSystem(
            ClassificationSystem classSystem);

    public List<ClassificationCode> findByClassSystemId(Long classSystemId);

}
