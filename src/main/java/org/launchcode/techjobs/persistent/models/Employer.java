package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotNull
    @NotBlank(message = "Location must not be blank")
    @Size(max = 100, message = "Location must be less than or equal to 100 characters")
    private String location;

    @OneToMany(mappedBy = "employer")
    //this means that the employer field in the Job entity determines the foreign key
    // mapping in the database table for the relationship.
    @JoinColumn(name = "employer_id") //foreign key
    private List<Job> jobs = new ArrayList<>();

    public Employer() {} //Required for hibernate to create an object

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
