package gr.codehub.teamOne.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long amka;

    private String name;
    private String address;
    private Date dob;
    private Gender gender;

    @OneToMany
    private PatientMeasuraments patientMeasuraments;

    @ManyToOne
    private Doctors doctors;










}