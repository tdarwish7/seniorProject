package com.educationwebapplication.educationwebapplication;

public class Resource {
    private String resourceName;
    private String resourceType;
    private String resourceLink;
    private String resourceGradeLevel;


    public Resource() {
        this.resourceName = "";
        this.resourceType = "";
        this.resourceLink = "";
        this.resourceGradeLevel = "";
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getResourceLink() {
        return resourceLink;
    }

    public String getResourceGradeLevel() {
        return resourceGradeLevel;
    }


    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setResourceLink(String resourceLink) {
        this.resourceLink = resourceLink;
    }

    public void setResourceGradeLevel(String resourceGradeLevel) {
        this.resourceGradeLevel = resourceGradeLevel;
    }
}
