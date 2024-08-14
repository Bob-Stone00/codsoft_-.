import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class GetData {
    
    double getExchangeRate(String from, String to) {
        double rate = 0;
        try {
           
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + from);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

           
            String response = content.toString();
            String[] parts = response.split(",");
            for (int i = 0; i < parts.length; i++) {
                if (parts[i].contains(to)) {
                    String[] ratePart = parts[i].split(":");
                    rate = Double.parseDouble(ratePart[1]);
                }
            }
        } catch (Exception e) {
            
            System.out.println("Error: " + e);
        }
        return rate;
    }
}

public class CurrencyConverter {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("From currency (BASE Currency):");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.println("To currency (Target Currency):");
        String toCurrency = scanner.nextLine().toUpperCase();

        GetData getData = new GetData();
        double rate = getData.getExchangeRate(fromCurrency, toCurrency);

        
        double result = amount * rate;

       
        System.out.println("Exchange rate: " + rate);
        System.out.println("Converted amount: " + result + " " + toCurrency);

        scanner.close();
    }
}