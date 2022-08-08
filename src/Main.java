import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("source/movementList.csv");
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
