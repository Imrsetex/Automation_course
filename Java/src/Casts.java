package PDFfiller_Automation;

public class Casts {
    /**
     * Написать класс в котором будут примеры приведения типов:
     * 1.int->char
     * 2.float->char
     * 3.float->char->int
     */
    public static void main(String[] args) {

        int d = 1028;
        char c = (char) (d);
        System.out.println(c);

        float i = 2015.4f;
        char f = (char) (i);
        System.out.println(f);

        float f2 = 2015.4f;
        char ch1 = (char) (f2);
        System.out.println(ch1);

        int i2 = Character.getNumericValue(ch1);
        System.out.println(i2);

    }

}
