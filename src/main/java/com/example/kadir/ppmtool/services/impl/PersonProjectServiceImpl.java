package com.example.kadir.ppmtool.services.impl;

import com.example.kadir.ppmtool.domain.PersonProject;
import com.example.kadir.ppmtool.exceptions.PersonProjectIdException;
import com.example.kadir.ppmtool.repositories.PersonProjectRepository;
import com.example.kadir.ppmtool.services.PersonProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonProjectServiceImpl implements PersonProjectService {

    @Autowired
    private PersonProjectRepository personProjectRepository;

    @Override
    public PersonProject saveOrUpdatePersonProject(PersonProject personProject) {
        try
        {
            personProject.setProjectIdentifier(personProject.getProjectIdentifier().toUpperCase());
            return personProjectRepository.save(personProject);
        }catch (Exception ex){
            throw new PersonProjectIdException("PersonProject identifier '"+personProject.getProjectIdentifier().
                    toUpperCase()+" 'already exist");
        }

    }

    @Override
    public PersonProject getPersonProjectById(String personProjectIdentifier) {
        PersonProject personProject = personProjectRepository.findPersonProjectByProjectIdentifier(personProjectIdentifier);

        if(personProject == null){
            throw new PersonProjectIdException("Person Project Id '"+personProjectIdentifier+"' does not exist");
        }

        return personProjectRepository.findPersonProjectByProjectIdentifier(personProjectIdentifier);
    }
}
