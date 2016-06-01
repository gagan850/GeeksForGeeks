import java.util.Arrays;

//Given an array A[] and a number x, check for pair in A[] with sum as xs
public class ArrayPairSumX {

    public static void main(String[] args) {

        int a[] = { 5, 3, 8, 7, 6, 9, 2 };

        Arrays.sort(a);

        int sum = 17;
        int l = 0;
        int r = a.length - 1;

        for (int i = 0; i < a.length; i++) {

            if (a[l] + a[r] == sum) {

                System.out.println(a[l] + "," + a[r]);
                break;
            } else if (a[l] + a[r] > sum) {
                r--;
            } else {
                l++;
            }

        }

    }
}

