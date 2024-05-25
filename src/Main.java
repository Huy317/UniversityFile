import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> list = new ArrayList<>();

        FileInputStream fis = new FileInputStream(".\\Student.dat");
        FileOutputStream fos = new FileOutputStream(".\\Student.dat");
        ObjectOutputStream oStream = new ObjectOutputStream(fos);
        ObjectInputStream iStream = new ObjectInputStream(fis);

        try {
            Student st = null;
            while ((st = (Student)iStream.readObject()) != null){
                list.add(st);
            }
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }catch (IOException e) {
            System.out.println("An error occurred.");
            System.out.println(e);
        }

//        try {
//            list = (ArrayList<Student>) iStream.readObject();
//        } catch (ClassNotFoundException e) {
//            System.out.println("Class not found");
//        } catch (IOException e) {
//            System.out.println("Error load file");
//        }


        Scanner sc = new Scanner(System.in);
        int n = -1;
        int intInput;
        int temp;
        boolean bool;
        String strInput;
        while (n != 8) {
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
            switch (n) {
                case 1:
                    Student collegeStudent = new CollegeStudent();
                    collegeStudent.input();
                    list.add(collegeStudent);

                    try {
                        oStream.writeObject(list);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    break;
                ///write
                case 2:
                    Student uniStudent = new UniversityStudent();
                    uniStudent.input();
                    list.add(uniStudent);

                    try {
                        for (Student stu : list) {
                            oStream.writeObject(stu);
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    //write
                    break;
                case 3:
                    System.out.print("Enter id to remove: ");
                    strInput = sc.nextLine();
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getStudentNumber().equals(strInput)) {
                            list.remove(i);
                            break;
                        }
                    }

                    try {
                        for (Student stu : list){
                            oStream.writeObject(stu);
                        }
                    } catch (IOException e) {
                        System.out.println(e);
                    }

                    break;
                case 4:
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).print();
                    }
//                    ArrayList<Student> listFile = new ArrayList<>();
//                    try {
//                        listFile = (ArrayList<Student>) iStream.readObject();
//                    }catch (ClassNotFoundException e){
//                        System.out.println("Class not found");
//                    }catch (IOException e){
//                        System.out.println("Error load file");
//                        System.out.println(e);
//                    }
//                    for (int i = 0;i<listFile.size();i++){
//                        list.get(i).print();
//                    }
                    break;
                case 5:
                    temp = 0;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isGraduate()) {
                            list.get(i).print();
                            temp++;
                        }
                    }
                    System.out.println("number of eligible: " + temp);
                    break;
                case 6:
                    Collections.sort(list, (Comparator.comparingInt(Student::getType).thenComparing(Student::getStudentNumber)));
                    try {
                        for (Student stu : list){
                            oStream.writeObject(stu);
                        }
                    } catch (IOException e) {
                        System.out.println("error write file");
                    }
                    break;
                case 7:
                    System.out.print("Enter name to search: ");
                    strInput = sc.nextLine();

                    var nameList = new ArrayList<Student>();

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getName().equals(strInput)) {
                            list.get(i).print();
                            nameList.add(list.get(i));
                        }
                    }
                    if (nameList.size() > 0) {
                        FileOutputStream fos2 = new FileOutputStream(".\\Result.dat");
                        ObjectOutputStream oos = new ObjectOutputStream(fos2);
                        try {
                            for (Student stu : nameList){
                                oos.writeObject(stu);
                            }
                        } catch (IOException e) {
                            System.out.println("error write file");
                        }
                    } else {

                        System.out.println("Student doesn't exist");
                    }
                    break;
                case 8:
                    //write...
                    break;
                default:
                    break;
            }
            oStream.close();
            iStream.close();
        }
    }
}