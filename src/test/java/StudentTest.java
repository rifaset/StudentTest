import org.example.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class StudentTest {
    private static ArrayList<String[]>  students;
    private Student student;

    @BeforeAll
    public static void InitClass(){
        students = new ArrayList<>();
    }

    @BeforeEach
    public void initMethod(){
        student = new Student("rifa", 20);
        students.add(new String[]{student.getName(), String.valueOf(student.getAge())});
        System.out.println("Before each setup");
    }

    @AfterEach
    public void cleanCLass(){
        students.clear();
        System.out.println("After each cleanup");
    }


    @AfterAll
    public static void cleanMethod(){
        students.clear();
    }

    @Test
    public void testDataCreation(){
        Assertions.assertEquals(1, students.size());
    }

    @Test
    public void testStudentEnrollment(){
        student.enrollCourse("Math");
        Assertions.assertEquals(1, student.getEnrolledCourses().size());
    }

    @Test
    public void testStudentGrade(){
        student.setGrade("Math", "A");
        Assertions.assertEquals("A", student.getGrade("Math"));
    }
}
