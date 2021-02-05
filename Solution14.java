
public class Solution14 {

    /***
     * 0 <= strs.length <= 200
       0 <= strs[i].length <= 200
       strs[i] consists of only lower-case English letters.
     * @param strs
     * @return
     */
    
    

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs.length; i++) {
            while(strs[i].indexOf(strs[0]) != 0) {
                strs[0] = strs[0].substring(0, strs[0].length() - 1);
            }
        }
        return strs[0]; 
    }

    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        Solution14 solution = new Solution14();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower","flow","flight"}));      //fl
        System.out.println(solution.longestCommonPrefix(new String[] {"dog","racecar","car"}));      // ""    
        System.out.println(solution.longestCommonPrefix(new String[] {})); // ""
        System.out.println(solution.longestCommonPrefix(new String[] {"abac","aba","aaab"}));   // "a"
        
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}