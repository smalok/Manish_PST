class Task_7{
    public in EvenOddDigitsSum(int input1, String input2){
        int sum = 0;
        while (input1 > 0) {
            int digit = input1 % 10;
            if (input2.equalsIgnoreCase("even")) {
                if (digit % 2 == 0) {
                    sum += digit;
                }
            } else if (input2.equalsIgnoreCase("odd")) {
                if (digit % 2 != 0) {
                    sum += digit;
                }
            }
            input1 /= 10;
        }
        return sum;
   }
}