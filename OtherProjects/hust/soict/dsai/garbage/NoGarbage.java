import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "TestFile.exe";
        byte[] inputBytes = { 0 };
        long startTime;
        long endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        
        for (byte b: inputBytes) {
            stringBuilder.append((char)b);
        }
        
        String outputString = stringBuilder.toString();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
