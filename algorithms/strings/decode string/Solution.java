/**
 * 394. Decode String
 * Java 8
 * Problem on LeetCode - https://leetcode.com/problems/decode-string/
 * 
 * Time Complexity: O(n) where n is the size of the decoded string.
 * Space Complexity: O(s) where s is the size of the decoded string.
 * 
 * Approach:
 * We iterate through each character of the string. We expect to get 3 cases as the current char.
 * 1. It is a number
 * In this case, we first check if its a multi digit number, which means a number greater than 9 like 10,
 * 100, 1000 etc. Once we have got the number, we know the next char has to be '[' so we move the index
 * by 1 to get our first letter. Now we recursively call the same build string function and pass it the 
 * index of the first char. Here if we ever get a number that means again we need to recursively call the
 * function. If we reach ']' that means we have finished decoding that part of the string.
 * The idea about recursion is you want to treat any pair of brackets '[abc]' as one call. Due to recursion
 * we can save state, that means if I get [abc2[df]], I will append abc, now when I get a number I will go
 * down the stack create my new string and return it back to the previous call. When I return it, I will get
 * the opened string that is 'dfdf'. I will now append this to my current state, 'abc' + 'dfdf'. In this way
 * we can solve the case for nested brackets.
 * Also note, when we use recursion often we need to maintain a global state. In our case, its the index
 * variable. This variable should hold the value irrespective of the local call stack state and hence we 
 * declare it as an instance variable.
 * 
 * 2. A closing bracket ']'
 * This case is essentially to make us return from the current call stack. It is also known as the base case
 * for recursion.
 * 
 * 3. A letter 'a', 'b', etc.
 * This means we just simply append it to our current call stack string. This can make up as a prefix or suffix
 * string like 2[ab[cd]ef]. Here 'ab' is the prefix string & 'ef' suffix string.
 * 
 */

class Solution {
    private int index;

    private String buildStr(String str, int i) {
        StringBuilder sb = new StringBuilder();
        for (index = i; index < str.length(); index++) {
            char curr = str.charAt(index);
            Boolean isNumber = Character.isDigit(curr);
            if (isNumber) {
                StringBuilder nb = new StringBuilder();
                nb.append(curr);
                index++;
                while (index < str.length()) {
                    char curNum = str.charAt(index);
                    isNumber = Character.isDigit(curNum);
                    if (isNumber)
                        nb.append(curNum);
                    else
                        break;
                    index++;
                }
                index--;
                int repeat = Integer.valueOf(nb.toString());
                index += 2;
                String op = buildStr(str, index);
                while (repeat > 0) {
                    sb.append(op);
                    repeat--;
                }
            } else if (curr == ']') {
                break;
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }

    public String decodeString(String s) {
        index = 0;
        return buildStr(s, index);
    }

    public static void main(String[] args) {
        String input = "3[a20[c]]";
        Solution solution = new Solution();
        String decodedString = solution.decodeString(input);
        System.out.println("Decoded string: "+decodedString);
    }
}