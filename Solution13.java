import java.util.Map;
import java.util.HashMap;

public class Solution13 {
    
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int result = 0;
        int last = 0;
        char[] romanArr = s.toCharArray();
        for(int i = romanArr.length -1 ; i >= 0 ; i--){
            if(last <= map.get(romanArr[i])){     // add
                result += map.get(romanArr[i]);
            } else {
                result -= map.get(romanArr[i]);  // deduct
            }
            last = map.get(romanArr[i]);            
        }
        return result;
    }    

    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        Solution13 solution = new Solution13();
        System.out.println(solution.romanToInt(""));      //3
        System.out.println(solution.romanToInt("III"));      //3
        System.out.println(solution.romanToInt("IV"));       //4
        System.out.println(solution.romanToInt("IX"));       //9
        System.out.println(solution.romanToInt("LVIII"));    //58
        System.out.println(solution.romanToInt("MCMXCIV"));  //1994
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}
