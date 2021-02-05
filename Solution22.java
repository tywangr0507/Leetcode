import java.util.ArrayList;
import java.util.List;


public class Solution22 {
     
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<String>();


        return list;
        

    }


    public String rec(String s, int o, int c, int n){

        String tmp = s;
        if(o == n && c == n){
            return tmp;
        } else if(o > c){
            tmp = tmp + ")";
            rec(tmp, o, c+1, n);
        } else if(o < c) {
            tmp = tmp + "(";
            rec(tmp, o+1, c, n);
        }
        return "";
    }

    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        Solution22 solution = new Solution22();
       
        System.out.println(solution.generateParenthesis(3));  // ["((()))","(()())","(())()","()(())","()()()"]  
        System.out.println(solution.generateParenthesis(1));  // ["()"]
            
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}
