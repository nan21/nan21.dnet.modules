/*    
 * DNet eBusiness Suite
 * Copyright: 2008-2011 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */
package net.nan21.dnet.module.hr.employee.business.serviceimpl;

import java.util.List;
import net.nan21.dnet.core.business.service.AbstractEntityService;
import net.nan21.dnet.module.hr.employee.business.service.IEmployeeLicenseService;
import net.nan21.dnet.module.hr.employee.domain.entity.Employee;
import net.nan21.dnet.module.hr.employee.domain.entity.LicenseType;

import javax.persistence.EntityManager;
import net.nan21.dnet.module.hr.employee.domain.entity.EmployeeLicense;

public class EmployeeLicenseService extends
        AbstractEntityService<EmployeeLicense> implements
        IEmployeeLicenseService {

    public EmployeeLicenseService() {
        super();
    }

    public EmployeeLicenseService(EntityManager em) {
        super();
        this.em = em;
    }

    @Override
    protected Class<EmployeeLicense> getEntityClass() {
        return EmployeeLicense.class;
    }

    public List<EmployeeLicense> findByEmployee(Employee employee) {
        return this.findByEmployeeId(employee.getId());
    }

    public List<EmployeeLicense> findByEmployeeId(Long employeeId) {
        return (List<EmployeeLicense>) this.em
                .createQuery(
                        "select e from EmployeeLicense e where e.employee.id = :pEmployeeId",
                        EmployeeLicense.class)
                .setParameter("pEmployeeId", employeeId).getResultList();
    }

    public List<EmployeeLicense> findByLicenseType(LicenseType licenseType) {
        return this.findByLicenseTypeId(licenseType.getId());
    }

    public List<EmployeeLicense> findByLicenseTypeId(Long licenseTypeId) {
        return (List<EmployeeLicense>) this.em
                .createQuery(
                        "select e from EmployeeLicense e where e.licenseType.id = :pLicenseTypeId",
                        EmployeeLicense.class)
                .setParameter("pLicenseTypeId", licenseTypeId).getResultList();
    }

}
