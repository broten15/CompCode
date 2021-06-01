import java.util.HashMap;
import java.util.HashSet;

public class Google3 {
    public static void main(String[] args) {
        int[] l = {1, 2, 3, 4, 5, 6};
        System.out.println(Solution(l));
    }

    private static int Solution(int[] l) {
        if (l.length < 3) {
            return 0;
        }
        int result = 0;
        
        for (int j = 0; j < l.length; j++) {
            int numi = 0;
            for (int i = 0; i < j; i++) {
                if (l[j] % l[i] == 0) {
                    numi++;
                }
            }
            int numk = 0;
            for (int k = j + 1; k < l.length; k++) {
                if (l[k] % l[j] == 0) {
                    numk++;
                }
            }
            result += numk * numi;
        }
        return result;
    }
}
