package model;

import java.util.List;

public class Service {

    private int id;

    private String serviceName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    private int directionId;

    private int divisionId;

    private List<Subdivision> subdivisions;

    private List<Consultant> consultants;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public List<Subdivision> getSubdivisions() {
        return subdivisions;
    }

    public void setSubdivisions(List<Subdivision> subdivisions) {
        this.subdivisions = subdivisions;
    }

    public List<Consultant> getConsultants() {
        return consultants;
    }

    public void setConsultants(List<Consultant> consultants) {
        this.consultants = consultants;
    }
}
