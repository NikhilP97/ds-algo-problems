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
                if (frequency == minFreqLetter) {
                    noOfMinFreq -= 1;
                }
                int currFreq = freqMap.get(frequency);
                currFreq--;
                freqMap.put(frequency, currFreq);
                frequency += 1;
                if (noOfMinFreq == 0) {
                    freqMap.remove(frequency-1);
                    minFreqLetter = frequency;
                    if (freqMap.containsKey(frequency)) {
                        noOfMinFreq = freqMap.get(frequency);
                    } else {
                        noOfMinFreq = 1;
                    }
                }
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

            if (frequency == maxFreqLetter) {
                noOfMaxFreq += 1;
            }
            if (frequency == minFreqLetter) {
                noOfMinFreq += 1;
            }
            if (frequency > maxFreqLetter) {
                maxFreqLetter = frequency;
                noOfMaxFreq = 1;
            }
            if (frequency < minFreqLetter) {
                minFreqLetter = frequency;
                noOfMinFreq = 1;
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
    }
}
