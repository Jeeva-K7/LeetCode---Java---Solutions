class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num=0;
        StringBuilder ans=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                num = (num*10)+(ch-'0');
            }
            else if(ch=='['){
                numStack.push(num);
                num=0;
                strStack.push(ans);
                ans = new StringBuilder();
            }
            else if(ch==']'){
                String str = ans.toString();
                ans = strStack.pop();
                ans.append(new StringBuilder(str.repeat(numStack.pop())));
                
            }
            else{
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
