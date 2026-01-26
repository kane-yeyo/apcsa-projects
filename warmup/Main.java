package warmup;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int sum = 0;
            if (i%3 == 0 || i%5 == 0) {
                System.out.println(i);
                sum += i;
            }
            System.out.println(sum);
        }

    } //chose prompt 1
}
