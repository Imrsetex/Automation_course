package PDFfiller_Automation.Lesson_4;

public class MathLogicTask4 {
    //Даны имена 2х человек (тип String). Если имена равны, то вывести сообщение о том, что люди являются тезками.
    public static void main(String[] args) {

        String firstName = "Arnold";
        String secondName = "Arnold";

        if (firstName == secondName) {
            System.out.println(firstName + " and " + secondName + " – people are teaser");
        }
        else{
            System.out.println(firstName + " and " + secondName + " – people aren't teaser");
        }
    }
}
