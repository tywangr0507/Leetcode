import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


public class Solution17 {
    public List<String> letterCombinations(String digits) {
        String[] nums = {"0", "1", "abc", "def", "ghi","jkl", "mno", "pqrs","tuv", "wxyz"};
        ArrayList<String> list = new ArrayList<>();
        int[] numbers = new int[digits.length()];


        if(digits.length() != 0 && digits.trim().length() != 0){
            for(int i = 0 ; i < digits.length() ; i++){
                numbers[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
            }
    
            Queue<String> q = new LinkedList<>();
            q.add("");
     
            while (!q.isEmpty()) {
                String s = q.remove();
                if (s.length() == digits.length())
                    list.add(s);
                else {
                    String val = nums[numbers[s.length()]];
                    for (int i = 0; i < val.length(); i++) 
                    {
                        q.add(s + val.charAt(i));
                    }
                }
            }
        }        
        return list;
    }

    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        Solution17 solution = new Solution17();
        System.out.println();
        System.out.println(solution.letterCombinations("23"));  // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(solution.letterCombinations(""));  // []
        System.out.println(solution.letterCombinations("2"));  // ["a","b","c"]
        
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}
