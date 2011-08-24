/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
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

    protected void modelToEntityAttributes(EmployeeDs ds, Employee e)
            throws Exception {
        e.setClientId(ds.getClientId());
        e.setVersion(ds.getVersion());
        e.setCode(ds.getCode());
        e.setFirstName(ds.getFirstName());
        e.setLastName(ds.getLastName());
        e.setMiddleName(ds.getMiddleName());
        e.setBirthdate(ds.getBirthdate());
        e.setGender(ds.getGender());
        e.setMaritalStatus(ds.getMaritalStatus());
        e.setSinNo(ds.getSinNo());
        e.setSsnNo(ds.getSsnNo());
        e.setHasDisability(ds.getHasDisability());
        e.setFirstHireDate(ds.getFirstHireDate());
        e.setCurrentHireDate(ds.getCurrentHireDate());
        e.setOfficeEmail(ds.getOfficeEmail());
        e.setPassportNo(ds.getPassportNo());
        e.setClassName(ds.getClassName());
    }

    protected void modelToEntityReferences(EmployeeDs ds, Employee e)
            throws Exception {

        if (ds.getEmployerId() != null) {
            if (e.getEmployer() == null
                    || !e.getEmployer().getId().equals(ds.getEmployerId())) {
                e.setEmployer((Organization) this.em.getReference(
                        Organization.class, ds.getEmployerId()));
            }
        } else {
            this.lookup_employer_Organization(ds, e);
        }
        if (ds.getCitizenshipId() != null) {
            if (e.getCitizenship() == null
                    || !e.getCitizenship().getId()
                            .equals(ds.getCitizenshipId())) {
                e.setCitizenship((Country) this.em.getReference(Country.class,
                        ds.getCitizenshipId()));
            }
        } else {
            this.lookup_citizenship_Country(ds, e);
        }
    }

    protected void lookup_employer_Organization(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getEmployerCode() != null) {
            Organization x = null;
            try {
                x = ((IOrganizationService) getService(IOrganizationService.class))
                        .findByCode(ds.getClientId(), ds.getEmployerCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Organization` reference:  `employerCode` = "
                                + ds.getEmployerCode() + "  ");
            }
            e.setEmployer(x);
        }
    }

    protected void lookup_citizenship_Country(EmployeeDs ds, Employee e)
            throws Exception {
        if (ds.getCitizenshipCode() != null) {
            Country x = null;
            try {
                x = ((ICountryService) getService(ICountryService.class))
                        .findByCode(ds.getClientId(), ds.getCitizenshipCode());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `Country` reference:  `citizenshipCode` = "
                                + ds.getCitizenshipCode() + "  ");
            }
            e.setCitizenship(x);
        }
    }

    @Override
    public void entityToModel(Employee e, EmployeeDs ds) throws Exception {
        ds.setId(e.getId());
        ds.setClientId(e.getClientId());
        ds.setCreatedAt(e.getCreatedAt());
        ds.setModifiedAt(e.getModifiedAt());
        ds.setCreatedBy(e.getCreatedBy());
        ds.setModifiedBy(e.getModifiedBy());
        ds.setVersion(e.getVersion());
        ds.setCode(e.getCode());
        ds.setFirstName(e.getFirstName());
        ds.setLastName(e.getLastName());
        ds.setMiddleName(e.getMiddleName());
        ds.setBirthdate(e.getBirthdate());
        ds.setGender(e.getGender());
        ds.setMaritalStatus(e.getMaritalStatus());
        ds.setSinNo(e.getSinNo());
        ds.setSsnNo(e.getSsnNo());
        ds.setHasDisability(e.getHasDisability());
        ds.setFirstHireDate(e.getFirstHireDate());
        ds.setCurrentHireDate(e.getCurrentHireDate());
        ds.setOfficeEmail(e.getOfficeEmail());
        ds.setPassportNo(e.getPassportNo());
        ds.setClassName(e.getClassName());
        ds.setEmployerId(((e.getEmployer() != null)) ? e.getEmployer().getId()
                : null);
        ds.setEmployerCode(((e.getEmployer() != null)) ? e.getEmployer()
                .getCode() : null);
        ds.setCitizenshipId(((e.getCitizenship() != null)) ? e.getCitizenship()
                .getId() : null);
        ds.setCitizenshipCode(((e.getCitizenship() != null)) ? e
                .getCitizenship().getCode() : null);
    }

}
