package pargunov.medium;

public class TwoSum_II_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        while(left < right) {
            int currentSum = numbers[left] + numbers[right];
            if(currentSum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if(currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
