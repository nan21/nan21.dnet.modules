/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.service;

import java.util.List;
import net.nan21.dnet.core.api.service.IEntityService;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

public interface IBookmarkService extends IEntityService<Bookmark> {

    public Bookmark findByName(String owner, String name);

    public List<Bookmark> findByParent(Bookmark parent);

    public List<Bookmark> findByParentId(Long parentId);

}
