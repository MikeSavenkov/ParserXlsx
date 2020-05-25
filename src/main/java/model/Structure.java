package model;

import java.util.List;

public class Structure {

    private List<Division> divisions;
    private List<Direction> directions;
    private List<Service> services;
    private List<Subdivision> subdivisions;
    private List<Consultant> consultants;

    public Structure(List<Division> divisions,
                     List<Direction> directions,
                     List<Service> services,
                     List<Subdivision> subdivisions,
                     List<Consultant> consultants) {
        this.divisions = divisions;
        this.directions = directions;
        this.services = services;
        this.subdivisions = subdivisions;
        this.consultants = consultants;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<Subdivision> getSubdivisions() {
        return subdivisions;
    }

    public List<Consultant> getConsultants() {
        return consultants;
    }
}
