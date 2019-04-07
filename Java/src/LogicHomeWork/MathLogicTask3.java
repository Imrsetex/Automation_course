package PDFfiller_Automation.Lesson_4;

public class MathLogicTask3 {
    public static void main(String[] args) {
        //Даны 5 чисел (тип int). Вывести вначале наименьшее, а затем наибольшее из данных чисел.

        int a = 14, b = 12, c = 18, d = 24, e = 54;
        int min = a, max = a;

        if (b < min) { min = b; }
        if (c < min) { min = c; }
        if (d < min) { min = d; }
        if (e < min) { min = e; }
        System.out.println("Minimum is: " + min);

        if (b > max) { max = b; }
        if (c > max) { max = c; }
        if (d > max) { max = d; }
        if (e > max) { max = e; }
        System.out.println("Maximum number is: " + max);
    }
}

