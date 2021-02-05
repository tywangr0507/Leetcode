

class Solution11 {

    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while(left < right){
            int area = 0;
            if(height[left] <= height[right]) {
                area = height[left] * (right - left);
                left++;
            } else {
                area = height[right] * (right - left);
                right--;
            }
            result = (area > result) ? area : result;
        }
        return result;
    }

    public static void main(String[] arcs){

        /*
        Given n non-negative integers a1, a2, ..., an , 
        where each represents a point at coordinate (i, ai). 
        n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
        Find two lines, which together with x-axis forms a container, 
        such that the container contains the most water.
        Note: You may not slant the container and n is at least 2.
        */
        Solution11 solution = new Solution11();
        
        System.out.println(solution.maxArea(new int[] {1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(solution.maxArea(new int[] {1,1})); //   1
        System.out.println(solution.maxArea(new int[] {4,3,2,1,4})); //   16
        System.out.println(solution.maxArea(new int[] {1,2,1})); //   2

    }
}