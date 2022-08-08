public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int current = -99999;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (current != nums[i]) {
                current = nums[i];
                nums[counter] = current;
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums1 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums1));

        int[] nums2 = { 1, 1, 2 };
        System.out.println(removeDuplicates(nums2));
    }
}
