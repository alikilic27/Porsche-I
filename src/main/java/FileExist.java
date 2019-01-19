import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExist {
    public static void main(String[] args) {
        String classs= System.getProperty("user.dir");
        System.out.println(classs);
        String home = System.getProperty("user.home");
        System.out.println(home);
        String path= home+"/Downloads/text.txt";
        System.out.println(Files.exists(Paths.get(path)));
    }
}