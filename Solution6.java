


class Solution6 {
    public String convert(String s, int numRows) {
        
        char[] result = new char[s.length()];
        
        if(s == null || s.length() == 0){
            return "";
        } else if(numRows <= 1 || s.length() <= numRows){
            return s;
        } else {
            int pos = 0;
            int size = 0;
            boolean isReverted = false;

            for(int rowCount = 0 ; rowCount < numRows ; rowCount++){
               isReverted = false;
                size = 2 * numRows - 2 - 2 * (rowCount % (numRows - 1));
               
                for(int i = rowCount ; i < s.length() ; i+=size){ 
                    if(isReverted){
                        size = 2 * numRows - 2 - size;
                    }
                    result[pos] = s.charAt(i);   
                    if(rowCount%(numRows-1) != 0){
                        isReverted = true;
                    }
                    pos++;                  
                }
            }
            return new String(result);
            
        }
    }

    public String sample1(String s, int numRows) {
        if (numRows == 1)
            return s;
        int Size = 2 * numRows - 2, str_size = s.length(), index = 0;
        char[] str = new char[str_size];
        for(int i = 0; i < numRows; i++){
            int Step = Size - i * 2;
            for (int j = i; j < str_size; j = j + Size){
                str[index] = s.charAt(j);
                index++;
                if ((i != 0 && i != numRows - 1) && (j + Step < str_size)){
                    str[index] = s.charAt(j + Step);
                    index++;
                }
                
            }
        }
        return new String(str);
    }
    public String sample2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i, k = 0; j < s.length(); k++) {
                builder.append(s.charAt(j));
                if (i  == 0 || (i  != numRows -1 && k % 2 == 0)) {
                    j += 2 * (numRows - i) - 2;
                } else {
                    j += 2 * i;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] arcs) {
        long startTime = System.nanoTime();
        Solution6 solution6 = new Solution6();        
        
        System.out.println("result: " + solution6.convert("ABV", 1)); // PAHNAPLSIIGYIR
        //System.out.println("result: " + solution6.convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
        



    }

}