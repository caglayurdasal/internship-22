public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int newLength = nums.length;
        int i = 0, j;
        if (newLength == 0 || newLength == 1 && nums[0] == val) {
            return 0;
        }
        for (j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            } else {
                newLength--;
            }
        }
        System.out.print("New array: ");
        for (i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }

        return newLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 2, 3}; // 2, nums1 = [2,2,_,_]
        System.out.println("\nNew length: " + removeElement(nums1, 3) + "\n");

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2}; // 5, nums2 = [0,1,4,0,3,_,_,_]
        System.out.println("\nNew length: " + removeElement(nums2, 2) + "\n");

        int[] nums3 = {4, 5};    // 1, nums2 = [4]
        System.out.println("\nNew length: " + removeElement(nums3, 5) + "\n");
    }
}