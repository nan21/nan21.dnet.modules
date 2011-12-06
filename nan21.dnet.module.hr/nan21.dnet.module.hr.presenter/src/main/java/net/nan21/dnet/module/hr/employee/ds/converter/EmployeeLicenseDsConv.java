/*
 * DNet eBusiness Suite
 * Copyright: 2010 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.hr.employee.ds.converter;

import net.nan21.dnet.core.api.converter.IDsConverter;
import net.nan21.dnet.module.hr.employee.business.service.ILicenseTypeService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

import net.nan21.dnet.core.presenter.converter.AbstractDsConverter;
import net.nan21.dnet.module.hr.employee.ds.model.EmployeeLicenseDs;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeLicense;

public class EmployeeLicenseDsConv extends
        AbstractDsConverter<EmployeeLicenseDs, EmployeeLicense> implements
        IDsConverter<EmployeeLicenseDs, EmployeeLicense> {

    protected void modelToEntityReferences(EmployeeLicenseDs ds,
            EmployeeLicense e) throws Exception {
        if (ds.getEmployeeId() != null) {
            if (e.getEmployee() == null
                    || !e.getEmployee().getId().equals(ds.getEmployeeId())) {
                e.setEmployee((Employee) this.em.find(Employee.class,
                        ds.getEmployeeId()));
            }
        }
        if (ds.getLicenseTypeId() != null) {
            if (e.getLicenseType() == null
                    || !e.getLicenseType().getId()
                            .equals(ds.getLicenseTypeId())) {
                e.setLicenseType((LicenseType) this.em.find(LicenseType.class,
                        ds.getLicenseTypeId()));
            }
        } else {
            this.lookup_licenseType_LicenseType(ds, e);
        }
    }

    protected void lookup_licenseType_LicenseType(EmployeeLicenseDs ds,
            EmployeeLicense e) throws Exception {
        if (ds.getLicenseType() != null && !ds.getLicenseType().equals("")) {
            LicenseType x = null;
            try {
                x = ((ILicenseTypeService) getService(ILicenseTypeService.class))
                        .findByName(ds.getClientId(), ds.getLicenseType());
            } catch (javax.persistence.NoResultException exception) {
                throw new Exception(
                        "Invalid value provided to find `LicenseType` reference:  `licenseType` = "
                                + ds.getLicenseType() + "  ");
            }
            e.setLicenseType(x);

        } else {
            e.setLicenseType(null);
        }
    }

}
