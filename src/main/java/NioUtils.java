import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class NioUtils {
    public static void writePeopleToFile(List<People> people) throws IOException {

        List<String> list = people.stream().map(p ->
                        String.format("%s,%d,%s", p.getName(), p.getAge(), p.getSex())).toList();
        Path directoryPath = Path.of("output");
        Path filePath = Path.of("output\\result.csv");

        Files.deleteIfExists(filePath);
        Files.deleteIfExists(directoryPath);

        try {
            Files.createDirectories(directoryPath);
            Files.createFile(filePath);

            Files.write(filePath, list);
            System.out.println("done!");
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void picDownload(String url, String name) {
        Path path = Path.of(name);
        try (InputStream inputStream = new URL(url).openStream()) {

            Files.deleteIfExists(path);
            Files.copy(inputStream, path);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<String> readFile(String name){
        try {
            return Files.readAllLines(Path.of("output\\result.csv"));
        } catch (IOException e) {
            System.err.println(e);
            return Collections.emptyList();
        }
    }
}

