import java.util.ArrayList;
import java.util.List;

public class Hospital implements Comparable {
    private String name;
    private List<Resident> residentPreference = new ArrayList<Resident>();

    public Hospital(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        Hospital item = (Hospital) o;
        return this.getName().compareTo(item.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Resident> getResidentPreference() {
        return residentPreference;
    }

    public void setResidentPreference(List<Resident> residentPreference) {
        this.residentPreference = residentPreference;
    }
}
