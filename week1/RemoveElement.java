public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int newLength = nums.length;
        int newIndex = 0, currentIndex;
        if (newLength == 0 || newLength == 1 && nums[0] == val) {
            return 0;
        }
        // Traverse the array
        for (currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            if (nums[currentIndex] != val) {
                nums[newIndex] = nums[currentIndex];
                newIndex++;
            } else {
                newLength--;
            }
        }
        System.out.print("New array: ");
        for (newIndex = 0; newIndex < newLength; newIndex++) {
            System.out.print(nums[newIndex] + " ");
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