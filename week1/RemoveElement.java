public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int newLength = nums.length;
        int i=0,j;
        if (newLength==0 || newLength==1 && nums[0]==val){
            return 0;
        }
        for (j = 0; j < nums.length; j++) {
                if (nums[j]!=val){
                    nums[i]=nums[j];
                    i++;
                }
                else{
                    newLength--;
                }
        }
        for(i=0;i<newLength;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        return newLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3};
        System.out.println(removeElement(nums1, 3)); // 2, nums1 = [2,2,_,_]

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums2, 2)); // 5, nums2 = [0,1,4,0,3,_,_,_]
        int[] nums3 = {4,5};
        System.out.println(removeElement(nums3, 5)); // 1, nums2 = [4]
    }
}