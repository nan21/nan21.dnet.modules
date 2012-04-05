/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.bp.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.bp.md.domain.entity.BusinessPartner;

import net.nan21.dnet.module.bp.md.domain.entity.BpClassification;

public interface IBpClassificationService extends
        IEntityService<BpClassification> {

    public List<BpClassification> findByBp(BusinessPartner bp);

    public List<BpClassification> findByBpId(Long bpId);

    public List<BpClassification> findByClassSystem(
            ClassificationSystem classSystem);

    public List<BpClassification> findByClassSystemId(Long classSystemId);

    public List<BpClassification> findByClassCode(ClassificationCode classCode);

    public List<BpClassification> findByClassCodeId(Long classCodeId);

}
