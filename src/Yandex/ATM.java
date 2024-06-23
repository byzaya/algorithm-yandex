package Yandex;
/// банкомат

public class ATM {
    private final long[] money;
    private final int[] coin;

    public ATM() {
        money = new long[5];
        coin = new int[] {20, 50, 100, 200, 500};
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            money[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] result = new int[5];
        for (int i = 4; i >= 0; i--) {
            int k = (int) Math.min(money[i], amount / coin[i]); // choose larger coin at best we can
            result[i] = k;
            amount -= k * coin[i];
        }
        if (amount != 0) {
            return new int[] {-1};
        }
        for (int i = 0; i < 5; i++) {
            money[i] -= result[i];
        }
        return result;
    }
}
