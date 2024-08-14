import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        int[] rounds = new int[6];
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        
        int count = 0;
        int holder1 = 0;
        
        while(count < 5)
        {

        System.out.println("Enter any random number between 1 and 100!");
        int useroption = scan.nextInt();

        int computerGeneratedNumber = random.nextInt(100) + 1;

        if(useroption == computerGeneratedNumber)
        {
            System.out.println("Correct!!");
        }
        else if(useroption > computerGeneratedNumber)
        {
            System.out.println("Too High!!");
            System.out.println("Correct number was:" + computerGeneratedNumber);
        }
        else 
        {
            System.out.println("Too Low!!");
            System.out.println("Correct number was: " + computerGeneratedNumber);
        }
            
        rounds[count] = computerGeneratedNumber;      
        count++;

        holder1 = useroption;
        }

        for(int i = 0; i < rounds.length;i++){
            
            if(rounds[i] == holder1){
                System.out.println("Round " + (i + 1) + ": Won!!");
                
            }
            else if(rounds[i] != holder1)
            {
                System.out.println("Round " + (i + 1) + ": Lost!!");
            }

        }

        scan.close();
        
    }
}
