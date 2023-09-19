package training;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1101";
        String b = "101";
        int la = a.length();
        int lb = b.length();

        if (la > lb) {
            b = "0".repeat(la - lb) + b;
        } else {
            a = "0".repeat(lb - la) + a;
        }

        int carry = 0;

        StringBuilder ans = new StringBuilder();

        for (int i = a.length() - 1; i >= 0; i--) {
            int d1 = Integer.parseInt(String.valueOf(a.charAt(i)));
            int d2 = Integer.parseInt(String.valueOf(b.charAt(i)));
            int sum = d1 + d2 + carry;
            carry = sum / 2;
            int d = sum % 2;
            ans.append(d);
        }

        if (carry != 0) {
            ans.append(carry);
        }

        String result = ans.reverse().toString();
        System.out.println(result);
    }
}
