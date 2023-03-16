package JavaHW2;
import java.util.logging.*;
import java.io.IOException;
import java.util.Arrays;
import java.io.InputStream;

/**
 * Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации запишите в лог-файл.
 */
public class Ex1 {
    private static Logger log = Logger.getLogger(Ex1.class.getName());
    
    public static void logInfo() throws IOException {
        InputStream configFile = Ex1.class.getResourceAsStream("logging.properties");
        LogManager.getLogManager().readConfiguration(configFile);
        FileHandler fh = new FileHandler("JavaHW2/log.xml", true);

        log.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        
    }

    private static int[] BubbleSort(int[] array) throws IOException {
        logInfo();
        //log.info(Arrays.toString(array));  //Запись в лог исходного массива
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    Swap(array, j, j + 1);
                }

                log.info(Arrays.toString(array));
            }

        }
        return array;

    }

    private static int[] Swap(int[] array, int leftPos, int rightPos) {
        int temp = array[leftPos];
        array[leftPos] = array[rightPos];
        array[rightPos] = temp;
        return array;
    }


    public static void main(String[] args) throws IOException {
        int[] array = new int[] { 31, 23, 6, 12, 15, 22, 5, 51, 2, 34 };
        int [] resultArr = new int[array.length];
        resultArr = BubbleSort(array);
        System.out.println(Arrays.toString(resultArr));
    }
}