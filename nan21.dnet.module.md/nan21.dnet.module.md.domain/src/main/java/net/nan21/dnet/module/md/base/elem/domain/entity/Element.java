/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.md.base.elem.domain.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractTypeWithCode;
import net.nan21.dnet.module.md.base.elem.domain.entity.ElementType;
import net.nan21.dnet.module.md.base.elem.domain.entity.Engine;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;
import org.hibernate.validator.constraints.NotBlank;

/** Element. */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ENTITYTYPE", discriminatorType = DiscriminatorType.STRING, length = 32)
@Table(name = Element.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = Element.TABLE_NAME + "_UK1", columnNames = {
                "CLIENTID", "CODE" }),
        @UniqueConstraint(name = Element.TABLE_NAME + "_UK2", columnNames = {
                "CLIENTID", "NAME" }) })
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = Element.NQ_FIND_BY_ID, query = "SELECT e FROM Element e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Element.NQ_FIND_BY_IDS, query = "SELECT e FROM Element e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Element.NQ_FIND_BY_CODE, query = "SELECT e FROM Element e WHERE e.clientId = :pClientId and  e.code = :pCode ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = Element.NQ_FIND_BY_NAME, query = "SELECT e FROM Element e WHERE e.clientId = :pClientId and  e.name = :pName ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class Element extends AbstractTypeWithCode {

    public static final String TABLE_NAME = "MD_ELEMENT";
    public static final String SEQUENCE_NAME = "MD_ELEMENT_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "Element.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "Element.findByIds";

    /**
     * Named query find by unique key: Code.
     */
    public static final String NQ_FIND_BY_CODE = "Element.findByCode";

    /**
     * Named query find by unique key: Name.
     */
    public static final String NQ_FIND_BY_NAME = "Element.findByName";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** EntityType. */
    @Column(name = "ENTITYTYPE", length = 32)
    private String entityType;

    /** Calculation. */
    @Column(name = "CALCULATION", nullable = false, length = 32)
    @NotBlank
    private String calculation;

    /** DataType. */
    @Column(name = "DATATYPE", nullable = false, length = 32)
    @NotBlank
    private String dataType;

    /** SequenceNo. */
    @Column(name = "SEQUENCENO", nullable = false)
    @NotNull
    private Integer sequenceNo;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Engine.class)
    @JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
    private Engine engine;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ElementType.class)
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    private ElementType type;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ElementInput.class, mappedBy = "element", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<ElementInput> variables;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ElementFormula.class, mappedBy = "element", cascade = CascadeType.ALL)
    @CascadeOnDelete
    private Collection<ElementFormula> formulas;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getCalculation() {
        return this.calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getSequenceNo() {
        return this.sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public ElementType getType() {
        return this.type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public Collection<ElementInput> getVariables() {
        return this.variables;
    }

    public void setVariables(Collection<ElementInput> variables) {
        this.variables = variables;
    }

    public void addToVariables(ElementInput e) {
        if (this.variables == null) {
            this.variables = new ArrayList<ElementInput>();
        }
        e.setElement(this);
        this.variables.add(e);
    }

    public Collection<ElementFormula> getFormulas() {
        return this.formulas;
    }

    public void setFormulas(Collection<ElementFormula> formulas) {
        this.formulas = formulas;
    }

    public void addToFormulas(ElementFormula e) {
        if (this.formulas == null) {
            this.formulas = new ArrayList<ElementFormula>();
        }
        e.setElement(this);
        this.formulas.add(e);
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

        if (this.getActive() == null) {
            event.updateAttributeWithObject("active", false);
        }
    }

    public void aboutToUpdate(DescriptorEvent event) {
        super.aboutToUpdate(event);
        event.updateAttributeWithObject("modifiedAt", new Date());
        event.updateAttributeWithObject("modifiedBy", Session.user.get()
                .getUsername());
    }

}
