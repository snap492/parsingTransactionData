import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Parser {
    public List<Transaction> parsCSVToTransaction(@NotNull List<String> list) {
        List<Transaction> result = new ArrayList<>();
        list.remove(0);
        list.forEach(line -> {
            line = cleanStr(line);
            String[] str = line.split(",");
            Transaction tr = new Transaction();
            tr.setAccountName(str[0]);
            tr.setAccountNumber(Double.parseDouble(str[1]));
            tr.setCurrency(str[2]);
            tr.setOperationDate(datePars(str[3]));
            tr.setOperationCode(str[4]);
            tr.setDescription(str[5]);
            tr.setDeposit(Double.parseDouble(str[6]));
            tr.setWithdraw(Double.parseDouble(str[7]));
            result.add(tr);
        });
        return result;
    }
    private String cleanStr (String str){
        if (!str.contains("\"")){
            return str;
        }
          int startIndex = str.indexOf("\"");
        int indexEnd = str.indexOf("\"",startIndex+1);
        String subStr = str.substring(startIndex,indexEnd);
        subStr = subStr.replaceAll(",",".");
        subStr = subStr.replaceAll("\"","");
        str = str.replaceAll(str.substring(startIndex,indexEnd+1),subStr);
        return str;
    }
    private Calendar datePars (String str){
        String[] date = str.split("\\.");
        Calendar cal = new GregorianCalendar();
        cal.set(Integer.parseInt(20+date[2]), Integer.parseInt(date[1])-1,Integer.parseInt(date[0]));
        return cal;
    }
}
