import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = -1;
        int intInput;
        int temp;
        boolean bool;
        String strInput;
        while (n != 8){
            System.out.println("-------------------------------------");
            System.out.println("1.add new college student");
            System.out.println("2.add new university student");
            System.out.println("3.remove student by code");
            System.out.println("4.print list");
            System.out.println("5.print eligible for graduation");
            System.out.println("6.sort list");
            System.out.println("7.Find student by full name");
            System.out.println("8.Exit");
            System.out.println("-------------------------------------");
            System.out.print("Input: ");
            n = sc.nextInt();
            sc.nextLine();
            switch (n){
                case 1:
                    Student collegeStudent = new CollegeStudent();
                    collegeStudent.input();
                    list.add(collegeStudent);
                    break;
                case 2:
                    Student uniStudent = new UniversityStudent();
                    uniStudent.input();
                    list.add(uniStudent);
                    break;
                case 3:
                    System.out.print("Enter id to remove: ");
                    strInput = sc.nextLine();
                    for (int i = 0; i<list.size();i++){
                        if (list.get(i).getStudentNumber().equals(strInput)){
                            list.remove(i);
                            break;
                        }
                    }
                    break;
                case 4:
                    for (int i = 0;i<list.size();i++){
                        list.get(i).print();
                    }
                    break;
                case 5:
                    temp = 0;

                    for (int i = 0; i<list.size();i++){
                        if (list.get(i).isGraduate()){
                            list.get(i).print();
                            temp++;
                        }
                    }
                    System.out.println("number of eligible: "+temp);
                    break;
                case 6:
                    Collections.sort(list,(Comparator.comparingInt(Student::getType).thenComparing(Student::getStudentNumber)));
                    break;
                case 7:
                    System.out.print("Enter name to search: ");
                    strInput = sc.nextLine();
                    bool = false;
                    for (int i = 0;i<list.size();i++){
                        if (list.get(i).getName().equals(strInput)){
                            list.get(i).print();
                            bool = true;

                        }
                    }
                    if (!bool){
                        System.out.println("Student doesn't exist");
                    }
                    break;
                case 8:
                    break;
                default:
                    break;
            }

        }
    }
}