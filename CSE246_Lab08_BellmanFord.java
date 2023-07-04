
package cse246_lab08_bellmanford;

import java.util.Scanner;

public class CSE246_Lab08_BellmanFord {

    public static void main(String[] args) {
        int w[][];
        int d[];
        int prev[];
        boolean flag = false;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of input: ");
        
        int n = sc.nextInt();
        w = new int[n][n];
        d = new int[n];
        prev = new int[n];
        
        System.out.println("Enter the weighted graph");
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                w[i][j] = sc.nextInt();
            }
        }
        
        for(int v = 0; v < n; v++){
            d[v] = 999;
            prev[v] = -1;
        }
        
        int s = 0;      // source node
        d[s] = 0;
        
        for(int i=0; i<n-1; i++){
            for(int u=0; u<n; u++){
                for(int v=0; v<n; v++){
                    if(d[v] > d[u] + w[u][v]){
                        d[v] = d[u] + w[u][v];
                    }
                }
            }
        }
        for(int u=0; u<n; u++){
            for(int v=0; v<n; v++){
                if(d[v] > d[u] + w[u][v]){
                    flag = true;
                }
            }
        }
        
        if(flag == true){
            System.out.println("Negative cycle exists");
        }
        else{
            System.out.println("Negative cycle does not exist");
        }
    }
    
}


/*
0      999   -2    999
4      0     -3    999
999    999   0     2
999    -1    999   0
*/