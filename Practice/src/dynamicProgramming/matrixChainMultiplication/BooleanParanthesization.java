package dynamicProgramming.matrixChainMultiplication;
/*
 * https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
 */
public class BooleanParanthesization {
	// Recursive approach - O(2^n)
    static int solveRecur(int N, String S){
        return solveRecurUtil(0,N-1,S,true);
    }
	private static int solveRecurUtil(int i,int j, String s, boolean b) {
		if(j < i) return 0;
		if(i == j) {
			if(b) {
				if(s.charAt(i) == 'T') return 1;
				else return 0;
			}else {
				if(s.charAt(i) == 'F') return 1;
				else return 0;
			}
		}
		int ans = 0;
		for(int k = i+1;k<=j-1;k= k+2) {
			int lt = solveRecurUtil(i,k-1,s,true);
			int rt = solveRecurUtil(k+1,j,s,true);
			int lf = solveRecurUtil(i,k-1,s,false);
			int rf = solveRecurUtil(k+1,j,s,false);
			
			if(s.charAt(k) == '&') {
				if(b) {
					ans += (lt*rt);
				}else {
					ans += (lf*rt)+(lf*rf)+(rf*lt);
				}
			}
			else if(s.charAt(k) == '^') {
				if(!b) {
					ans += (lt*rt)+(lf*rf);
				}else {
					ans += (lf*rt)+(rf*lt);
				}
			}
			else if(s.charAt(k) == '|') {
				if(!b) {
					ans += (lf*rf);
				}else {
					ans += (lt*rt)+(lt*rf)+(lf*rt);
				}
			}			
 		}
		return ans;
	}
    /*
    static int countWays(int N, String S){
        HashMap<String,Integer> hm = new HashMap<>();
        return solveRecurUtil(0,N-1,S,true,hm);
    }
	static int solveRecurUtil(int i,int j, String s, boolean b,HashMap<String,Integer> hm) {
		if(j < i) return 0;
		
		String key = i+" "+j+" "+b;
		if(hm.containsKey(key)) return hm.get(key);
		
		if(i == j) {
			if(b) {
				if(s.charAt(i) == 'T') return 1;
				else return 0;
			}else {
				if(s.charAt(i) == 'F') return 1;
				else return 0;
			}
		}
		int ans = 0;
		for(int k = i+1;k<=j-1;k= k+2) {
		    String temp = i+" "+(k-1)+" "+"true";
			int lt = 0;
			if(hm.containsKey(temp)) lt = hm.get(temp);
			else {
			   lt = solveRecurUtil(i,k-1,s,true,hm);
			   hm.put(temp,lt);
			}
			temp = (k+1)+" "+j+" "+"true";
			int rt = 0;
			if(hm.containsKey(temp)) rt = hm.get(temp);
			else{
			    rt = solveRecurUtil(k+1,j,s,true,hm);
			    hm.put(temp,rt);
			}
			temp = i+" "+(k-1)+" "+"false";
			int lf = 0;
			if(hm.containsKey(temp)) lt = hm.get(temp);
			else{
			    lf = solveRecurUtil(i,k-1,s,false,hm);
			    hm.put(temp,lf);
			}
			temp = (k+1)+" "+(j)+" "+"false";
			int rf = 0;
			if(hm.containsKey(temp)) rf = hm.get(temp);
			else {
			    rf = solveRecurUtil(k+1,j,s,false,hm);
			    hm.put(temp,rf);
			}
			if(s.charAt(k) == '&') {
				if(b) {
					ans += (lt*rt);
				}else {
					ans += (lf*rt)+(lf*rf)+(rf*lt);
				}
			}
			else if(s.charAt(k) == '^') {
				if(!b) {
					ans += (lt*rt)+(lf*rf);
				}else {
					ans += (lf*rt)+(rf*lt);
				}
			}
			else if(s.charAt(k) == '|') {
				if(!b) {
					ans += (lf*rf);
				}else {
					ans += (lt*rt)+(lt*rf)+(lf*rt);
				}
			}			
 		}
 		ans = ans % 1003;
 		hm.put(key,ans);
		return ans;
	}
     */
}
