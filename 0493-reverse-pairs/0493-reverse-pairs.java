class Solution {

    public int reversePairs(int[] nums) {
        int left =  0;
        int right = nums.length-1;
        int ans = mergesort(nums , left , right);
        return ans;
    }

     public static int mergesort(int[] nums, int left , int right){
        if(left>=right){
            return 0;
        }

        int mid = left +(right-left)/2;
        int count = 0;

        count+=mergesort(nums, left , mid);
        count+= mergesort(nums,mid+1,right);

        count+= merge(nums,left, mid, right);

        return count;
     }

     public static int merge(int[] nums, int left , int mid , int right){
        int leftlen = mid-left + 1;
        int rightlen = right - mid;

        int[] leftArr = new int[leftlen];
        int[] rightArr = new int[rightlen];

        for(int i=0;i<leftlen;i++){
            leftArr[i]= nums[left + i];
        }

        for(int i=0;i<rightlen;i++){
            rightArr[i]= nums[mid + 1 + i];
        }

        int count = 0;

        int j = 0;        
        for(int i=0;i<leftlen;i++){
            while(j < rightlen && (long) leftArr[i] > 2L * rightArr[j]){
                j++;
            }
            count+=j;
        }


        int i=0;
        j=0;
        int k=left;

        while(i<leftlen && j<rightlen){
            if(leftArr[i]<rightArr[j]){
                nums[k]=leftArr[i];
                k++;
                i++;
            }else{
                nums[k]=rightArr[j];
                k++;
                j++;
            }
        }

        while(i<leftlen){
            nums[k]= leftArr[i];
            k++;
            i++;
        }

        while(j<rightlen){
            nums[k]= rightArr[j];
            k++;
            j++;
        }

        return count;
     }
}