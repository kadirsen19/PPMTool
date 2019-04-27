package com.example.kadir.ppmtool.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
public class PersonProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name")
    @NotBlank(message = "Preoject name is required")
    private String projectName;

    @Column(name = "project_identifier",unique = true,updatable = false)
    @NotBlank(message = "Preoject identifier is required")
    @Size(min = 4,max = 5,message = "Please use 4 to 5 characters")
    private String projectIdentifier;

    @Column(name = "description")
    @NotBlank(message = "Preoject description is required")
    private String description;

    @Column(name = "star_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date star_date;

    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;

    @Column(name = "project_created_time")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date projectCreatedTime;
    @Column(name = "project_updated_time")
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date projectUpdatedTime;

    public PersonProject() {
        this.id = createUUID();
        this.projectCreatedTime = new Date();
        this.projectUpdatedTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStar_date() {
        return star_date;
    }

    public void setStar_date(Date star_date) {
        this.star_date = star_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getProjectCreatedTime() {
        return projectCreatedTime;
    }

    public void setProjectCreatedTime(Date projectCreatedTime) {
        this.projectCreatedTime = projectCreatedTime;
    }

    public Date getProjectUpdatedTime() {
        return projectUpdatedTime;
    }

    public void setProjectUpdatedTime(Date projectUpdatedTime) {
        this.projectUpdatedTime = projectUpdatedTime;
    }

    /*@PrePersist
    public  void onCreate() {
        this.projectCreatedTime = new Date();
    }
    @PrePersist
    public void onUpdate(){
        this.projectUpdatedTime= new Date();
    }*/

    @Transient
    private Long createUUID() {
        Long uuid = UUID.randomUUID().getMostSignificantBits();
        return uuid;
    }
}
