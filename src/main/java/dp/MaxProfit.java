package dp;

/**
 * Maximum profit by buying and selling a share at most twice In a daily share trading, a buyer buys shares in the
 * morning and sells it on same day. If the trader is allowed to make at most 2 transactions in a day, where as second
 * transaction can only start after first one is complete
 * 
 * @author harish.sharma
 *
 */
public class MaxProfit {

    public int solve(int[] a) {
        int len = a.length;
        int[] profit = new int[len];

        int curMax = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            curMax = Math.max(curMax, a[i]);
            profit[i] = Math.max(profit[i + 1], curMax - a[i]);
        }

        int curMin = a[0];
        for (int i = 1; i < len; i++) {
            curMin = Math.min(curMin, a[i]);
            profit[i] = Math.max(profit[i - 1], profit[i] + (a[i] - curMin));
        }

        return profit[len - 1];
    }

    public static void main(String[] args) {
        int[] a = { 10, 22, 5, 75, 65, 80};
        System.out.println(new MaxProfit().solve(a));
        int[] a1 = { 2, 30, 15, 10, 8, 25, 80};
        System.out.println(new MaxProfit().solve(a1));
        int[] a2 = { 100, 30, 15, 10, 8, 25, 80};
        System.out.println(new MaxProfit().solve(a2));
        int[] a3 = { 90, 80, 70, 60, 50};
        System.out.println(new MaxProfit().solve(a3));
    }
}
