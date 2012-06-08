/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.payroll.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.eventhandler.DefaultEventHandler;
import net.nan21.dnet.core.domain.model.AbstractAuditable;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollElement;
import net.nan21.dnet.module.hr.payroll.domain.entity.PayrollPeriod;
import org.eclipse.persistence.annotations.Customizer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.eclipse.persistence.descriptors.DescriptorEvent;

/** PayrollElementValue. */
@Entity
@Table(name = PayrollElementValue.TABLE_NAME)
@Customizer(DefaultEventHandler.class)
@NamedQueries({
        @NamedQuery(name = PayrollElementValue.NQ_FIND_BY_ID, query = "SELECT e FROM PayrollElementValue e WHERE e.clientId = :pClientId and e.id = :pId ", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
        @NamedQuery(name = PayrollElementValue.NQ_FIND_BY_IDS, query = "SELECT e FROM PayrollElementValue e WHERE e.clientId = :pClientId and e.id in :pIds", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)) })
public class PayrollElementValue extends AbstractAuditable {

    public static final String TABLE_NAME = "HR_PAYROLL_ELEM_VAL";
    public static final String SEQUENCE_NAME = "HR_PAYROLL_ELEM_VAL_SEQ";

    private static final long serialVersionUID = -8865917134914502125L;

    /**
     * Named query find by ID.
     */
    public static final String NQ_FIND_BY_ID = "PayrollElementValue.findById";

    /**
     * Named query find by IDs.
     */
    public static final String NQ_FIND_BY_IDS = "PayrollElementValue.findByIds";

    /**
     * System generated unique identifier.
     */
    @Column(name = "ID", nullable = false)
    @NotNull
    @Id
    @GeneratedValue(generator = SEQUENCE_NAME)
    private Long id;

    /** Value. */
    @Column(name = "VALUE", length = 255)
    private String value;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayrollElement.class)
    @JoinColumn(name = "ELEMENT_ID", referencedColumnName = "ID")
    private PayrollElement element;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PayrollPeriod.class)
    @JoinColumn(name = "PERIOD_ID", referencedColumnName = "ID")
    private PayrollPeriod period;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Organization.class)
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    private Organization org;

    /* ============== getters - setters ================== */

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PayrollElement getElement() {
        return this.element;
    }

    public void setElement(PayrollElement element) {
        if (element != null) {
            this.__validate_client_context__(element.getClientId());
        }
        this.element = element;
    }

    public PayrollPeriod getPeriod() {
        return this.period;
    }

    public void setPeriod(PayrollPeriod period) {
        if (period != null) {
            this.__validate_client_context__(period.getClientId());
        }
        this.period = period;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        if (employee != null) {
            this.__validate_client_context__(employee.getClientId());
        }
        this.employee = employee;
    }

    public Organization getOrg() {
        return this.org;
    }

    public void setOrg(Organization org) {
        if (org != null) {
            this.__validate_client_context__(org.getClientId());
        }
        this.org = org;
    }

    public void aboutToInsert(DescriptorEvent event) {

        super.aboutToInsert(event);

    }

}
