/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.bd.geo.business.service.ICountryService;
import net.nan21.dnet.module.bd.geo.domain.entity.Country;
import net.nan21.dnet.module.bd.org.business.service.IOrganizationService;
import net.nan21.dnet.module.bd.org.domain.entity.Organization;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;

public class EmployeeDsConv extends AbstractDsConverter<EmployeeDs, Employee>
        implements IDsConverter<EmployeeDs, Employee> {

    @Override
    protected void modelToEntityReferences(EmployeeDs ds, Employee e,
            boolean isInsert) throws Exception {

        if (ds.getEmployerId() != null) {
            if (e.getEmployer() == null
                    || !e.getEmployer().getId().equals(ds.getEmployerId())) {
                e.setEmployer((Organization) this.em.find(Organization.class,
                        ds.getEmployerId()));
            }
        } else {
            this.lookup_employer_Organization(ds, e);
        }

        if (ds.getCitizenshipId() != null) {
            if (e.getCitizenship() == null
                    || !e.getCitizenship().getId()
                            .equals(ds.getCitizenshipId())) {
                e.setCitizenship((Country) this.em.find(Country.class,
                        ds.getCitizenshipId()));
            }
        } else {
            this.lookup_citizenship_Country(ds, e);
        }

    }

    protected void lookup_employer_Organization(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getEmployerCode() != null && !ds.getEmployerCode().equals("")) {
            Organization x = null;
            try {
                x = ((IOrganizationService) findEntityService(Organization.class))
                        .findByCode(ds.getEmployerCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `employerCode` = "
                                + ds.getEmployerCode() + "  ");
            }
            e.setEmployer(x);

        } else {
            e.setEmployer(null);
        }
    }

    protected void lookup_citizenship_Country(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getCitizenshipCode() != null
                && !ds.getCitizenshipCode().equals("")) {
            Country x = null;
            try {
                x = ((ICountryService) findEntityService(Country.class))
                        .findByCode(ds.getCitizenshipCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Country` reference:  `citizenshipCode` = "
                                + ds.getCitizenshipCode() + "  ");
            }
            e.setCitizenship(x);

        } else {
            e.setCitizenship(null);
        }
    }

}
