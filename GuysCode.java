public class GuysCode {
    public static void main(String[] args) {
        String in = "4958230947562934857623495872346593847563405763108576913457346051738456931827562934857340965872456901384569130458764095873450812347509348570234985730249857459823405982347509234857324095834750983";
        // System.out.println(Solution(in));

        // StringBuilder copy = new StringBuilder(in);
        // stringDecrement(copy);
        // stringIncrement(copy);
        // copy = stringDivideHalf(copy);
        // System.out.println(copy.toString());
        System.out.println(answer(in));
    }

    public static int answer(String n) { 

        // Your code goes here.
        int count = 0;
        while(!n.equals("1")){
            if((n.charAt(n.length() - 1) - '0') % 2 == 0){
                n = divideBy2(n);
            }else if(n.equals("3") || lastTwoBit(n)){
                n = subtractOne(n);
            }else{
                n = plusOne(n);
            }
            count++;
        }
        return count;
    } 
      private static boolean lastTwoBit(String num){
          int n = -1;
          if(num.length() == 1){
              n = Integer.valueOf(num);
          }else{
              n = Integer.valueOf(num.substring(num.length() - 2, num.length()));
          }
          if(((n >>> 1) & 1) == 0){
            return true;
          }
          return false;
      }
      private static String subtractOne(String num){
         if(num.equals("1")){
            return "0";
         }
         StringBuilder sb = new StringBuilder();
         int carry = -1;
         for(int i = num.length() - 1; i >= 0; i--){
             int d = carry + num.charAt(i) - '0';
             if(d < 0){
                 carry = -1;
                 sb.insert(0, '9');
             }else if((d == 0 && i != 0) || d > 0){
                 carry = 0;
                 sb.insert(0, d );
             }
         }
         return sb.toString();
     }
    private static String plusOne(String num){
        StringBuilder sb = new StringBuilder();
        int carry = 1;
        int i = 0;
        for(i = num.length() - 1; i >=0; i--){
            if(carry == 0){
                break;
            }
            int d = (carry + num.charAt(i) - '0') % 10;
            carry = (carry + num.charAt(i) - '0') / 10;
            sb.insert(0, d);
        }
        if(carry ==0){
            sb.insert(0, num.substring(0, i + 1));
        }
        if(carry == 1){
            sb.insert(0, carry);
        }
        return sb.toString();
    }
    private static String divideBy2(String num){
        StringBuilder sb = new StringBuilder();
        int x = 0;
        for(int i = 0; i < num.length(); i++){
            int d = (x * 10 + num.charAt(i) - '0') / 2 ;
            x = (num.charAt(i) - '0') % 2 ;
            if( i > 0 || (i == 0 && d != 0))
                sb.append(d);
        }

        return sb.toString();
    }
}

