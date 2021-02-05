

class Solution60 {
    public String getPermutation(int n, int k) {
       
        int temp = (int)Math.ceil(((double)k/getFactorial(n-1)));
        System.out.println("1st digit: " + temp);
        

        return "";
    }

    public int getFactorial(int fac){
        int result = fac;
        for(int i = 1 ; i <= fac ; i++){
            result *= i;
        }
        System.out.println(fac + "! = " + result);
        return result;
    }

    

    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        Solution60 solution60 = new Solution60();
    
        System.out.println(solution60.getPermutation(3, 3));     
       

        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}