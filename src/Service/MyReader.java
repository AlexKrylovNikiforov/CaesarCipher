package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MyReader {

    public String getText(String path) {
        String inputPath = path;

        if (!isAbsolutePath(inputPath)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                inputPath = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            List<String> lines = Files.readAllLines(Path.of(inputPath));
            return String.join("\n", lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
    private boolean isAbsolutePath(String path) {
        return Paths.get(path).isAbsolute();
    }
}
