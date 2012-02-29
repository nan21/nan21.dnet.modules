/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.ad.usr.business.service.IBookmarkService;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

public class BookmarkService extends AbstractEntityService<Bookmark> implements
        IBookmarkService {

    public BookmarkService() {
        super();
    }

    public BookmarkService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<Bookmark> getEntityClass() {
        return Bookmark.class;
    }

    public Bookmark findByName(String owner, String name) {
        return (Bookmark) this.em.createNamedQuery(Bookmark.NQ_FIND_BY_NAME)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pOwner", owner).setParameter("pName", name)
                .getSingleResult();
    }

    public List<Bookmark> findByParent(Bookmark parent) {
        return this.findByParentId(parent.getId());
    }

    public List<Bookmark> findByParentId(Long parentId) {
        return (List<Bookmark>) this.em
                .createQuery(
                        "select e from Bookmark e where e.clientId = :pClientId and e.parent.id = :pParentId",
                        Bookmark.class)
                .setParameter("pClientId", Session.user.get().getClientId())
                .setParameter("pParentId", parentId).getResultList();
    }

}
