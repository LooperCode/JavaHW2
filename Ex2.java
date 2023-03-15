package JavaHW2;
/*Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет]. */


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.lang.StringBuilder;

public class Ex2 {

    public static String readFileString(String path, Charset encoding) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path), encoding);
       
        return String.join(System.lineSeparator(), lines);

    }

    public static String[] RepalceToArr(String lines) {
        

        lines = lines.replace(":", ",")
                     .replace(";", ",")
                     .replace('"', ' ')
                     .replace(" ", "");
        String[] resArr = new String[lines.length()];
        resArr = lines.split(",");   
        
        return resArr;
    }

    public static String ResultOut(String[] resArr) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < resArr.length; i++) {
            if (resArr[i].contains("фамилия")) {
                sb.append("Студент(-ка) ");
                sb.append(resArr[i + 1]);
                sb.append(" ");
            } else if (resArr[i].contains("оценка")) {
                sb.append("получил(-а) ");
                sb.append(resArr[i + 1]);
                sb.append(" ");
            } else if (resArr[i].contains("предмет")) {
                sb.append("по предмету ");
                sb.append(resArr[i + 1]);
                sb.append("\n");
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String path = "JavaHW2/insertStr.txt";
        String lines = readFileString(path, StandardCharsets.UTF_8);
        String[] result = RepalceToArr(lines);
        String resultStr = ResultOut(result);
        System.out.println(resultStr);
    }
}
