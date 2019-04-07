package PDFfiller_Automation.Lesson_4;

public class MathLogicTask2 {
    //Вывести на консоль количество максимальных чисел среди этих четырех.
    public static void main(String[] args) {
        int a = 12, b = 32, c = 13, d = 14, i = 19;

        if ((a < b) && (a < c) && (a < d) && (a < i)) {
            System.out.println("a - min value");
        } else if ((b < a) && (b < c) && (b < d) && (b < i)) {
            System.out.println("b - min value");
        } else if ((c < a) && (c < b) && (c < d) && (c < i)) {
            System.out.println("c - min value");
        } else if ((d < a) && (d < b) && (d < c) && (c < i)) {
            System.out.println("d  min value");
        }
    }
}




