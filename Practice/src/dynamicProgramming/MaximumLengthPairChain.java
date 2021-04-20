package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/*
 * leetcode - 646
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */
public class MaximumLengthPairChain {
	//DP solution - O(M*N)
    public int findLongestChainDP(int[][] pairs) {
        int m = pairs.length;
        
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int max = 1;
        int[] len = new int[m];
        Arrays.fill(len,1);
        for(int i=1;i<m;i++){
            int j = 0;
            while(j < i){
                if(len[j] + 1 > len[i] && pairs[i][0] > pairs[j][1]){
                	len[i] = len[j]+1;
                    if(max < len[i]) max = len[i];
                }
                j++;
            }
        }
        return max;
    }
    // O(N) N:length of pairs
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		int curr = Integer.MIN_VALUE;
		int ans = 0;
		for (int[] pair : pairs) {
			if (curr < pair[0]) {
				curr = pair[1];
				ans++;
			}
		}
        return ans;
    }
}
