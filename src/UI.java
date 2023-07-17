import Service.MyReader;
import Service.MyWriter;

import java.util.*;

public class UI {

    private final CaesarCipher cc = new CaesarCipher();
    private final BruteForceCipher bfc = new BruteForceCipher();
    private final Scanner sc = new Scanner(System.in);
    private final MyReader reader = new MyReader();
    private final MyWriter writer = new MyWriter();

    public void start() {
        int choice;
        while (true) {
            displayMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> {
                    String inputPath = getInputPath();
                    String text = reader.getText(inputPath);
                    String outputPath = getOutputPath();
                    int key = getKey();
                    String encryptedText = cc.encrypt(text, key);
                    writer.saveText(encryptedText, outputPath);
                }
                case 2 -> {
                    String inputPath = getInputPath();
                    String text = reader.getText(inputPath);
                    String outputPath = getOutputPath();
                    int key = getKey();
                    String decryptedText = cc.decrypt(text, key);
                    writer.saveText(decryptedText, outputPath);
                }
                case 3 -> {
                    String inputPath = getInputPath();
                    String forceDecryptedText = bfc.decrypt(inputPath);
                    String outputPath = getOutputPath();
                    writer.saveText(forceDecryptedText, outputPath);
                }

                case 4 -> {
                    System.out.println("Good Bye!");
                    return;
                }
                default -> System.out.println("Wrong value entered, try again");
            }
        }
    }
    private void displayMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Encrypt text");
        System.out.println("2. Decrypt text");
        System.out.println("3. Brute Force decryption");
        System.out.println("4. Exit");
    }

    private String getInputPath() {
        System.out.println("Please enter a path to input file:");
        return sc.nextLine();
    }

    private String getOutputPath() {
        System.out.println("Please enter a path to output file:");
        return sc.nextLine();
    }

    private int getKey() {
        System.out.println("Please enter a key value:");
        return sc.nextInt();
    }
}