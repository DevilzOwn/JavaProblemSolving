package google;

import java.util.Stack;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        String output = new String();
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-' && count < K) {
                count++;
                stack.push(Character.toUpperCase(S.charAt(i)));
            }
            if (count == K) {
                stack.push('-');
                count = 0;
            }
        }
        while(!stack.isEmpty() && stack.peek()=='-') stack.pop();
        while (!stack.isEmpty()) {
            output=output + stack.pop();
        }
        return output;
    }
}
