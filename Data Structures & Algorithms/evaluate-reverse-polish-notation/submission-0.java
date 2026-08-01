class Solution {
    Stack<Integer> st = new Stack<Integer>();
    public int evalRPN(String[] tokens) {
        for(String token: tokens) {
            if(Objects.equals(token, "+")){
                int top = st.pop();
                int bottom = st.pop();
                st.push(top+bottom);
            }else if(Objects.equals(token, "-")) {
                int top = st.pop();
                int bottom = st.pop();
                st.push(bottom-top);
            }else if(Objects.equals(token, "*")) {
                int top = st.pop();
                int bottom = st.pop();
                st.push(bottom*top);
            }else if(Objects.equals(token, "/")) {
                int top = st.pop();
                int bottom = st.pop();
                st.push(bottom/top);
            }else {
                st.push(Integer.valueOf(token));
            }
        }
        return st.pop();
    }
}
