package com.lov2code.cruddemo;

import com.lov2code.cruddemo.dao.AppDAO;
import com.lov2code.cruddemo.entity.Instructor;
import com.lov2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//			createInstructor(appDAO);
//            findInstructor(appDAO);
            deleteInstructor(appDAO);
        };
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Find instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
//		// create the instructor
//		Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");
//		// create the instructor detail
//		InstructorDetail tempInstructorDetails = new InstructorDetail("http://","Luv 2 code");
// create the instructor
        Instructor tempInstructor = new Instructor("Madhu", "Patel", "patel@luv2code.com");
        // create the instructor detail
        InstructorDetail tempInstructorDetails = new InstructorDetail("http://", "Guitar");
        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetails);

        // save the instructor
        // Note: this will ALSO save the details object
        // because of CascadeType.ALL
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }
}