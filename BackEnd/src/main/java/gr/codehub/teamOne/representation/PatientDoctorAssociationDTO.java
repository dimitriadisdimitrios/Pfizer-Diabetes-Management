package gr.codehub.teamOne.representation;

import gr.codehub.teamOne.model.PatientDoctorAssociation;
import lombok.Data;

import java.util.Date;

@Data
public class PatientDoctorAssociationDTO {

    private long patient;
    private Long doctor;
    private Date lastConsulate;

    public static PatientDoctorAssociation getAssociation(PatientDoctorAssociationDTO mAssociationDTO){

        PatientDoctorAssociation mAssociation = new PatientDoctorAssociation();
        mAssociation.setLastConsulate(mAssociationDTO.getLastConsulate());
        return mAssociation;
    }

    public static PatientDoctorAssociationDTO getAssociation(PatientDoctorAssociation mAssociation){

        PatientDoctorAssociationDTO mAssociationDTO = new PatientDoctorAssociationDTO();
        mAssociationDTO.setPatient(mAssociation.getPatient().getId());
        mAssociationDTO.setDoctor(mAssociation.getDoctor().getId());
        mAssociationDTO.setLastConsulate(mAssociation.getLastConsulate());
        return mAssociationDTO;
    }
}
