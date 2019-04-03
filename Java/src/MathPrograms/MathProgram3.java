package PDFfiller_Automation.Lessons_2;

public class MathProgram2 {

    /**
     * 3. В переменной n хранится вещественное число с ненулевой дробной частью.
     * Создайте программу, округляющую число n до ближайшего целого и выводящую результат на экран.
     **/

    public static void main(String[] args) {

        double a = 55.1;
        double n = a - (int) a;
        System.out.print(a + " округляем и получаться - ");
        if (n >= 0.5) {

            a += 1;

        } else a = (int) a;
        System.out.println((int) a);
    }
}
