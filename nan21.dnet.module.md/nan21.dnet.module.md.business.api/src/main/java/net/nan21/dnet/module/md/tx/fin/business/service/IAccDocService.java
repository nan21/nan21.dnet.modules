/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.tx.fin.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.bd.acc.domain.entity.AccSchema;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.bd.tx.domain.entity.TxDocType;
import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDocLine;

import net.nan21.dnet.module.md.tx.fin.domain.entity.AccDoc;

public interface IAccDocService extends IEntityService<AccDoc> {

    public List<AccDoc> findByOrg(Organization org);

    public List<AccDoc> findByOrgId(Long orgId);

    public List<AccDoc> findByAccSchema(AccSchema accSchema);

    public List<AccDoc> findByAccSchemaId(Long accSchemaId);

    public List<AccDoc> findByDocType(TxDocType docType);

    public List<AccDoc> findByDocTypeId(Long docTypeId);

    public List<AccDoc> findByLines(AccDocLine lines);

    public List<AccDoc> findByLinesId(Long linesId);

}
