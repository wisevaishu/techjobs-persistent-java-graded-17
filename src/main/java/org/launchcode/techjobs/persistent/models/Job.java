package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

//    @Id
//    @GeneratedValue
//    private int id;
//
//    private String name;

    @ManyToOne
    //private String employer;
    //this means that the employer field in the Job entity determines the foreign key
    // mapping in the database table for the relationship.
    private Employer employer;

    @ManyToMany
    private List<Skill> skills  = new ArrayList<>();;

    //private String skills;

    public Job() {
    }

    // Initialize the id and value fields.
    public Job(Employer Employer, List<Skill> someSkills) {
        super();
        this.employer = Employer;
        this.skills = someSkills;
    }

    // Getters and setters.

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

}
