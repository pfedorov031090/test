import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String path = "src/text";
        String outSort1 = "src/output1";
        String outSort2 = "src/output2";
        String outSort3 = "src/output3";
        String line = "";
        int input = 0;
        Scanner scn = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Collections.sort(list);
        write(list, outSort1);


        Comparator<String> byLength = (s1, s2) -> s1.length() - s2.length();
        list.sort(byLength);
        write(list, outSort2);

        System.out.println("Введите номер слова для сортировки: ");
        input = scn.nextInt();


    }
    class ListComparator implements Comparator<List<String>> {
        public int compare(List<String> o1, List<String> o2) {
            return o1.get(1).compareTo(o2.get(1));
        }
    }

    public static void write (ArrayList<String> list, String path) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            for (int i = 0; i < list.size(); i++) {
                printWriter.println(list.get(i));
                printWriter.flush();
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

