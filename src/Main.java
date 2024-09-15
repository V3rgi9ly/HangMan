import java.awt.desktop.OpenURIEvent;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int MAXTRY = 6;
    private static String[] glawo = {
            " _____\n",
            " |   |\n",
            " |   \n",
            " |   \n",
            " |   \n",
            "-----------"
    };

    public static void main(String[] args) {
        startedGame();
    }

    public static void startedGame() {
        String word = "Слово";
        String[] letter = CheckongTheLetter(word);
    }

    public static void displayGallow() {
        for (String line : glawo) {
            System.out.print(line);
        }
    }

    public static void updateGallow(int step) {
        switch (step) {
            case 1:
                glawo[2] = " |   O\n";
                break;
            case 2:
                glawo[3] = " |   |\n";
                break;
            case 3:
                glawo[3] = " |  /|\n";
                break;
            case 4:
                glawo[3] = " |  /|\\\n";
                break;
            case 5:
                glawo[4] = " |  / \n";
                break;
            case 6:
                glawo[4] = " |  / \\\n";
                break;
            default:
                break;
        }
    }

    public static void outputGallow(int i) {

        for (; i <= MAXTRY;) {
            updateGallow(i);
            displayGallow();
            break;
        }
    }

    public static char inputPlayerTheLetter() {
        //Игрок 2 вводит букву через scanner
        System.out.println("\nВведи букву: ");
        String input = scanner.nextLine();
        return input.charAt(0);
    }

    public static String[] CheckongTheLetter(String word) {
        int i = 0;
        String[] m = new String[word.length()];
        ArrayList<Character> arrayErrorLetter=new ArrayList<Character>();
        String e = "";
        String gg = "";
        char chars;
        displayGallow();
        while (i <= MAXTRY) {
            boolean foundLetter = false;
            chars = inputPlayerTheLetter();
            for (int j = 0; j < word.length(); j++) {

                if (word.charAt(j) == chars) {
                    foundLetter = true;
                    System.out.println("Вы угадали букву!");
                    m[j] = Character.toString(chars);
                    e = Arrays.toString(m);
                    gg = e.replaceAll("[\\[\\],\\s]", "");
                    System.out.println(gg);
                }
            }
            if (!foundLetter) {
                System.out.println("Вы не угадали букву!");
                System.out.println(arrayErrorLetter.add(chars));
                ++i;
                outputGallow(i);
            }

            if (gg.equals(word)) {
                System.out.println("\nВы угадали слово, поздравляем!!!");
                break;
            }
            if (i == MAXTRY) {
                System.out.println("\nОтгадывающий проиграл, загадонное слово" + "-" + word);
                break;
            }
        }
        return m;
        //Проверяется условие на совпадение буквы в слове
        //цикл while с условием когда ошибок не должно быть больше 6
    }


}
