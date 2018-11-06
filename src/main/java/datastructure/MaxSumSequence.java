package datastructure;

public class MaxSumSequence {
    public static void main(String[] args) {
        int[] A = {10,-1,-1,26,-30,2,0,5,15,100,-2,1};
        int res = maxSubseqSum(A,5);
        System.out.println(res);

    }

    public static int maxSubseqSum(int A[], int N) {
        int thisSum = 0;
        int maxSum = 0;
        int i;
        for (i = 0; i < N; i++) {
            thisSum += A[i];
            if (thisSum > maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }
        return maxSum;
    }
}
