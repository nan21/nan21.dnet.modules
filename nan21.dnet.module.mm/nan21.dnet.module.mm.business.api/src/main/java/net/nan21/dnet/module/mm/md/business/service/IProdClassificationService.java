/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.mm.md.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationCode;
import net.nan21.dnet.module.bd.standards.domain.entity.ClassificationSystem;
import net.nan21.dnet.module.mm.md.domain.entity.Product;

import net.nan21.dnet.module.mm.md.domain.entity.ProdClassification;

public interface IProdClassificationService extends
        IEntityService<ProdClassification> {

    public List<ProdClassification> findByProduct(Product product);

    public List<ProdClassification> findByProductId(Long productId);

    public List<ProdClassification> findByClassSystem(
            ClassificationSystem classSystem);

    public List<ProdClassification> findByClassSystemId(Long classSystemId);

    public List<ProdClassification> findByClassCode(ClassificationCode classCode);

    public List<ProdClassification> findByClassCodeId(Long classCodeId);

}
