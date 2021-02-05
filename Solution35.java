

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle = (int)Math.floor((start + end ) / 2);
        
        while (start <= end){
            
            if(nums.length == 2){
               if(target <= nums[start]) {
                   return 0;
               } else if(target > nums[start] && target <= nums[end]){
                   return 1;
               }else if(target > nums[end]){
                   return 2;
               }
            } else {
            
                if(target == nums[middle])
                {
                    return middle;
                } else if(target > nums[middle] && start != middle) {
                    start = middle;
                    middle = (int)(Math.ceil(((double)(start + end ) / 2)));
                } else if(target < nums[middle] && start != middle){
                    end = middle;
                    middle = (int)Math.floor(((start + end ) / 2));
                } else if(start == middle || end == middle){
                    return (target < nums[middle])? middle: ++middle;
                } 
            }
        }
        return 0;
    }

    public int searchInsert2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start ++;
            } else {
                end --;
            }
        }
        return start;
    }
    public static void main(String[] arcs){
        long startTime = System.nanoTime();
        Solution35 solution35 = new Solution35();
    
        System.out.println(solution35.searchInsert2(new int[]{1,3,5,6}, 5));     // 2
        System.out.println(solution35.searchInsert2(new int[]{1,3,5,6}, 2));     // 1
        System.out.println(solution35.searchInsert2(new int[]{1,3,5,6}, 7));     // 4 
        System.out.println(solution35.searchInsert2(new int[]{1,3,5,6}, 0));     // 0
        System.out.println(solution35.searchInsert2(new int[]{1,3,5,6}, 3));     // 1
        System.out.println(solution35.searchInsert2(new int[]{3,3}, 3));     // 0
        System.out.println(solution35.searchInsert2(new int[]{1,3}, 4));     // 2
        System.out.println(solution35.searchInsert2(new int[]{1,3}, 2));     // 1
        System.out.println(solution35.searchInsert2(new int[]{1,3}, 0));     // 0

        long stopTime = System.nanoTime();
        System.out.println("Time used: " + (stopTime - startTime));
    }
}