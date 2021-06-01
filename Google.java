import java.util.Arrays;

public class Google {
    public static void main(String[] args) {
        // int[] pass = {3, 1};
        // System.out.println("ANS: " + Fun(pass));
        // int a[] = {3, 1 , 4};
        // permute(a, a.length, a.length);

        // int[] max = new int[1];
        int l[] = {3,1,4,1};
        System.out.println(solution(l));
        
        // for (int i = l.length; i > 0; i--) {
        //     int temp[] =new int[i];
        //     // Print all combination using temprary lay 'temp[]'
        //     combinationRec(l, temp, 0, l.length-1, 0, i, max);
        //     if (max[0] != 0) {
        //         // System.out.println(Arrays.toString(l));
        //         // System.out.println(max[0]);
        //         return;
        //     }
        // }
        // System.out.println(max[0]);
    }

//     private static void combinationRec(int l[], int temp[], int start,
//     int end, int index, int length, int[] max)  {
//         // Current combination is ready to be printed, print it
//         if (index == length) {
//             // at here temp is a combination
//             int[] copy = Arrays.copyOf(temp, temp.length);
//             permute(copy, copy.length, copy.length, max);
//             return;
//         }

//         for (int i=start; i<=end && end-i+1 >= length-index; i++) {
//             temp[index] = l[i];
//             combinationRec(l, temp, i+1, end, index+1, length, max);
//         }
//     }
// //-------------------------------------------------------------
//     // Generating permutation using Heap Algorithm
//     public static void permute(int l[], int size, int n, int[] max)
//     {
//         // if size becomes 1 then prints the obtained
//         // permutation
//         if (size == 1) {
//             // at here this is the lay we need to check
//             int num = 0;
//             for (int i = n - 1; i > 0; i--) {
//                 num += l[i] * (int) (Math.pow(10,i));
//             }
//             num += l[0];
//             max[0] = setMax(max[0], num);
//             // System.out.println(num);
//         }
 
//         for (int i = 0; i < size; i++) {
//             permute(l, size - 1, n, max);
 
//             // if size is odd, swap 0th i.e (first) and
//             // (size-1)th i.e (last) element
//             if (size % 2 == 1) {
//                 int temp = l[0];
//                 l[0] = l[size - 1];
//                 l[size - 1] = temp;
//             }
 
//             // If size is even, swap ith
//             // and (size-1)th i.e last element
//             else {
//                 int temp = l[i];
//                 l[i] = l[size - 1];
//                 l[size - 1] = temp;
//             }
//         }
//     }

//     private static int setMax(int max, int curr) {
//         if (curr % 3 == 0 && curr > max) {
//             return curr;
//         }
//         return max;
//     }
// }
// 0--------
public static int solution(int[] l) {
    int[] max = new int[1];
    for (int i = l.length; i > 0; i--) {
        int[] temp = new int[i];
        combinationRec(l, temp, 0, l.length - 1, 0, i, max);
        if (max[0] != 0) {
            return max[0];
        }
    }
    return max[0];
}

private static void combinationRec(int[] l, int[] temp, int start, int end, int index, 
                                                            int length, int[] max) {
    if (index == length) {
        int[] copy = Arrays.copyOf(temp, temp.length);
        permute(copy, copy.length, copy.length, max);
        return;
    }         
    for (int i = start; i <= end && end - i + 1 >= length - index; i++) {
        temp[index] = l[i];
        combinationRec(l, temp, i + 1, end, index + 1, length, max);
    }
}

private static void permute(int[] l, int size, int n, int[] max) {
    if (size == 1) {
        int num = 0;
        for (int i = n - 1; i > 0; i--) {
            num += l[i] * (int) (Math.pow(10, i));
        }
        num += l[0];
        max[0] = setMax(max[0], num);
    }
    
    for (int i = 0; i < size; i++) {
        permute(l, size - 1, n, max);
        
        if (size % 2 == 1) {
            int temp = l[0];
            l[0] = l[size - 1];
            l[size - 1] = temp;
        } else {
            int temp = l[i];
            l[i] = l[size - 1];
            l[size - 1] = temp;
        }
    }
}

private static int setMax(int max, int curr){
    if (curr % 3 == 0 && curr > max) {
        return curr;
    }
    return max;
}
}