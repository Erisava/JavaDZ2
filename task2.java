/*Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл */

package Java.DZ2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class task2 {
    private static File log;
    private static FileWriter fileWriter;

    public static void main(String[] args) {
        try {
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log);
            int[] sortArr = { 10, 5, 33, 41, -7, -12 };
            bubbleSort(sortArr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void bubbleSort(int[] sortArr){
        for (int i = 0; i < sortArr.length - 1; i++) {
            for(int j = 0; j < sortArr.length - i - 1; j++) {
                if(sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
            writeLog(Arrays.toString(sortArr));
        }
    }    

    public static void writeLog(String note) {
        
        try(FileWriter writer = new FileWriter("log.txt"))
        {
           fileWriter.write(note + "\n"); 
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
