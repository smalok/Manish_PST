public class Task_10{
public int sumOfsumOfDigits(int input1) { 
String num = String.valueOf(input1); 
        int totalSum = 0; 
        for (int i = 0; i < num.length(); i++) { 
            int currentSum = 0; 
            for (int j = i; j < num.length(); j++) { 
                currentSum += num.charAt(j) - '0'; 
            } 
            totalSum += currentSum; 
        } 
        return totalSum; 
}

