package SpringTutorials.RESTwithPostgreSQL.configurations;

import SpringTutorials.RESTwithPostgreSQL.models.Student;
import SpringTutorials.RESTwithPostgreSQL.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
           Student mariam = new Student(
                   "Mariam",
                   "mariam@gmail.com",
                   LocalDate.of(2000, Month.APRIL, 5)
                   );
            Student alex = new Student(
                    "alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.APRIL, 5)
                    );
            Student alexia = new Student(
                    "alexia",
                    "alexia@gmail.com",
                    LocalDate.of(2005, Month.APRIL, 5)
            );

            studentRepository.saveAll(
                    List.of(mariam, alex, alexia)
            );
        };
    }

}
