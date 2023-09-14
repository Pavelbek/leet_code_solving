package pargunov.easy;

public class FindSmallestLetterGreaterThanTarget_744 {
    public static void main(String[] args) {
        char[] arr1 = {'c', 'f', 'j'};
        char[] arr2 = {'c', 'f', 'j'};
        char[] arr3 = {'x', 'x', 'y', 'y'};
        char[] arr4 = {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        char[] arr5 = {'c', 'd', 'w'};


//        System.out.println(nextGreatestLetter(arr1, 'a')); // output 'c'
//        System.out.println(nextGreatestLetter(arr2, 'c')); // output 'f'
//        System.out.println(nextGreatestLetter(arr3, 'z')); // output 'x'
//        System.out.println(nextGreatestLetter(arr4, 'e')); // output 'n'
        System.out.println(nextGreatestLetter(arr5, 'e')); // output 'n'

    }

    private static char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];

        int l = 0;
        int r = letters.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                res = letters[mid];
                r = mid - 1;
            }
        }

        return res;
    }
}
