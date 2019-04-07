package PDFfiller_Automation.Lesson_4;

import java.util.Scanner;

public class MathLogicTask5 {

    //Дано число месяца (тип int). Необходимо определить время года (зима, весна, лето, осень) и вывести на консоль.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of month");
        int month = scanner.nextInt();
        String result;
        switch (month) {
            case 1:
            case 2:
            case 12:
                result = "You entered a Winter month";
                break;
            case 3:
            case 4:
            case 5:
                result = "You entered a Spring month";
                break;
            case 6:
            case 7:
            case 8:
                result = "You entered a Summer month";
                break;
            case 9:
            case 10:
            case 11:
                result = "You entered a Autumn month";
                break;
            default:
                result = "You entered invalid month. Please try again";
        }
        System.out.println(result);
    }
}

