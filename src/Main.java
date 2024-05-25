import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> list = new ArrayList<>();
        File studentFile = new File("Student.dat");
        try {
            if (studentFile.createNewFile()){
                System.out.println("File created: " + studentFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

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
                    try {
                        FileOutputStream f = new FileOutputStream(studentFile);
                        ObjectOutputStream oStream = new ObjectOutputStream(f);
                        oStream.writeObject(list);
                        oStream.close();
                    }
                    catch (IOException e){
                        System.out.println("error write file");
                    }
                    break;
                case 2:
                    Student uniStudent = new UniversityStudent();
                    uniStudent.input();
                    list.add(uniStudent);
                    try {
                        FileOutputStream f = new FileOutputStream(studentFile);
                        ObjectOutputStream oStream = new ObjectOutputStream(f);
                        oStream.writeObject(list);
                        oStream.close();
                    }
                    catch (IOException e){
                        System.out.println("error write file");
                    }
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
                    try {
                        FileOutputStream f = new FileOutputStream(studentFile);
                        ObjectOutputStream oStream = new ObjectOutputStream(f);
                        oStream.writeObject(list);
                        oStream.close();
                    }
                    catch (IOException e){
                        System.out.println("error write file");
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
                    try {
                        FileOutputStream f = new FileOutputStream(studentFile);
                        ObjectOutputStream oStream = new ObjectOutputStream(f);
                        oStream.writeObject(list);
                        oStream.close();
                    }
                    catch (IOException e){
                        System.out.println("error write file");
                    }
                    break;
                case 7:
                    System.out.print("Enter name to search: ");
                    strInput = sc.nextLine();
                    var nameList = new ArrayList<Student>();
                    bool = false;
                    for (int i = 0;i<list.size();i++){
                        if (list.get(i).getName().equals(strInput)){
                            list.get(i).print();
                            nameList.add(list.get(i));
                            bool = true;

                        }
                    }
                    if (nameList.size() > 0){
                        File result = new File("Result.dat");
                        try {
                            FileOutputStream f = new FileOutputStream(studentFile);
                            ObjectOutputStream oStream = new ObjectOutputStream(f);
                            oStream.writeObject(nameList);
                            oStream.close();
                        }
                        catch (IOException e){
                            System.out.println("error write file");
                        }
                    }else{

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