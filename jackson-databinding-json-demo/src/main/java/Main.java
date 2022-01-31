import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {

            // ! for REST API is not needed because it is done automatically !

            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO
            // data/sample-lite.json
            Student theStudent = mapper.readValue(new File("data/sample-lite.json"), Student.class);

            // print first name and last name
            System.out.println("First name = " + theStudent.getFirstName());
            System.out.println("Last name = " + theStudent.getLastName());

            // gonna read from sample-full.json
            ComplexStudent theComplexStudent = mapper.readValue(new File("data/sample-full.json"), ComplexStudent.class);

            System.out.println("");
            System.out.println("First name = " + theComplexStudent.getFirstName());
            System.out.println("Last name = " + theComplexStudent.getLastName());
            System.out.println("Last name = " + theComplexStudent.getAddress());
            System.out.println("Last name = " + theComplexStudent.getLanguages());


        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
