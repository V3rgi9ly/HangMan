import java.util.Scanner;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int MAXTRY = 6;
    private static String wordSecret;
    private static String wordCloneForLetter;
    private static String inputLetterPlayer;
    private static String recordWord;
    private static ArrayList<String> lettersError = new ArrayList<String>();
    private static String[] glawos = {
            " _____\n",
            " |   |\n",
            " |   \n",
            " |   \n",
            " |   \n",
            "-----------"
    };

    public static void main(String[] args) {
        wordSecret = "Слово";
        wordCloneForLetter = wordSecret;
        startedGame();
    }

    public static void startedGame() {

        String letter = CheckongTheLetter();
    }

    public static void displayGallow() {
        for (String line : glawos) {
            System.out.print(line);
        }
    }

    public static void updateGallow(int step) {
        switch (step) {
            case 1:
                glawos[2] = " |   O\n";
                break;
            case 2:
                glawos[3] = " |   |\n";
                break;
            case 3:
                glawos[3] = " |  /|\n";
                break;
            case 4:
                glawos[3] = " |  /|\\\n";
                break;
            case 5:
                glawos[4] = " |  / \n";
                break;
            case 6:
                glawos[4] = " |  / \\\n";
                break;
            default:
                break;
        }
    }

    public static void outputGallow(int i) {

        for (; i <= MAXTRY; ) {
            updateGallow(i);
            displayGallow();
            break;
        }
    }

    public static String inputPlayerTheLetter() {
        //Игрок 2 вводит букву через scanner
        System.out.println("\nВведи букву: ");
        inputLetterPlayer = scanner.next();
        return inputLetterPlayer;
    }

    public static String CheckongTheLetter() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder(isGetCloneWord());
        displayGallow();
        System.out.println("\nСлово:"+isGetCloneWord());
        while (i <= MAXTRY) {
            boolean foundLetter = false;
            inputLetterPlayer = inputPlayerTheLetter();
            for (int j = 0; j < wordSecret.length(); j++) {
                if (wordSecret.charAt(j) == inputLetterPlayer.charAt(0)) {
                    foundLetter = true;
                    System.out.println("Вы угадали букву!");
                    stringBuilder.setCharAt(j, inputLetterPlayer.charAt(0));
                    recordWord = stringBuilder.toString();
                    System.out.println("Слово:"+recordWord);
                    System.out.println("Ошибки:"+ lettersError.toString());
                }
            }
            if (!foundLetter) {
                System.out.println("Вы не угадали букву!");
                System.out.println("Слово:"+recordWord);
                ++i;
                lettersError.add(inputLetterPlayer);
                System.out.println("Ошибки:"+ lettersError.toString());
                outputGallow(i);
            }


            if (i == MAXTRY) {
                System.out.println("\nОтгадывающий проиграл, загадонное слово" + "-" + wordSecret);
                break;
            }
        }
        return recordWord;
        //Проверяется условие на совпадение буквы в слове
        //цикл while с условием когда ошибок не должно быть больше 6
    }

    public static String isGetCloneWord(){
        return  wordCloneForLetter.replaceAll("[а-яa-zA-ZА-Я]", "*");
    }

    public static boolean сheckingWords(){
        if (recordWord.equals(wordSecret)) {
            System.out.println("\nВы угадали слово, поздравляем!!!");
            return true;
        }
        return false;
    }

//    public static String inputPlayerTheNumber() {
//        //Игрок 2 вводит букву через scanner
//
//        int i = scanner.next();
//        return i;
//    }

}