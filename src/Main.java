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
        startGame();
    }

    public static void startGame(){
        wordSecret = inputSecretWordFirstPlayer();
        wordCloneForLetter = wordSecret;
        CheckingTheLetter();
    }

    public static String CheckingTheLetter() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder(isGetCloneWord());
        displayGallow();
        System.out.println("\nСлово:" + isGetCloneWord());
        while (i <= MAXTRY) {
            boolean foundLetter = false;
            inputLetterPlayer = inputPlayerTheLetter();
            for (int j = 0; j < wordSecret.length(); j++) {
                if (wordSecret.charAt(j) == inputLetterPlayer.charAt(0)) {
                    foundLetter = true;
                    System.out.println("Вы угадали букву!");
                    stringBuilder.setCharAt(j, inputLetterPlayer.charAt(0));
                    recordWord = stringBuilder.toString();
                    System.out.println("Слово:" + recordWord);
                    System.out.println("Ошибки:" + lettersError.toString());
                }
            }
            if (!foundLetter) {
                System.out.println("Вы не угадали букву!");
                System.out.println("Слово:" + isGetCloneWord());
                ++i;
                lettersError.add(inputLetterPlayer);
                System.out.println("Ошибки:" + lettersError.toString());
                outputGallow(i);
            }

            checkingWords(recordWord);
            checkingTheAttempt(i);

        }
        return recordWord;
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

    public static String isGetCloneWord() {
        return wordCloneForLetter.replaceAll("[а-яa-zA-ZА-Я]", "*");
    }

    public static boolean сheckingWords() {
        if (recordWord.equals(wordSecret)) {
            System.out.println("\nВы угадали слово, поздравляем!!!");
            return true;
        }
        return false;
    }

    public static int inputPlayerTheNumber() {
        //Игрок 2 вводит букву через scanner
        System.out.println("Введите цифру:");
        int i = Integer.parseInt(scanner.next());
        return i;
    }

    public static boolean checkingWords(String recordWord) {
        if (wordSecret.equals(recordWord)) {
            System.out.println("\nВы угадали слово, поздравляем!!!");
            restartExitGame();
            return true;

        }
        return false;
    }

    public static boolean checkingTheAttempt(int attempt) {
        if (attempt == MAXTRY) {
            System.out.println("\nОтгадывающий проиграл, загадонное слово" + "-" + wordSecret);
            restartExitGame();
            return true;

        }
        return false;
    }

    public static ArrayList<String> zeroingTheArray() {
        for (int i = lettersError.size() - 1; i >= 0; i--) {
            lettersError.remove(i);
        }
        return lettersError;
    }

    public static String[] zeroingTheGallows() {
        glawos = new String[]{
                " _____\n",
                " |   |\n",
                " |   \n",
                " |   \n",
                " |   \n",
                "-----------"
        };
        return glawos;
    }

    public static void restartExitGame(){
        System.out.println("Вы хотите повторить игру?");
        System.out.println("Выйти из игры-нажмите на число 1");
        System.out.println("Повторить игру-нажмите на число 2");
        int i=inputPlayerTheNumber();
        if (i==1){
            System.exit(0);
        }
        if (i==2){
            zeroingTheArray();
            zeroingTheGallows();
            startGame();
        }
    }

    public static String inputSecretWordFirstPlayer() {
        System.out.println("Введи секретное слово:");
        String secretWord = scanner.next();
        return secretWord;
    }
}