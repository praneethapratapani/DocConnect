package com.docconnect.hospital.user_information;

import java.io.Serializable;
import java.util.Date;

public class HealthInformation implements Serializable {
    /**
     * Class that stores basic Patient information that can later by viewed by doctors.
     * @param dateOfBirth a obj of class Date storing DOB of the patient
     * @param weight an int storing the weight of the patient in pounds
     * @param gender a string storing the gender of the patient - either "Male" or "Female"
     */
    private Date dateOfBirth;
    private int weight;
    private String gender;
    private String prescription;

    public HealthInformation(){}

    public HealthInformation(Date dateOfBirth, int weight, String gender, String prescription){
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.gender = gender;
        this.prescription = prescription;
    }


    public Date getDateOfBirth(){return dateOfBirth;}
    public int getWeight(){return weight;}
    public String getGender(){return gender;}

    public void setDateOfBirth(Date dateOfBirth){this.dateOfBirth = dateOfBirth;}
    public void setWeight(int weight){this.weight = weight;}
    public void setGender(String gender){this.gender = gender;}

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
