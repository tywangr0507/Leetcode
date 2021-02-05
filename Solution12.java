public class Solution12 {
    /***
    Symbol       Value
    
    I             1
    V             5
    X             10

    X             10
    L             50
    C             100

    XL            40
    XC            90

    C             100
    D             500
    M             1000

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.
     * @param num
     * @return
     */
    public String intToRoman(int num) {

        String romanStr = "";
        String[] romanArr = {"I","V","X","L","C","D","M"};

        for(int i = 3 ; i >= 0 ; i--){
            int target = (int)Math.floor(num/Math.pow(10, i));
            
            if(target != 0){
                int temp = (int)Math.floor(target / 5);
                int tempMod = target % 5;
                int cal = (int)(target/4);

                if(tempMod == 4) { 
                    romanStr += romanArr[2*i] + romanArr[2*i+cal]; 
                }
                else if(tempMod % 5 == 0 ){    
                    romanStr += romanArr[2*i+cal];
                } else {
                    if(temp == 0){  
                        while(tempMod > 0){
                            romanStr += romanArr[2*i];
                            tempMod--;
                        }
                    } else {    
                        romanStr += romanArr[2*i+cal];
                        while(tempMod > 0){
                            romanStr += romanArr[2*i];
                            tempMod--;
                        }
                    }
                }
            }
            num %= Math.pow(10, i);
        }
        return romanStr;
    }
    public String intToRoman4(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public String intToRoman3(int num) {

        String romanStr = "";
        String[] romanArr = {"I","V","X","L","C","D","M"};

        for(int i = 3 ; i >= 0 ; i--){
            int target = (int)Math.floor(num/Math.pow(10, i));
            
            if(target != 0){
                int tempMod = target % 5;
                int cal = (int)(target/4);

                if(target == 4){
                    romanStr += (romanArr[2*i] + romanArr[2*i+cal]);
                } else if(target == 9){
                    romanStr += (romanArr[2*i] + romanArr[2*i+cal]);

                } else if(target == 5){
                    romanStr += romanArr[2*i+1];
                } else {
                    if(target < 5){  
                        while(tempMod > 0){
                            romanStr += romanArr[2*i];
                            tempMod--;
                        }
                    } else {    
                        romanStr += romanArr[2*i+1];
                        while(tempMod > 0){
                            romanStr += romanArr[2*i];
                            tempMod--;
                        }
                    }
                }
            }
            num %= Math.pow(10, i);
        }
        return romanStr;
    }
    public String intToRoman2(int num) {

        String romanStr = "";
        String[][] romanArr = {{"I","V","X"},{"X","L","C"},{"C","D","M"},{"M"}};

        for(int i = 3 ; i >= 0 ; i--){
            int target = (int)Math.floor(num/Math.pow(10, i));
            
            if(target != 0){
                int temp = (int)Math.floor(target / 5);
                int tempMod = target % 5;
                if(tempMod == 4){    
                    temp++;     
                    romanStr += romanArr[i][0] + romanArr[i][(int)temp];                
                } else if(tempMod % 5 == 0 ){    
                    romanStr += romanArr[i][1];
                } else {
                    if(temp == 0){  
                        while(tempMod > 0){
                            romanStr += romanArr[i][0];
                            tempMod--;
                        }
                    } else {    
                        romanStr += romanArr[i][1];
                        while(tempMod > 0){
                            romanStr += romanArr[i][0];
                            tempMod--;
                        }
                    }
                }
            }
            num %= Math.pow(10, i);
        }
        return romanStr;
    }

    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        Solution12 solution = new Solution12();
        System.out.println(solution.intToRoman3(3));     //III
        System.out.println(solution.intToRoman3(4));     //IV
        System.out.println(solution.intToRoman3(9));     //IX
        System.out.println(solution.intToRoman3(58));    //LVIII
        System.out.println(solution.intToRoman3(1994));  //MCMXCIV
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}
