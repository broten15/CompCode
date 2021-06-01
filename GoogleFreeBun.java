public class GoogleFreeBun {
    public static void main(String[] args) {
        
        System.out.println(Solution());
    }

    private static int[][] Solution(int num_buns, int num_required) {


        // We have all the keys to distribute, now how do we 
        // distribute them to eac list

        int distKeys = choose(num_buns, num_required - 1);
        int numCopy = num_buns - (num_required - 1);
        int[][] result = new int[num_buns][(distKeys * numCopy) / num_buns];

        int[][] indexCombos = new int[choose(num_buns, numCopy)][numCopy];
        getIndexCombos(indexCombos, num_buns, numCopy, 0);
        
    }
    
    private static int choose(int n, int r) {
        int numerator = factorial(n);
        int denominator = factorial(r) * factorial(n - r);
        return numerator / denominator;
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private static void getIndexCombos(int[][] a, int n, int r, int i) {
        for (; i < n; i++) {
            
        }
    }
}