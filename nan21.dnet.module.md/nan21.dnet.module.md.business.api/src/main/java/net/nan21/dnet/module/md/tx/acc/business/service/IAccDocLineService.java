/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.acc.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.md.mm.prod.domain.entity.Product;
import net.nan21.dnet.module.md.res.domain.entity.AssetBase;
import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDoc;

import net.nan21.dnet.module.md.tx.acc.domain.entity.AccDocLine;

public interface IAccDocLineService extends IEntityService<AccDocLine> {

    public List<AccDocLine> findByAccDoc(AccDoc accDoc);

    public List<AccDocLine> findByAccDocId(Long accDocId);

    public List<AccDocLine> findByProduct(Product product);

    public List<AccDocLine> findByProductId(Long productId);

    public List<AccDocLine> findByAsset(AssetBase asset);

    public List<AccDocLine> findByAssetId(Long assetId);

}
