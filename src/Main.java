import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\torrents\\SkillBox - Java-разработчик\\09.Работа с файлами и сетью\\9.9 Домашняя работа 9.3\\movementList.csv");
        try {
            List<String> lines = Files.readAllLines(path);
            Parser parser = new Parser();
            List<Transaction> transactions = parser.parsCSVToTransaction(lines);
            double sum =0;
            for(Transaction tr : transactions){
                sum+=tr.getWithdraw();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
