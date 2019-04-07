package PDFfiller_Automation.Lessons_2;

public class MathProgram1 {
    /**
     * 2. В переменной n хранится натуральное двузначное число.
     * Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
     **/

    public static void main(String[] args) {

        int n = 55;
        int w = n % 10;
        int c = (n / 10) % 10;

        System.out.println("The sum of the digits of the number: " + n + ". \nIs equal to " + (w + c));

    }
}



