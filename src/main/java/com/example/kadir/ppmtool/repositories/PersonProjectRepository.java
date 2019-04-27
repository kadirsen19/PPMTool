package com.example.kadir.ppmtool.repositories;

import com.example.kadir.ppmtool.domain.PersonProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonProjectRepository extends CrudRepository<PersonProject,Long> {

    @Override
    Iterable<PersonProject> findAllById(Iterable<Long> ids);

    PersonProject findPersonProjectByProjectIdentifier(String personProjectIdentifier);

}
