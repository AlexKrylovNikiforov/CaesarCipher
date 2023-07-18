
package Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSaver {

    public void saveText(String message, String path) {
        Path outputPath = Path.of(path);
        if (isNotAbsolutePath(path)) {
            outputPath = (outputPath.toAbsolutePath());
        }
        try {
            Files.write(outputPath, message.getBytes());
            System.out.println("Text saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isNotAbsolutePath(String path) {
        return !Paths.get(path).isAbsolute();
    }
}
