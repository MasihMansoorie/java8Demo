package funcInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        // Java 8 introduce in 2014 ---
        // java 8 support lambda Expression
        // java 8 support Stream API
        // Date and Time API
        // String

        // Functional Interface: a function that contain only one abstract method.
        //  Functional interface has private method, default method, only one abstract  and static method---
        // can we create functional interface : Yes ------

        // Lambda Expression : an anonymous method.
        // (Parameter list ) -> lambda body

        //double getPIValue() { // ----- This line and below line are original method
//        return 3.14 }
//
//        () -> 3.14;  ---- This is lambda Expression
  //      () -> System.out.println("Lambda Expression are great.");

        // the lambda provide implementation for abstract method of function interface .
        // lambda expression use only one abstract
        MyFunctionInterface func = () -> System.out.println("Lambda Expression are great.");
        func.getValue();

        MyFunctionInterface show = () -> System.out.println("I want to show lambda Expression.");
        show.getValue();

        System.out.println("------------------------------");

        // ----------------------------------------------

        Operations addOps = (a , b) ->  a + b;
        Operations subtractOps = (a , b) -> a - b;
        Operations multiplyOps = (a , b) -> a * b;
        Operations divisionOps = (a , b) -> a / b;

        System.out.println("The sum of 5, and 6.3 = " + addOps.calculate(5,6.3));
        System.out.println("The subtract of 5, and 8 = " + subtractOps.calculate(5,8));
        System.out.println("The multiply of 5, and 8 = " + multiplyOps.calculate(5,8));
        System.out.println("The division of 5, and 8 = " + divisionOps.calculate(5,8));

        System.out.println("------------------------------");

        OddEven check = (n) -> (n % 2 == 0);
        System.out.println("Checking if 14 is and even number : " + check.isEven(14));

        // this method is already in java 8 for you to check even and odd
        Predicate<Integer> predi = (n) -> (n % 2 == 0);
        System.out.println(predi.test(5));


        System.out.println("\n-----------------------------------------------");

        System.out.println("List of all Students : ");

        for (Student student : getStudentList()) {
            System.out.println(student);
        }
        System.out.println("------------ List of all Adult Students ----------");

        for (Student student : getAdultStudent()) {
            System.out.println(student);
        }





    }

    static List<Student> getStudentList() {
      return   Arrays.asList(
                new Student(2,"Javad",23),
                new Student(3,"Jack",11),
                new Student(11,"Shad",33),
                new Student(1,"Dimitri",20),
                new Student(5,"Ajmal",16));
    }

    static List<Student> getAdultStudent(){
       Predicate<Student> adultStudent = (student) -> student.age() > 18;

    List<Student> adults = new ArrayList<>();

    for (Student student : getStudentList()) {
        if(adultStudent.test(student)) {
            adults.add(student);
        }
    }
    return adults;

    }


}
