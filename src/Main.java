import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static int randomIndex;

    private static int MAXTRY = 6;
    private static String wordSecret;
    private static String wordCloneForLetter;
    private static String inputLetterPlayer;
    private static String recordWord;
    private static ArrayList<String> lettersError = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        restartExitGame();
        startGame();
    }

    public static void startGame() throws IOException {
        Path path = Paths.get("src\\words");
        List<String> lines = Files.readAllLines(path);
        String[] words = new String[lines.size()];
        String s;
        for (int i = 0; i <= words.length - 1; i++) {
            s = lines.get(i);
            words[i] = s;

        }


        wordSecret = words[random.nextInt(words.length)].toLowerCase();
        ;
        wordCloneForLetter = "*".repeat(wordSecret.length());
        CheckingTheLetter();
    }

    public static String CheckingTheLetter() throws IOException {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder(wordCloneForLetter);

        System.out.println("\nСлово:" + wordCloneForLetter);
        while (i <= MAXTRY) {
            boolean foundLetter = false;
            inputLetterPlayer = inputPlayerTheLetter();
            for (int j = 0; j < wordSecret.length(); j++) {
                if (wordSecret.charAt(j) == inputLetterPlayer.charAt(0)) {
                    foundLetter = true;
                    outputGallows(foundLetter, i);
                    System.out.println("Вы угадали букву!");
                    stringBuilder.setCharAt(j, inputLetterPlayer.charAt(0));
                    wordCloneForLetter = stringBuilder.toString();
                    System.out.println("Слово:" + wordCloneForLetter);
                    System.out.println("Ошибки:" + lettersError.toString());

                }
            }
            if (!foundLetter) {
                System.out.println("Вы не угадали букву!");

                System.out.println("Слово:" + wordCloneForLetter);
                ++i;
                outputGallows(foundLetter, i);
                lettersError.add(inputLetterPlayer);
                System.out.println("Ошибки:" + lettersError.toString());
                //outputGallow(i);
            }

            checkingWords(wordCloneForLetter);
            checkingTheAttempt(i);

        }
        return wordCloneForLetter;
    }

    public static void outputGallows(boolean condition, int maxTry) {
        if (condition == true) {
            System.out.println(Glawos.glawose[maxTry]);
        } else if (condition == false) {
            System.out.println(Glawos.glawose[maxTry]);
        }

    }

    public static String inputPlayerTheLetter() {

        System.out.println("\nВведи букву: ");
        inputLetterPlayer = scanner.next();
        return inputLetterPlayer.toLowerCase();
    }

    public static String isGetCloneWord() {
        return wordCloneForLetter.replaceAll("[а-яa-zA-ZА-Я]", "*");
    }

    public static int inputPlayerTheNumber() {

        System.out.println("Введите цифру:");
        int i = Integer.parseInt(scanner.next());
        return i;
    }

    public static boolean checkingWords(String recordWord) throws IOException {
        if (wordSecret.equals(recordWord)) {
            System.out.println("\nВы угадали слово, поздравляем!!!");
            restartExitGame();
            return true;

        }
        return false;
    }

    public static boolean checkingTheAttempt(int attempt) throws IOException {
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


    public static void restartExitGame() throws IOException {
        System.out.println("Вы хотите начать игру?");
        System.out.println("Выйти из игры-нажмите на число 1");
        System.out.println("Начать игру-нажмите на число 2");
        int i = inputPlayerTheNumber();
        if (i == 1) {
            System.exit(0);
        }
        if (i == 2) {
            zeroingTheArray();
            startGame();
        }
    }

//    public static boolean listErrorLetter(String letter) throws IOException {
//        if (lettersError.isEmpty()) {
//            lettersError.add(letter);
//            return false;
//        } else {
//            for (int i = 0; i <=lettersError.size()-1; i++) {
//                if (letter.equals(lettersError.get(i))) {
//                    break;
//
//                } else {
//                    lettersError.add(letter);
//                }
//            }
//            return true;
//        }
//
//    }

}