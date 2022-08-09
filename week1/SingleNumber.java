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
        Object[] freqArray=freq.toArray();
        if (freqArray.length==1) {
            return (int) freqArray[0];
        }
        return -1;
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
