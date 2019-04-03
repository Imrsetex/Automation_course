package PDFfiller_Automation.Lessons_2;

public class MathProgram4 {

    /**
     * 4.В переменной n хранится натуральное трёхзначное число.
     * Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
     */

    public static int bigSum(long math) {

        long r = 0;
        System.out.print(" Sum digits " + math + " = ");
        while (math != 0) {

            r += math % 10;
            math /= 10;

        }
        System.out.println(r);
        return (int) r;
    }
}

class RunProgram {
    public static void main(String[] args) {
        MathProgram4.bigSum(123);
    }
}
