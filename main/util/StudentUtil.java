package main.util;

import main.Config;
import main.classes.Student;

public class StudentUtil {
public static Student fillStudent(){
    String name = InputUtil.requireText("Enter Name");
    String surname = InputUtil.requireText("Enter Surname");
    int age = InputUtil.requireNumber("Enter Age");
    String className = InputUtil.requireText("Enter Class Name");
    return new Student(name, surname, age, className);
}
public static void printAllRegisteredStudents(){
    if (Config.students != null) {
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            System.out.println(i+1+". "+st.getFullInfo());
        }
    } else {
        return;
    }
}
public static void registerStudent(){
            int count = InputUtil.requireNumber("How many students will be registered?");
            Config.students = new Student[count];
            for (int i = 0; i < count; i++) {
                System.out.println(i+1+". Student Register");
                Config.students[i] = StudentUtil.fillStudent();
            }
             System.out.println("Registration Completed Successfully!");
           StudentUtil.printAllRegisteredStudents();
}
public static void findStudentsAndPrint(){
    String text = InputUtil.requireText("Find by name, surname or class name");
    Student[] foundStudents = findStudents(text);
    for (int i = 0; i<foundStudents.length; i++){
        System.out.println(foundStudents[i].getFullInfo());
    }
}
public static Student[] findStudents(String text){
    int count = 0;
     for (int i = 0; i<Config.students.length; i++){
                Student st = Config.students[i];
                if (st.getName().contains(text)||st.getSurname().contains(text)||st.getClassName().contains(text)){
                    count++;
                }
            }
     Student[] result = new Student[count];
     int found = 0;
     for (int i = 0; i<Config.students.length; i++){
                Student st = Config.students[i];
                if (st.getName().contains(text)||st.getSurname().contains(text)||st.getClassName().contains(text)){
                    result[found++] = st;
                }
            }
     return result;
}
public static void updateStudent(){
    StudentUtil.printAllRegisteredStudents();
    int i = InputUtil.requireNumber("Which number students do you want to make changes?");
    System.out.println("Please enter new data...");
    Student selectedStudent = Config.students[i-1];
    int changeParameters = InputUtil.requireNumber("What data do you want to change?\n " +
                                                        "1. Name\n" +
                                                        "2. Surname\n" +
                                                        "3. Age\n" +
                                                        "4. Class Name\n");
    switch (changeParameters) {
        case 1:
            selectedStudent.setName(InputUtil.requireText("Enter name:"));
            break;
        case 2:
            selectedStudent.setSurname(InputUtil.requireText("Enter surname:"));
            break;
        case 3:
            selectedStudent.setAge(InputUtil.requireNumber("Enter age:"));
            break;
        case 4:
            selectedStudent.setClassName(InputUtil.requireText("Enter class name:"));
            break;
    }
}
}
