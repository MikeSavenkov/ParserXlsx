import java.util.List;

public class Consultant {

    List<Items> consultants;

    public Consultant() {

    }

    public List<Items> getConsultants() {
        return consultants;
    }

    public void setConsultants(List<Items> consultants) {
        this.consultants = consultants;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "consultants=" + consultants +
                '}';
    }
}
