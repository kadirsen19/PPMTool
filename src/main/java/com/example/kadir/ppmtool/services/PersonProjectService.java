package com.example.kadir.ppmtool.services;

import com.example.kadir.ppmtool.domain.PersonProject;

import java.util.List;

public interface PersonProjectService {

    public PersonProject saveOrUpdatePersonProject(PersonProject personProject);

    public PersonProject getPersonProjectById(String personProjectIdentifier);

    public Iterable<PersonProject> findAllPersonProject();

    public void deletPersonProjectByProjectIdentifier(String personProjectId);
}
