package org.kml.greedy;

public class ValidParanthesisRec {
    private static boolean isValidParenthesis(String s, int idx, int count)
    {
        if(count < 0) {
            System.out.println(s + " -negative- " + count);
            return false;
        }
        if(idx == s.length())
        {
            System.out.println(s + " -last- " + count);
            return count == 0;
        }
        if(s.charAt(idx) == '(')
        {
            return isValidParenthesis(s, idx + 1, count + 1);
        }
        else if(s.charAt(idx) == ')')
        {
            return isValidParenthesis(s, idx + 1, count - 1);
        }
        else if(s.charAt(idx) == '*')
        {
           // return isValidParenthesis(s, idx + 1, count + 1) | isValidParenthesis(s, idx + 1, count - 1) | isValidParenthesis(s, idx + 1, count);

            String front = s.substring(0, idx + 1);
            String back = s.substring(idx + 1, s.length());
            boolean isValid = false;
            isValid = isValidParenthesis(front + back, idx + 1, count);
            if(isValid) return true;
            isValid = isValidParenthesis(front + "(" + back, idx + 1, count + 1);
            if(isValid) return true;
            isValid = isValidParenthesis(front + ")" + back, idx + 1, count - 1);
            if(isValid) return true;

        }
        return false;
    }
    public static void main(String[] args) {
        String s = "**(";
        System.out.println(s +" isValidParenthesis "+isValidParenthesis(s, 0, 0));

        String s1 = "KAMAL";
        System.out.println( s1.substring(0, 2) + "+" + s1.substring(2, s1.length()));
    }
}
