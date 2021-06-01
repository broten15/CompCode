import java.util.ArrayList;
import java.util.Collections;

public class Google2 {
    public static void main(String[] args) {
        int[] xs = {-2, -3, 4, -5};
        // System.out.println(multiply("3", "-4"));
        System.out.println(solution(xs));
    }

    public static String solution(int[] xs) {
        // make a list of the negative numbers and 
        // a list of the positive numbers
        if (xs.length == 1) {
            return Integer.toString(xs[0]);
        } else if (xs.length == 0) {
            return "1";
        }
        String product = "1";
        ArrayList<Integer> negatives = new ArrayList<>();
        boolean hasPositive = false;
        boolean hasZero = false;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > 0) {
                hasPositive = true;
                product = strMult(product, Integer.toString(xs[i]));
            } else if (xs[i] < 0) {
                negatives.add(xs[i]);
                Collections.sort(negatives);
            } else if (xs[i] == 0) {
                hasZero = true;
            } 
            
        }
        // deal with cases of no positive numbers
        if (negatives.size() < 2) {
            if (hasPositive) {
                return product;
            } else if (hasZero) {
                return "0";
            } else {
                return Integer.toString(negatives.get(0));
            }
        }
        
        // add as many negatives of possible
        int stop = negatives.size() % 2 == 0 ? negatives.size() : negatives.size() - 1;
        for (int i = 0; i < stop; i++) {
            product = strMult(product, Integer.toString(negatives.get(i)));
        }
        return product;
    }
    
    private static String strMult(String num1, String num2) {
        boolean neg = false;
        int start1 = 0;
        int start2 = 0;
        if (num1.charAt(0) == '-') {
            neg = true;
            start1 = 1;
            // num1 = num1.substring(1, num1.length());
        }
        if (num2.charAt(0) == '-') {
            neg = neg ? false : true;
            start2 = 1;
            // num2 = num2.substring(1, num2.length());
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0) {
            return "0";
        }
        
        int[] result = new int[len1 + len2];
        
        int i_n1 = 0;
        int i_n2 = 0;
        
        for (int i = len1 - 1; i >= start1; i--) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';
            
            i_n2 = 0;
            
            for (int j = len2 - 1; j >= start2; j--) {
                int n2 = num2.charAt(j) - '0';
                
                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;
                
                carry = sum / 10;
                
                result[i_n1 + i_n2] = sum % 10;
                
                i_n2++;
            }
            
            if (carry >0) {
                result[i_n1 + i_n2] += carry;
            }
            i_n1++;
        }
            
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) {
            i--;
        }
        
        if (i == - 1) {
            return "0";
        }
        
        StringBuilder s = new StringBuilder();
        if (neg) {
            s.append('-');
        } 
        
        while (i >= 0) {
            s.append(result[i--]);
        }
        return s.toString();
    }
}

//     public static String solution(int[] xs) {
//         // make a list of the negative numbers and 
//         // a list of the positive numbers
//         if (xs.length == 1) {
//             return Integer.toString(xs[0]);
//         }
//         String product = "1";
//         ArrayList<Integer> negatives = new ArrayList<>();
//         boolean hasPositive = false;
//         boolean hasZero = false;
//         for (int i = 0; i < xs.length; i++) {
//             if (xs[i] > 0) {
//                 hasPositive = true;
//                 product = multiply(product, Integer.toString(xs[i]));
//             } else if (xs[i] < 0) {
//                 negatives.add(xs[i]);
//                 Collections.sort(negatives);
//             } else if (xs[i] == 0) {
//                 hasZero = true;
//             } 
            
//         }
//         // deal with cases of no positive numbers
//         if (negatives.size() < 2) {
//             if (hasPositive) {
//                 return product;
//             } else if (hasZero) {
//                 return "0";
//             } else {
//                 return Integer.toString(negatives.get(0));
//             }
//         }
        
//         // add as many negatives of possible
//         int stop = negatives.size() % 2 == 0 ? negatives.size() : negatives.size() - 1;
//         for (int i = 0; i < stop; i++) {
//             product = multiply(product, Integer.toString(negatives.get(i)));
//         }
//         return product;
//     }

//     // Multiplies str1 and str2, and prints result.
// public static String multiply(String num1, String num2)
// {
//     boolean neg = false;
//     if (num1.charAt(0) == '-') {
//         neg = true;
//         num1 = num1.substring(1, num1.length());
//     }
//     if (num2.charAt(0) == '-') {
//         neg = neg ? false : true;
//         num2 = num2.substring(1, num2.length());
//     }
//     int len1 = num1.length();
//     int len2 = num2.length();
//     if (len1 == 0 || len2 == 0)
//         return "0";
 
//     // will keep the result number in vector
//     // in reverse order
//     int result[] = new int[len1 + len2];
 
//     // Below two indexes are used to
//     // find positions in result.
//     int i_n1 = 0;
//     int i_n2 = 0;
     
//     // Go from right to left in num1
//     for (int i = len1 - 1; i >= 0; i--)
//     {
//         int carry = 0;
//         int n1 = num1.charAt(i) - '0';
 
//         // To shift position to left after every
//         // multipliccharAtion of a digit in num2
//         i_n2 = 0;
         
//         // Go from right to left in num2            
//         for (int j = len2 - 1; j >= 0; j--)
//         {
//             // Take current digit of second number
//             int n2 = num2.charAt(j) - '0';
 
//             // Multiply with current digit of first number
//             // and add result to previously stored result
//             // charAt current position.
//             int sum = n1 * n2 + result[i_n1 + i_n2] + carry;
 
//             // Carry for next itercharAtion
//             carry = sum / 10;
 
//             // Store result
//             result[i_n1 + i_n2] = sum % 10;
 
//             i_n2++;
//         }
 
//         // store carry in next cell
//         if (carry > 0)
//             result[i_n1 + i_n2] += carry;
 
//         // To shift position to left after every
//         // multipliccharAtion of a digit in num1.
//         i_n1++;
//     }
 
//     // ignore '0's from the right
//     int i = result.length - 1;
//     while (i >= 0 && result[i] == 0){
//         i--;
//     }
 
//     // If all were '0's - means either both
//     // or one of num1 or num2 were '0'
//     if (i == -1)
//     return "0";
 
//     // genercharAte the result String
//     String s;
//     if (neg) {
//         s = "-";
//     } else {
//         s = "";
//     }
     
//     while (i >= 0)
//         s += result[i--];
 
//     return s;
// }
// }



