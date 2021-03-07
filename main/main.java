package main;

import main.classes.Student;
import main.util.InputUtil;
import main.util.StudentUtil;

class Main {
    public static void main(String[] args) {
        int menu = 0;
        while(true) {
            menu = InputUtil.requireNumber("What do you want to do?\n"
                    + "1. Register Student\n"
                    + "2. Show All Students\n"
                    + "3. Find Student\n"
                    + "4. Update Student\n"
                    + "5. Exit");
            switch (menu) {
                case 1:
                    StudentUtil.registerStudent();
                    break;
                case 2:
                    StudentUtil.printAllRegisteredStudents();
                    break;
                case 3:
                    StudentUtil.findStudentsAndPrint();
                    break;
                case 4:
                    StudentUtil.updateStudent();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter correct menu number!");
                    break;
            }
        }
    }
}