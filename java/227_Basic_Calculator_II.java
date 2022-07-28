class Solution {
    public int calculate(String s) {
        // Stack<Integer> stack = new Stack<>();
        // char op = '+';
        // int curr = 0;
        // for (int i=0; i<s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (Character.isDigit(c)) curr = curr*10+(c-'0');
        //     if (!Character.isDigit(c) && !Character.isWhitespace(c) || i==s.length()-1) {
        //         if (op=='+') stack.push(curr);
        //         else if (op=='-') stack.push(-curr);
        //         else if (op=='*') stack.push(stack.pop()*curr);
        //         else if (op=='/') stack.push(stack.pop()/curr);
        //         op = c;
        //         curr = 0;
        //     }
        // }
        // int res = 0;
        // while (!stack.isEmpty()) res += stack.pop();
        // return res;
        char op = '+';
        int last = 0, curr = 0, res = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) curr = curr*10+(c-'0');
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i==s.length()-1) {
                if (op=='+') {
                    res += last;
                    last = curr;
                } else if (op=='-') {
                    res += last;
                    last = -curr;
                } else if (op=='*') last = last*curr;
                else if (op=='/') last = last/curr;
                op = c;
                curr = 0;
            }
        }
        res += last;
        return res;
    }
}