package com.java8.clone;

public class SerialCloneTest {

    public static void main(String[] args) {
        try {

            Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);
            Employee harry2 = (Employee) harry.clone();
            harry.raiseSalary(10);
            System.out.println(harry.toString());
            System.out.println(harry2.toString());


        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
