package aprilLeetCode;

import java.util.HashMap;

/*
 * https://leetcode.com/explore/challenge/card/
 * april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3694/
 * 
 * You are given an array of binary strings strs and two integers m and n.
 * Return the size of the largest subset of strs such that there are at most 
 * m 0's and n 1's in the subset.
 */
public class Day2 {
	// Memoization solution based on knapsack problem
    class oneZero{
        int cntO;
        int cntZ;
        oneZero(){    
        }
        oneZero(int z,int o){
            this.cntO = o;
            this.cntZ = z;
        }
    }
    public int findMaxForm(String[] strs, int m, int n) {
        oneZero[] count = new oneZero[strs.length];
        for(int i=0;i<strs.length;i++){
            int z = 0,o=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j) == '0') z++;
                else o++;
            }
            oneZero obj = new oneZero(z,o);
            count[i] = obj;
        }
        return solveMemUtil(count,m,n,0,new HashMap<>()); 
    }
    int solveMemUtil(oneZero count[], int m,int n,int val,HashMap<String,Integer> map) {
        
        if(m<=0 && n <=0 || val >= count.length) return 0;
        
        StringBuilder sb = new StringBuilder();
        String key = sb.append(m).append(',').append(n).append(',').append(val).toString();
        
        if(map.containsKey(key))
            return map.get(key);
        int res = 0;
        if(count[val].cntZ > m || count[val].cntO > n)
            res =  solveMemUtil(count,m,n,val+1,map); 
        else 
            res =  Math.max(solveMemUtil(count,m,n,val+1,map),
                            1 + solveMemUtil(count,m-count[val].cntZ,n-count[val].cntO,val+1,map));
        map.put(key,res); 
        
        return res;
    }
    /* dp solution
     
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        oneZero[] count = new oneZero[size];
        for(int i=0;i<size;i++){
            int z = 0,o=0;
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j) == '0') z++;
                else o++;
            }
            oneZero obj = new oneZero(z,o);
            count[i] = obj;
        }
        int[][] dp = new int[m+1][n+1];
        for(int k=0;k<size;k++){
            int z = count[k].cntZ,o = count[k].cntO;
            for(int i=m;i>=z;i--){
                for(int j=n;j>=o;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i-z][j-o]+1);
                }
            }
        }
        return dp[m][n];
    }
     
     */
}
