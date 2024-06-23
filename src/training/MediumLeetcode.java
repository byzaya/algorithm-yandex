package training;

import java.util.Arrays;

public class MediumLeetcode {
    public static int calculate(int n, int left, int right) {
        int minlDistance = Math.min(left, n - right);
        int minrDistance = Math.min(right, n - left);
        return Math.abs(minlDistance-minrDistance);
    }

    public static void main(String[] args) {
        System.out.println(calculate(3, 3, 1));
    }
}
