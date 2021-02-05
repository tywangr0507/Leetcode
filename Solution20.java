import java.util.Stack;
import java.util.Map;
import java.util.HashMap;


public class Solution20 {
     
    public boolean isValid(String s) {
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        
        if(s.length() == 0) return true;
        else if(s.length() % 2 != 0) return false;
        else {
            for(char ss : s.toCharArray()){ 
               
                if(stack.size() > (s.length() / 2)) return false;
                if(stack.empty()){
                    stack.push(ss);
                } else {
                    if(map.containsKey(stack.peek()) && ss == map.get(stack.peek())){
                        stack.pop();
                    } else {
                        stack.push(ss);
                    }
                }

                
            }
            return stack.isEmpty();
            
        }        
    }

        public static void main(String[] arcs){
            long startTime = System.nanoTime();
            Solution20 solution = new Solution20();
            System.out.println();
            System.out.println("1. " + solution.isValid("()"));  // true  
            System.out.println();
            System.out.println("2. " + solution.isValid("()[]{}"));  // true
            System.out.println();
            System.out.println("3. " + solution.isValid("(]"));  // false
            System.out.println();
            System.out.println("4. " + solution.isValid("([)]"));  // false
            System.out.println();
            System.out.println("5. " + solution.isValid("{[]}"));  // true
            
           
            long stopTime = System.nanoTime();
            System.out.println("Time used: " + (stopTime - startTime));
        }
    }
