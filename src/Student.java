import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {


    protected String studentNumber;
    protected String fullName;
    protected int totalCredit;
    protected double avgScore;

    public Student(String studentNumber, String fullName, int totalCredit, double avgScore) {
        this.studentNumber = studentNumber;
        this.fullName = fullName;
        this.totalCredit = totalCredit;
        this.avgScore = avgScore;
    }

    public Student() {
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Id: ");
        this.studentNumber = sc.nextLine();
        System.out.print("Enter Full Name: ");
        this.fullName = sc.nextLine();
        System.out.print("Enter total credit: ");
        this.totalCredit = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter average score: ");
        avgScore = sc.nextDouble();
    }
    public String getStudentNumber() {
        return studentNumber;
    }
    public boolean isGraduate() {
        return false;
    }
    public int getType(){
        return 0;
    }
    public String getName(){
        return fullName;
    }
    public void print(){
    }

}
