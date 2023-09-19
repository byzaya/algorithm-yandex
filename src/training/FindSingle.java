package training;

public class FindSingle {
    public static void main(String[] args) {
        int[] m = {3, 4, 3, 4, 5, 8, 9, 8, 9};
        int l = m.length;
        int r = 0;

        for (int i = 0; i < l; i++) {
            r ^= m[i];
        }
        System.out.println(r);
    }
}
