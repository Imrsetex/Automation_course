package PDFfiller_Automation.Lessons_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatConversionException;

/**
 * Считывает из консоли символ который вы вводите вручную (в консоль).
 * Переобразовывает символ в int
 * Выводит числовое значение символа
 **/

public class ProgramChar {
    public static void main(String[] args) throws IllegalFormatConversionException, IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please type your character : ");
        int value = reader.read();
        System.out.println("Your character converted to: " + value);

    }
}
