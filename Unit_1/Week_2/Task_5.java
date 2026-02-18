class Task_5{
public int isPalindrome(String input1) 
{ 
        int left=0; 
        int right=input1.length()-1; 
        input1=input1.toLowerCase(); 
        while(left<right) 
        { 
            if(input1.charAt(left)!=input1.charAt(right)) 
            { 
                return 1; 
            } 
            left++; 
            right--; 
        } 
        return 2; 
 } 
     }