/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.mm.prod.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.bd.uom.domain.entity.Uom;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductAttributeGroup;
import net.nan21.dnet.module.md.mm.prod.domain.entity.ProductManufacturer;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** Product master-data. */
@Entity
@Table(name = Product.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = Product.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = Product.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Product.NQ_FIND_BY_ID, query = "SELECT e FROM Product e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Product.NQ_FIND_BY_IDS, query = "SELECT e FROM Product e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Product.NQ_FIND_BY_CODE, query = "SELECT e FROM Product e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Product.NQ_FIND_BY_NAME, query = "SELECT e FROM Product e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Product extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "MD_PROD";
    public static final String SEQUENCE_NAME = "MD_PROD_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Product.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Product.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "Product.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "Product.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** IconUrl. */
    @Column(name = "ICONURL", length = 255)
    private String iconUrl;

    /** ImageUrl. */
    @Column(name = "IMAGEURL", length = 255)
    private String imageUrl;

    /** ShowInCatalog. */
    @Column(name = "SHOWINCATALOG", nullable = false)
    @NotNull
    private Boolean showInCatalog;

    /** Description. */
    @Column(name = "DESCRIPTION", length = 400)
    private String description;

    /** Flag which specifies if it is a physical-storable item. */
    @Column(name = "STORABLE", nullable = false)
    @NotNull
    private Boolean storable;

    /** Purchase. */
    @Column(name = "PURCHASE", nullable = false)
    @NotNull
    private Boolean purchase;

    /** Sale. */
    @Column(name = "SALE", nullable = false)
    @NotNull
    private Boolean sale;

    /** Weight. */
    @Column(name = "WEIGHT", scale = 2)
    private Float weight;

    /** Volume. */
    @Column(name = "VOLUME", scale = 2)
    private Float volume;

    /** DimWidth. */
    @Column(name = "DIMWIDTH", scale = 2)
    private Float dimWidth;

    /** DimHeight. */
    @Column(name = "DIMHEIGHT", scale = 2)
    private Float dimHeight;

    /** DimDepth. */
    @Column(name = "DIMDEPTH", scale = 2)
    private Float dimDepth;

    /** ManufacturerProductNo. */
    @Column(name = "MANUFACTURERPRODUCTNO", length = 32)
    private String manufacturerProductNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
    @JoinColumn(name = "DEFAULTUOM_ID", referencedColumnName = "ID")
    private Uom defaultUom;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
    @JoinColumn(name = "WEIGHTUOM_ID", referencedColumnName = "ID")
    private Uom weightUom;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
    @JoinColumn(name = "VOLUMEUOM_ID", referencedColumnName = "ID")
    private Uom volumeUom;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Uom.class)
    @JoinColumn(name = "DIMUOM_ID", referencedColumnName = "ID")
    private Uom dimUom;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductManufacturer.class)
    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "ID")
    private ProductManufacturer manufacturer;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ProductAttributeGroup.class)
    @JoinColumn(name = "ATTRIBUTEGROUP_ID", referencedColumnName = "ID")
    private ProductAttributeGroup attributeGroup;

    @ManyToMany
    @JoinTable(name = "MD_PROD_PRODCATEGS")
    private Collection<ProductCategory> categories;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ProductAttributeValue.class, mappedBy = "product", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<ProductAttributeValue> attributes;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getShowInCatalog() {
        return this.showInCatalog;
    }

    public void setShowInCatalog(Boolean showInCatalog) {
        this.showInCatalog = showInCatalog;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStorable() {
        return this.storable;
    }

    public void setStorable(Boolean storable) {
        this.storable = storable;
    }

    public Boolean getPurchase() {
        return this.purchase;
    }

    public void setPurchase(Boolean purchase) {
        this.purchase = purchase;
    }

    public Boolean getSale() {
        return this.sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public Float getWeight() {
        return this.weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getVolume() {
        return this.volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Float getDimWidth() {
        return this.dimWidth;
    }

    public void setDimWidth(Float dimWidth) {
        this.dimWidth = dimWidth;
    }

    public Float getDimHeight() {
        return this.dimHeight;
    }

    public void setDimHeight(Float dimHeight) {
        this.dimHeight = dimHeight;
    }

    public Float getDimDepth() {
        return this.dimDepth;
    }

    public void setDimDepth(Float dimDepth) {
        this.dimDepth = dimDepth;
    }

    public String getManufacturerProductNo() {
        return this.manufacturerProductNo;
    }

    public void setManufacturerProductNo(String manufacturerProductNo) {
        this.manufacturerProductNo = manufacturerProductNo;
    }

    @Transient
    public String getBusinessObject() {
        return "Product";
    }

    public void setBusinessObject(String businessObject) {

    }

    public Uom getDefaultUom() {
        return this.defaultUom;
    }

    public void setDefaultUom(Uom defaultUom) {
        this.defaultUom = defaultUom;
    }

    public Uom getWeightUom() {
        return this.weightUom;
    }

    public void setWeightUom(Uom weightUom) {
        this.weightUom = weightUom;
    }

    public Uom getVolumeUom() {
        return this.volumeUom;
    }

    public void setVolumeUom(Uom volumeUom) {
        this.volumeUom = volumeUom;
    }

    public Uom getDimUom() {
        return this.dimUom;
    }

    public void setDimUom(Uom dimUom) {
        this.dimUom = dimUom;
    }

    public ProductManufacturer getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(ProductManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ProductAttributeGroup getAttributeGroup() {
        return this.attributeGroup;
    }

    public void setAttributeGroup(ProductAttributeGroup attributeGroup) {
        this.attributeGroup = attributeGroup;
    }

    public Collection<ProductCategory> getCategories() {
        return this.categories;
    }

    public void setCategories(Collection<ProductCategory> categories) {
        this.categories = categories;
    }

    public Collection<ProductAttributeValue> getAttributes() {
        return this.attributes;
    }

    public void setAttributes(Collection<ProductAttributeValue> attributes) {
        this.attributes = attributes;
    }

    public void addToAttributes(ProductAttributeValue e) {
        if (this.attributes == null) {
            this.attributes = new ArrayList<ProductAttributeValue>();
        }
        e.setProduct(this);
        this.attributes.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getShowInCatalog() == null) {
            event.updateAttributeWithObject("showInCatalog", false);
        }
        if (this.getStorable() == null) {
            event.updateAttributeWithObject("storable", false);
        }
        if (this.getPurchase() == null) {
            event.updateAttributeWithObject("purchase", false);
        }
        if (this.getSale() == null) {
            event.updateAttributeWithObject("sale", false);
        }
        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
        if (this.getCode() == null || this.getCode().equals("")) {
            event.updateAttributeWithObject("code", "P-" + this.getId());
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
