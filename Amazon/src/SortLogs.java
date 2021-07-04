import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortLogs {

    static class COM implements Comparator<String> {
        public int compare(String a, String b) {
            String c1 = a.substring(a.indexOf(' ') + 1);
            String c2 = b.substring(b.indexOf(' ') + 1);
            String a_id = a.substring(0, a.indexOf(' '));
            String b_id = b.substring(0, b.indexOf(' '));
            if (Character.isDigit(c1.charAt(0)) && Character.isDigit(c2.charAt(0))) {
                return 0;
            }
            if (Character.isLetter(c1.charAt(0)) && Character.isLetter(c2.charAt(0))) {
                if (c1.compareTo(c2) == 0) {
                    return a_id.compareTo(b_id);
                }
                return c1.compareTo(c2);
            }

            if (Character.isLetter(c1.charAt(0))) return -1;
            return 1;
        }


        public static void sortBoxes(List<String> boxList) {

            Collections.sort(boxList, new COM());
            System.out.println(boxList);
        }
        public static void main(String[] args) {
            List<String> boxList = Arrays.asList(
                    "a8 fhc mig zqv anc",
                    "m8 fhc mig zqv"
            );
            sortBoxes(boxList);
        }
    }
}