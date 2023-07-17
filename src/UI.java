import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
    public static int getUserChoice() throws IOException {
        System.out.println("1. Encrypt\n2. Decrypt\n3. Brute Force Decrypt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(reader.readLine());
        return choice;
    }

    public static String[] getInputFiles() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the input file path: ");
        String input_file = reader.readLine();
        System.out.print("Enter the output file path: ");
        String output_file = reader.readLine();
        return new String[] { input_file, output_file };
    }
}