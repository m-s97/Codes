package dynamicProgramming;
/*
 * Given a 2D matrix M of dimensions RxC. Find the maximum sum subarray in it.
 * 
 * https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1
 */
public class MaximumSumRectangle {
	// DP solution - O(c*c*r)
    int maximumSumRectangle(int r, int c, int m[][]) {
        int maxSum = Integer.MIN_VALUE;
        int i = 0,j = 0;
        //int strtCol = 0;
        //int endCol = 0;
        //int strtRow = 0;
        //int endRow = 0;
        int storeKadaneRowResult[] = new int[r];
        while(i < c){
            while(j < c){
                if(i == j){
                    for(int k=0;k<r;k++){
                        storeKadaneRowResult[k] = m[k][i];
                    }
                }
                else{
                    for(int k=0;k<r;k++){
                        storeKadaneRowResult[k] += m[k][j];
                    }
                }
                // check for MaxSUM here
                int local=storeKadaneRowResult[0],global=storeKadaneRowResult[0];
                for(int k=1;k<r;k++){
                    local = Math.max(storeKadaneRowResult[k],storeKadaneRowResult[k]+local);
                    global = Math.max(global,local);
                }                
                if(global > maxSum){
                    maxSum = global;
                    //strtCol = i;endCol = j; strtRow = strt of kadane sum ; endRow = similarly end of kadane sum
                }
                j++;
            }
            i++;
            j = i;
        }
        return maxSum;
    }
}
