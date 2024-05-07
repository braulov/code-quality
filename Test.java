public class Test {
    public static void print_Numbers(int start, int end) {
        for (int i = start; i <= end; i++) {
            switch (i % 2) {
                case 0 -> System.out.println("Even number: " + i);
                default -> System.out.println("Odd number: " + i);
            }
        }
    }
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    public int f(int x) {
        int x = 1;
        for (int i = 0; i < 10; i++) {
            x += 1;
        }
    }
    public int g(int y) {
        int t = 1;
        for(int i = 0; i<100;i++) {
            if (t==i) {
                if (True) {
                    while (t - i == 0) {
                        t++;
                    }
                }
            }
        }
        return t;
    }
    public static int sum(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        return result;
    }

    public static int factorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

    public static String day_Of_Week(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Invalid day";
        };
    }
    void p() {
        return;
    }
}
