import java.util.HashSet;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        HashSet<Integer> freq = new HashSet<Integer>();

        for (int num : nums) {
            if (freq.contains(num)) {
                freq.remove(num);
            } else {
                freq.add(num);
            }
        }
        int singleNum = -1;
        for (int num : freq) {
            singleNum = num;
        }
        return singleNum;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2, 1, 2};
        System.out.println("Single number: " + singleNumber(nums1));

        int[] nums2 = {2, 2, 1};
        System.out.println("Single number: " + singleNumber(nums2));

        int[] nums3 = {1};
        System.out.println("Single number: " + singleNumber(nums3));

    }
}
