import java.util.*;

public class App {
    public static void main(String[] args) {
          
    Scanner scan = new Scanner(System.in);

    System.out.println("How many subjects are you currently doing at school");
    int userSubjectNo = scan.nextInt();

    int[] subjectHolder = new int[userSubjectNo];

    System.out.println("Enter your subject marks below:");

    int sum = 0;

    for(int i = 0; i < subjectHolder.length;i++){
        int userSubjects = scan.nextInt();
        subjectHolder[i] = userSubjects;
        sum += subjectHolder[i];
    }

    double Average = sum/subjectHolder.length;
    
    if(Average > 80 ){
        System.out.println("Grade: A");
    }
    else if(Average >= 70 &&  Average < 80){
        System.out.println("Grade: B");
    }
    else if(Average >= 60 &&  Average < 70){
        System.out.println("Grade: C");
    }
    else if(Average >= 50 &&  Average < 60){
        System.out.println("Grade: D");
    }
    else {
        System.out.println("Grade: F");
    }

    System.out.println("Total Marks :" + sum);
    System.out.println("Average percentage :" + Average + "%");

    scan.close();
    }
}
