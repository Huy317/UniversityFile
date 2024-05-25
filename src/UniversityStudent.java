import java.util.Scanner;

public class UniversityStudent extends Student{
    private String thesisName;
    private double thesisScore;

    public UniversityStudent(String studentNumber, String fullName, int totalCredit, double avgScore, String thesisName, double thesisScore) {
        super(studentNumber, fullName, totalCredit, avgScore);
        this.thesisName = thesisName;
        this.thesisScore = thesisScore;
    }

    public UniversityStudent(String thesisName, double thesisScore) {
        this.thesisName = thesisName;
        this.thesisScore = thesisScore;
    }
    public UniversityStudent() {

    }
    @Override
    public int getType(){
        return 1;
    }
    @Override
    public void input(){
        Scanner sc = new Scanner(System.in);
        super.input();
        System.out.print("Enter thesis name: ");
        thesisName = sc.nextLine();
        System.out.print("Enter thesis score: ");
        thesisScore = sc.nextDouble();
    }

    @Override
    public boolean isGraduate(){
        if (super.totalCredit >= 150 && super.avgScore >= 5 && thesisScore >= 5){
            return true;
        }
        return false;
    }
    @Override
    public void  print(){
        String output = studentNumber + " " + fullName + " "+totalCredit+" "+avgScore +" "+thesisName+" "+thesisScore;
        System.out.println(output);
    }
}
