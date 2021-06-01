public class Google4 {
    public static void main(String[] args) {
        String in = "4958230947562934857623495872346593847563405763108576913457346051738456931827562934857340965872456901384569130458764095873450812347509348570234985730249857459823405982347509234857324095834750983";
        // System.out.println(Solution(in));

        // StringBuilder s = new StringBuilder(in);
        // stringDecrement(s);
        // stringIncrement(s);
        // s = stringDivideHalf(s);
        // System.out.println(copy.toString());
        System.out.println(Solution(in));
    }

    private static int Solution(String x) {
        int result = 0;
        StringBuilder s = new StringBuilder(x);
        while (Character.getNumericValue(s.charAt(s.length() - 1)) != 1 ||
                s.length() != 1) {
            result++;
            
            int last2d = (s.length() == 1) ? Integer.parseInt("" + s.substring(s.length() - 1)) :
                                            Integer.parseInt("" + s.substring(s.length() - 2));
            // check if we need to perform an extra step
            if (last2d % 2 != 0) {
                if ((last2d == 3 && s.length() == 1) || last2d % 4 == 1) {
                    stringDecrement(s);
                } else {
                    stringIncrement(s);
                }
                result++;
            }
            s = stringDivideHalf(s);
        }
        return result;
    }

    private static void stringDecrement(StringBuilder s) {
        int i = s.length() - 1;
        while (i >= 0) {
            char curr = s.charAt(i);
            
            if (curr == '0') {
                s.setCharAt(i, '9');
            } else {
                s.setCharAt(i, (char) (curr - 1));
                i = -1; // stop loop
            }
            i--;
        }
        if (s.charAt(0) == '0') {
            s.deleteCharAt(0);
        }
    }
    
    private static void stringIncrement(StringBuilder s) {
        int i = s.length() - 1;
        while (i >= 0) {
            char curr = s.charAt(i);
            
            if (curr == '9') {
                s.setCharAt(i, '0');
            } else {
                s.setCharAt(i, (char) (curr + 1));
                i = -1; // stop loop
            }
            i--;
        }
        if (s.charAt(0) == '0') {
            s.insert(0, '1');
        }
    }
    
    private static StringBuilder stringDivideHalf(StringBuilder s) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int curr = Character.getNumericValue(s.charAt(i));
            int num = (carry * 10 + curr) / 2;
            
            if (i > 0 || (i == 0 && num != 0)) {
                result.append(num);
            }
            carry = curr % 2;
        }
        return result;
    }
}
