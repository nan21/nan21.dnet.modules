/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.ad.usr.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.ad.usr.business.service.IBookmarkService;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.ad.usr.ds.model.BookmarkDs;
import net.nan21.dnet.module.ad.usr.domain.entity.Bookmark;

public class BookmarkDsConv extends AbstractDsConverter<BookmarkDs, Bookmark>
        implements IDsConverter<BookmarkDs, Bookmark> {

    @Override
    protected void modelToEntityReferences(BookmarkDs ds, Bookmark e,
            boolean isInsert) throws Exception {

        if (ds.getParentId() != null) {
            if (e.getParent() == null
                    || !e.getParent().getId().equals(ds.getParentId())) {
                e.setParent((Bookmark) this.em.find(Bookmark.class,
                        ds.getParentId()));
            }
        } else {
            this.lookup_parent_Bookmark(ds, e);
        }

    }

    protected void lookup_parent_Bookmark(BookmarkDs ds, Bookmark e)
            throws Exception {
        if (ds.getOwner() != null && !ds.getOwner().equals("")
                && ds.getParent() != null && !ds.getParent().equals("")) {
            Bookmark x = null;
            try {
                x = ((IBookmarkService) findEntityService(Bookmark.class))
                        .findByName(ds.getOwner(), ds.getParent());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Bookmark` reference:  `owner` = "
                                + ds.getOwner() + " , `parent` = "
                                + ds.getParent() + "  ");
            }
            e.setParent(x);

        } else {
            e.setParent(null);
        }
    }

}
