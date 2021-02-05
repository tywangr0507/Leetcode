
class Solution10 {
    public boolean isMatch(String text, String pattern) {
        if(text.length() > pattern.length()) return false;
        // 空字串
        if (pattern.isEmpty()) return text.isEmpty();

        // 目前的第一個字相同？
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) ||
                                pattern.charAt(0) == '.'));

        // 有星號的情況：1.零 2.重複前一個字
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } 
        // text & pattern 都是字母
        else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public boolean isMatch2(String s, String p) {
        if(s.length() > p.length()) return false;
        if(p.isEmpty()) return s.isEmpty();
        
        boolean first_match = (!s.isEmpty() &&
                              s.charAt(0) == p.charAt(0) ||
                              p.charAt(0) == '.');
        
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                    (first_match && isMatch(s.substring(1), p)));
        } else {
            return (first_match && isMatch(s.substring(1), p.substring(1)));
        }
    }

    

    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        
        Solution10 solution10 = new Solution10();
    

        //System.out.println(solution10.isMatch("aa", "a")); //false
        //System.out.println(solution10.isMatch("aa", "a*")); //true
        System.out.println(solution10.isMatch2("ab", ".*c")); //true
        //System.out.println(solution10.isMatch("ab", ".*")); //true
        //System.out.println(solution10.isMatch("aab", "c*a*b")); //true
        //System.out.println(solution10.isMatch("mississippi", "mis*is*p*.")); //false

        
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}