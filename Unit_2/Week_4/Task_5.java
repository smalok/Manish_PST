import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String timeConversion(String s) {
        // Extract the period (AM or PM)
        String period = s.substring(s.length() - 2);
        // Extract the hour as an integer
        int hour = Integer.parseInt(s.substring(0, 2));
        // Extract the minutes and seconds part
        String timeWithoutHourAndPeriod = s.substring(2, s.length() - 2);

        String militaryHour;

        if (period.equalsIgnoreCase("PM")) {
            // If PM and not 12, add 12. If 12, stay 12.
            if (hour != 12) {
                hour += 12;
            }
            militaryHour = String.valueOf(hour);
        } else {
            // If AM and 12, change to 00.
            if (hour == 12) {
                militaryHour = "00";
            } else {
                // Keep the leading zero for hours less than 10
                militaryHour = String.format("%02d", hour);
            }
        }

        return militaryHour + timeWithoutHourAndPeriod;
    }
}

public class Task_5{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        // Handling the output path for different environments
        String outputPath = System.getenv("OUTPUT_PATH");
        BufferedWriter bufferedWriter;
        if (outputPath != null) {
            bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        } else {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
