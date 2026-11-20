public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,12};
        int[] nums1 = new int[nums.length];

        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0) {
                nums1[j] = nums[i];
                j++;
            }
        }

        for(int arr : nums1){
            System.out.print(arr+" ");
        }
    }
}
