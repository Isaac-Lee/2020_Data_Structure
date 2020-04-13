package lab3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StampKey {
    static boolean isOk = false;
 
    static boolean solution(int[][] key, int[][] lock) {
    	 int len = lock.length;
         //3배 확장 후 중앙으로 옮기기
         int[][] copyLock = new int[len*3][len*3];
         for(int i=0; i<len; i++) {
             for(int j=0; j<len; j++) {
                 copyLock[i+len][j+len] = lock[i][j];
             }
         }
        dfs(key, copyLock, 0);
        return isOk;
    }
    static void dfs(int[][]key, int [][] lock, int cnt) {
        check(key, lock, 0, 0);
        if(isOk) return;
        if(cnt >= 4) return;
        int[][] temp = rotate(key);
        dfs(temp, lock, cnt+1);
    }
    
    static void check(int[][] key, int[][] lock, int x, int y) {
        if(isOk) return;
        
        if(y+key.length>lock.length) {
            y=0;
            x++;
        }
        if(x+key.length>lock.length) return;
 
        int[][] copyLock = new int[lock.length][lock.length];
        for(int i=0; i<lock.length; i++) {
            copyLock[i] = lock[i].clone();
        }
        
        boolean isFail = false;
        
        for (int i = 0; i < key.length; i++) { 
        	for (int j = 0; j < key.length; j++) {
        		copyLock[i+x][j+y] += key[i][j];
        	}
        }
        int value = 0;
        loop:
        for (int i = 0; i < lock.length/3; i++) { 
        	for (int j = 0; j < lock.length/3; j++) {
        		if (i ==0 && j ==0) {
        			value = copyLock[i+lock.length/3][j+lock.length/3];
        		} else {
        			if (value != copyLock[i+lock.length/3][j+lock.length/3]) {
        				isFail = true;
        				break loop;
        			} else {
            			value = copyLock[i+lock.length/3][j+lock.length/3];
        			}
        		}
        		
        	}
        }
        
        if(!isFail) {
            isOk = true;
        }
        check(key, lock, x, y+1);
    }
    
    static int[][] rotate(int [][] key) { //회전
        int len = key.length;
        int[][] temp = new int[len][len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                temp[i][j] = key[len-j-1][i];
            }
        }
        return temp;
    }
    
    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		int[][] key = new int[n][n];
		int[][] lock = new int[m][m];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(input.nextLine());
			for (int j = 0; j < n; j++) {
				key[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(input.nextLine());
			for (int j = 0; j < m; j++) {
				lock[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if (solution(key, lock)) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}
		input.close();
		
	}
}