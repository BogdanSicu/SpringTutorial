import java.util.ArrayList;
import java.util.List;

public class ComplexStudent extends Student{
    private Address address;
    private List<String> languages = new ArrayList<>();

    public ComplexStudent() {
        super();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

}
