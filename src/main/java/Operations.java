public class Operations {
    public static void main(String[] args) {
        int a = 51;
        int b = 17;
        int c = 24;
        int d = 9;

        System.out.println((a+b) > (c+d));

        int sum1 = a+b;
        int sum2 = c+d;
        sum1++;
        sum2--;
        sum2--;

        System.out.println(sum1 + " and " + sum2);

        System.out.println(sum1 <= sum2);

        System.out.println((sum1%2) == 0 || (sum2%2) == 0);
    }
}
