
package Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyWriter {

    public void saveText(String message, String path) {
        if (!isAbsolutePath(path)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                path = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Files.write(Path.of(path), message.getBytes());
            System.out.println("Text saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isAbsolutePath(String path) {
        return Paths.get(path).isAbsolute();
    }
}
