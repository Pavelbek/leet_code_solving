package pargunov.medium;

public class PeakIndexInMountainArray_852 {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0};
        int[] arr2 = {0, 2, 1, 0};
        int[] arr3 = {0, 4, 5, 11, 2};

        System.out.println(peakIndexInMountainArray(arr1)); // 1
        System.out.println(peakIndexInMountainArray(arr2)); // 1
        System.out.println(peakIndexInMountainArray(arr3)); // 3
    }

    private static int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
}
