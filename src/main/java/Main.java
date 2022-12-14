import java.io.IOException;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException {
        List<People> people = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMAN),
                new People("Иван Иванович", 69, Sex.MAN));

        NioUtils.writePeopleToFile(people);
        NioUtils.picDownload("https://img-9gag-fun.9cache.com/photo/a970mDj_700bwp.webp","image.jpeg");
        System.out.println(NioUtils.readFile("result.csv"));
    }

}
