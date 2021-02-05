class Solution9 {
    public boolean isPalindrome(int x) {   

        if(x < 0) return false;
        else if (x >= 0 && x < 10) return true; 
        else {
            int reversed = 0;
            int tmpX = x;
            while(tmpX > 0){
                reversed = reversed * 10 + (tmpX % 10);
                tmpX = tmpX / 10; 
            }
            return (x == reversed)? true:false;
        }
    }



    /**
     * x == rev -> for even digits true exmaple
     * x == rev/10 for odd digits true example
     */
    public boolean bestPractice(int x){
        if (x < 0) return false;
        if (x >= 0 && x <= 9) return true;
        if (x % 10 == 0) return false;
        
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);     
    }

    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        Solution9 solution9 = new Solution9();

        solution9.isPalindrome(123);
        //System.out.println(solution9.isPalindrome(0));
        //System.out.println(solution9.isPalindrome(1));
        //System.out.println(solution9.isPalindrome(11));
        //System.out.println(solution9.isPalindrome(111));
        //System.out.println(solution9.isPalindrome(2332));
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}