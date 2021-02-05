

class Solution7 {
    public int reverse(int x) {

        if (x == Integer.MIN_VALUE)return 0;
        if(x < 0)return -reverse(-x);
        long reversedNum = 0;
        while(x != 0){
        reversedNum = reversedNum * 10 + x % 10;
            if(reversedNum > Integer.MAX_VALUE)return 0;
            x =x/ 10;
        }
        return (int)reversedNum;  
        
    }
    public static void main(String[] arcs) {
        long startTime = System.nanoTime();
        Solution7 solution7 = new Solution7();        
        //System.out.println(new String ("9646324351"));
        
        System.out.println("result: " + solution7.reverse(1534236469)); 
        //System.out.println("result: " + solution7.reverse(-123)); //8463847412-
        
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}