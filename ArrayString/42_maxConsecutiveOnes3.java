public int longestOnes(int[] nums, int k) {
        int si = 0, ei = 0, n = nums.length, len = 0, count = 0;
        while(ei < n){
            if(nums[ei++] == 0) count++;
            
            while(count > k){
                if(nums[si++] == 0) count--;
            }
            
            len = Math.max(len, ei - si);
        }
        return len;
    }