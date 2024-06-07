package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
    //data access interfaces for the objects employee
    //this class is a repository
    //storage, retrieval, search in database
    //Integer - type of entity's Id , Primary key of the entity
}
