package practice3;

public class mathEquations {
    public static void main(String[] args) {
        equation5();
        equation10();
        equation15();
    }

    // Завдання 5: Обчислити суму ряду:
    // S = sum_{i=1}^{k} log10( sqrt(s * (1 / i^2)) ), де 1 <= k < 35, s > 0
    public static void equation5() {
        int k = 10;      // 1 <= k < 35
        double s = 4.0;  // s > 0

        if (k < 1 || k >= 35) {
            throw new IllegalArgumentException("Параметр k має бути в межах 1 <= k < 35. Отримано: " + k);
        }
        if (s <= 0) {
            throw new IllegalArgumentException("Параметр s має бути строго більшим за 0. Отримано: " + s);
        }

        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            sum += Math.log10(Math.sqrt(s * (1.0 / (i * i))));
        }

        System.out.println("Відповідь до 5-го завдання: sum = " + sum);
    }

    // Завдання 10: Обчислити значення кускової функції:
    // x(t, n) = sum_{i=1}^{n} (t^2 * i),    якщо t < 0
    // x(t, n) = sum_{i=1}^{n} sqrt(t * i),  якщо t >= 0
    // де n >= 1
    public static void equation10() {
        double t = -2.5;
        int n = 5;

        if (n < 1) {
            throw new IllegalArgumentException("Параметр n має бути >= 1. Отримано: " + n);
        }

        double sum = 0.0;
        if (t < 0) {
            for (int i = 1; i <= n; i++) {
                sum += Math.pow(t, 2) * i;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                sum += Math.sqrt(t * i);
            }
        }

        System.out.println("Відповідь до 10-го завдання: x(t, n) = " + sum);
    }

    // Завдання 15: Обчислити нескінченну суму із заданою точністю eps (eps > 0):
    // S = sum_{i=1}^{inf} (-1)^(i+1) / ( i * (i + 1) * (i + 2) )
    // Вважати точність досягнутою, якщо |term| < eps
    public static void equation15() {
        double eps = 1e-5;

        if (eps <= 0 || Double.isNaN(eps)) {
            throw new IllegalArgumentException("Параметр eps має бути > 0. Отримано: " + eps);
        }

        double sum = 0.0;
        int i = 1;

        while (true) {
            double term = Math.pow(-1, i + 1) / ((double) i * (i + 1) * (i + 2));
            if (Math.abs(term) < eps) {
                break;
            }
            sum += term;
            i++;
        }

        System.out.println("Відповідь до 15-го завдання: sum = " + sum);
    }
}
