package gr.codehub.teamOne.repository;

import gr.codehub.teamOne.model.PatientDoctorAssociation;
import gr.codehub.teamOne.repository.lib.Repository;

import javax.persistence.EntityManager;
import java.util.List;

public class PatientDoctorAssociationRepository extends Repository<gr.codehub.teamOne.model.PatientDoctorAssociation, Long> {

    private EntityManager entityManager;

    public PatientDoctorAssociationRepository(EntityManager entityManager) {
        super(entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Class<PatientDoctorAssociation> getEntityClass() {
        return PatientDoctorAssociation.class;
    }

    @Override
    public String getEntityClassName() {
        return PatientDoctorAssociation.class.getName();
    }

    public PatientDoctorAssociation getAssociationIfExist(long patientID) {

        List associationList = entityManager.createQuery("from PatientDoctorAssociation where patient_id = :patientID")
                .setParameter("patientID", patientID)
                .getResultList();

        if (associationList.size() != 0){
            return (PatientDoctorAssociation) associationList.get(0);
        }
        return null;
    }
}
