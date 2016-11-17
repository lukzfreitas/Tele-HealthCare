/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;
import persistence.InitializeDataSource;
import persistence.PatientOrganizationDao;

/**
 *
 * @author Neelu
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }   
    
    public ArrayList<Organization> getPatientOrganizationList() {
        PatientOrganizationDao patientOrganizationDao = new PatientOrganizationDao();
        return patientOrganizationDao.findAll();
    }
    
    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabTechnicianOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Receptionist.getValue())){
            organization = new ReceptionistOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.EmergencyServices.getValue())){
            organization = new EmergencyOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Dietician.getValue())){
            organization = new DietitianOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Patient.getValue())){
            organization = new PatientOrganization();            
            PatientOrganizationDao patientOrganizationDao =
                new PatientOrganizationDao();
            patientOrganizationDao.insert(organization);
            organizationList.add(organization);
        }
        return organization;
    }
}