package model;

public class Consultant {

    private int id;

    private String name;

    private double countTasks;

    private int divisionId;

    private int directionId;

    private int serviceId;

    private int subdivisionId;

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getSubdivisionId() {
        return subdivisionId;
    }

    public void setSubdivisionId(int subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public double getCountTasks() {
        return countTasks;
    }

    public void setCountTasks(double countTasks) {
        this.countTasks = countTasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countTasks=" + countTasks +
                '}';
    }
}
