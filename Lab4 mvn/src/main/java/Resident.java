import java.util.ArrayList;
import java.util.List;

public class Resident implements Comparable {
    private String name;
    private List<Hospital> hospitalPreference = new ArrayList<Hospital>();

    public Resident(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Object o) {
        Resident item = (Resident) o;
        return this.getName().compareTo(item.getName());
    }
    @Override
    public String toString()
    {
        return this.name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hospital> getHospitalPreference() {
        return hospitalPreference;
    }

    public void setHospitalPreference(List<Hospital> hospitalPreference) {
        this.hospitalPreference = hospitalPreference;
    }
}