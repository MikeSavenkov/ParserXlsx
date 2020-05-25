public class Items {

    private String name;
    private String service;
    private double countTasks;

    public Items() {

    }

    public Items(String name, String service, double countTasks) {
        this.name = name;
        this.service = service;
        this.countTasks = countTasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getCountTasks() {
        return countTasks;
    }

    public void setCountTasks(double countTasks) {
        this.countTasks = countTasks;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", service='" + service + '\'' +
                ", countTasks=" + countTasks +
                '}';
    }
}
