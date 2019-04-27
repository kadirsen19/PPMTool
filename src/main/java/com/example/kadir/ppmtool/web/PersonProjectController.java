package com.example.kadir.ppmtool.web;

import com.example.kadir.ppmtool.domain.PersonProject;
import com.example.kadir.ppmtool.services.MapValidationErrorService;
import com.example.kadir.ppmtool.services.PersonProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class PersonProjectController {

    @Autowired
    private PersonProjectService personProjectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody PersonProject personProject, BindingResult result) {

        ResponseEntity<?> responseEntity = mapValidationErrorService.mapValidationService(result);
        if (responseEntity != null) return responseEntity;

        PersonProject personProject1 = personProjectService.saveOrUpdatePersonProject(personProject);
        return new ResponseEntity<PersonProject>(personProject1, HttpStatus.CREATED);
    }

    @GetMapping("/{personProjectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String personProjectId)
    {
        PersonProject personProject= personProjectService.getPersonProjectById(personProjectId);
        return new ResponseEntity<PersonProject>(personProject,HttpStatus.OK);
    }
}
