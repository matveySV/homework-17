import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatPath;
import static org.junit.jupiter.api.Assertions.*;

class NioUtilsTest {

    @Test
    void shouldWritePeopleToCsv() throws IOException {
        List<People> people = List.of(
                new People("Anton",23,Sex.MAN),
                new People("Katya",32,Sex.WOMAN));

        NioUtils.writePeopleToFile(people);
        Path path = Path.of("output", "result.csv");
        assertThatPath(path)
                .exists().
                hasExtension("csv")
                .hasContent("Anton,23,MAN\nKatya,32,WOMAN");
    }

    @Test
    void shouldExistPicDownload() {
      String url =  "https://img-9gag-fun.9cache.com/photo/a970mDj_700bwp.webp";
      NioUtils.picDownload(url,"image.jpeg");

        assertThatPath(Path.of("image.jpeg")).exists().hasExtension("jpeg");
    }

    @Test
    void  shouldReadFromFile(){
        NioUtils.readFile("result.csv");
        Path path = Path.of("output", "result.csv");
        assertThatPath(path).hasContent("Вася,16,MAN\n"+"Петя,23,MAN\n"+"Елена,42,WOMAN\n"+"Иван Иванович,69,MAN");
    }
}