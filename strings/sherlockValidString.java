import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class sherlockValidString {

    // Complete the isValid function below.
    static String isValid(String inputStr) {
        HashMap<String, Integer> occurences = new HashMap<String, Integer>();
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        int strLen = inputStr.length();
        if (strLen == 1) {
            return "YES";
        }
        int maxFreqLetter = 1;
        int minFreqLetter = 1;
        int noOfMaxFreq = 0;
        int noOfMinFreq = 0;
        int distinctChars = 0;
        int frequency;
        for (int i = 0; i < strLen; i++) {
            String letter = Character.toString(inputStr.charAt(i));
            // Update letter <--> occurences mapping
            if (occurences.containsKey(letter)) {
                frequency = occurences.get(letter);
                int currFreq = freqMap.get(frequency);
                currFreq--;
                if (currFreq == 0) {
                    if (minFreqLetter == frequency) {
                        minFreqLetter = frequency + 1;
                    }
                    freqMap.remove(frequency);
                } else {
                    freqMap.put(frequency, currFreq);
                }
                frequency += 1;
                occurences.put(letter, frequency);
            } else {
                frequency = 1;
                distinctChars += 1;
                occurences.put(letter, 1);
            }

            // Update occurences <--> no of occurences mapping
            if (freqMap.containsKey(frequency)) {
                int currFreq = freqMap.get(frequency);
                currFreq++;
                freqMap.put(frequency, currFreq);
            } else {
                freqMap.put(frequency, 1);
            }

            // Update the minimum & maximum occurences
            if (frequency > maxFreqLetter) {
                maxFreqLetter = frequency;
            }
            if (frequency < minFreqLetter) {
                minFreqLetter = frequency;
            }
        }
        noOfMaxFreq = freqMap.get(maxFreqLetter);
        noOfMinFreq = freqMap.get(minFreqLetter);

        if (maxFreqLetter == minFreqLetter) return "YES";

        if (noOfMaxFreq == 1 && maxFreqLetter - minFreqLetter <= 1) return "YES";

        if (noOfMinFreq == 1 && distinctChars - 1 <= noOfMaxFreq) return "YES";

        return "NO";
    }

    public static void main(String[] args) throws IOException {
        
        InputStream is = new FileInputStream("case13.txt");
        BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
        String line = buf.readLine(); StringBuilder sb = new StringBuilder();
        while(line != null){ 
            sb.append(line).append("\n"); line = buf.readLine();
        } 
        String fileAsString = sb.toString().trim();
        String inpuString= "abcdefghhgfedecba";
        String result = isValid(inpuString);

        System.out.println("result: "+result);
        buf.close();
    }
}
