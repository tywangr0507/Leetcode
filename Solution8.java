class Solution8 {
    public int myAtoi(String str) {
        
        //String result = "";
        String cur = "";
        String trimStr = str.trim().split(" ")[0];
        int lastNonNumberIndex = 0;
        
        if(str.length() == 0) return 0;
        if(trimStr.length() == 0) return 0;

        for(int i = 0 ; i < trimStr.length() ; i++){
            lastNonNumberIndex = i;
            cur = Character.toString(trimStr.charAt(i)).toString();
            if(i == 0 && (cur.equals("-") || cur.equals("+"))) continue;
            else {
                try{
                    Integer.parseInt(cur);                    
                }catch(NumberFormatException e){
                    lastNonNumberIndex--;
                    break;   
                }
            }
        }   
        if(lastNonNumberIndex >= 0){
            trimStr = trimStr.substring(0, lastNonNumberIndex+1);
            if(trimStr.contains("-") && trimStr.contains("+")) return 0;
            if(trimStr.length() == 1 && (trimStr.equals("-") || trimStr.equals("+"))) return 0;

            try{
                return Integer.parseInt(trimStr,10);
            } catch(NumberFormatException e1){
                if(trimStr.substring(0,1).equals("-")) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
        } else return 0;
    }

    public int myAtoiBP(String str) {
        str = str.trim();
        if(str == null || str.length() < 1) {
            return 0;
        }
        int idx=0;
        long x = 0;
        boolean negative = false;
        if(idx < str.length() && (str.charAt(idx) == '-' || str.charAt(idx) == '+')){
            negative = str.charAt(idx) == '-';
            idx++;
        }
        while(idx < str.length()) {
            if(str.charAt(idx) < '0' || str.charAt(idx) > '9' || x > Integer.MAX_VALUE){
                break;
            }
            x = (x*10) + (str.charAt(idx++) - '0');
        }
        x = negative ? -1*x: x;
        int output = x > Integer.MAX_VALUE ? Integer.MAX_VALUE : x < Integer.MIN_VALUE ? Integer.MIN_VALUE : Math.toIntExact(x);
        return output;
    }


    public static void main(String[] arcs){
        Solution8 solution8 = new Solution8();
        System.out.println("Output: " + solution8.myAtoi("   -42"));    // -42
        System.out.println("Output: " + solution8.myAtoi("4193 with words")); // 4193

        System.out.println("Output: " + solution8.myAtoiBP("+2"));    // 2
        System.out.println("Output: " + solution8.myAtoiBP("+-2"));   // 0
        System.out.println("Output: " + solution8.myAtoi("words and 987")); // 0
        
        System.out.println("Output: " + solution8.myAtoiBP("20000000000000000000"));  // 2147483647
        System.out.println("Output: " + solution8.myAtoiBP("-91283472332"));  // -2147483648
        System.out.println("Output: " + solution8.myAtoi("3.1415"));    // 3
        System.out.println("Output: " + solution8.myAtoi("+")); // 0
        System.out.println("Output: " + solution8.myAtoi("-")); // 0
        System.out.println("Output: " + solution8.myAtoi(" ")); // 0
        System.out.println("Output: " + solution8.myAtoi("-abc")); // 0

    }
}