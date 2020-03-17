import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class copySherlockValidString {

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
            if (freqMap.containsKey(frequency)) {
                int currFreq = freqMap.get(frequency);
                currFreq++;
                freqMap.put(frequency, currFreq);
            } else {
                freqMap.put(frequency, 1);
            }
            if (frequency > maxFreqLetter) {
                maxFreqLetter = frequency;
            }
            if (frequency < minFreqLetter) {
                minFreqLetter = frequency;
            }
        }
        noOfMaxFreq = freqMap.get(maxFreqLetter);
        noOfMinFreq = freqMap.get(minFreqLetter);


        System.out.println("maxFreqLetter: "+maxFreqLetter);
        System.out.println("minFreqLetter: "+minFreqLetter);
        System.out.println("noOfMaxFreq: "+noOfMaxFreq);
        System.out.println("noOfMinFreq: "+noOfMinFreq);
        System.out.println("distinctChars: "+distinctChars);
        for (Map.Entry<String,Integer> entry : occurences.entrySet())  {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
        }
        System.out.println("frequncy mapping");
        for (Map.Entry<Integer,Integer> entry : freqMap.entrySet())  {
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); 
        }
        if (maxFreqLetter == minFreqLetter) {
            return "YES";
        }
        if (noOfMaxFreq == 1) {
            if (maxFreqLetter - minFreqLetter <= 1 && distinctChars - 1 <= noOfMinFreq  ) {
                return "YES";
            }
        }
        if (noOfMinFreq == 1) {
            if (distinctChars - 1 <= noOfMaxFreq) {
                return "YES";
            }
        }
        return "NO";
        
    }

    


    public static void main(String[] args) throws IOException {
        
        InputStream is = new FileInputStream("case14.txt");
        BufferedReader buf = new BufferedReader(new InputStreamReader(is)); 
        String line = buf.readLine(); StringBuilder sb = new StringBuilder();
        while(line != null){ 
            sb.append(line).append("\n"); line = buf.readLine();
        } 
        String fileAsString = sb.toString().trim();
        String testCase2 = "abcdefghhgfedecba";
        String result = isValid(fileAsString);

        System.out.println("result: "+result);
        buf.close();
    }
}
