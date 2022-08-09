public class ShuffleTheArray {
    public static int[] shuffle(int[] nums, int n) {
        int lengthArr = nums.length;
        int[] newArr = new int[lengthArr];
        int index = 0;
        for (int i = 0, j = n; i < lengthArr - n && j < lengthArr; i++, j++) {
            newArr[index] = nums[i];
            newArr[index + 1] = nums[j];
            index += 2;
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 1, 3, 4, 7};
        System.out.println(shuffle(nums1, 3));

        int[] nums2 = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(shuffle(nums2, 4));

        int[] nums3 = {1, 1, 2, 2};
        System.out.println(shuffle(nums3, 2));
    }
}
