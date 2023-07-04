
package dfs_stack_based;


import java.util.Scanner;
import java.util.Stack;


public class DFS_Stack_based {

    static int s[];
    static int color[];
    static int prev[];
    static int f[];
    static int adj[][];
    static int n;
    static int time;
    
    public static void main(String[] args) {
        System.out.println("Enter the number of node: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        adj = new int[n][n];
        s = new int[n];
        f = new int[n];
        prev = new int[n];
        color = new int[n];
        
        System.out.println("Enter the graph");
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                adj[i][j] = sc.nextInt();
            }
        }
        
        for(int i = 0; i < n; i++){
            color[i] = 0;
            prev[i] = -1;
        }
        
        for(int u=0; u<n; u++){
            if(color[u] == 0){
                dfsVisit(u);
            }
        }
        
    }
    
    static void dfsVisit(int u){
        Stack<Integer>st = new Stack<Integer>();
        st.push(u);
        
        while(!st.isEmpty()){
            int x = st.pop();
            if(color[x] == 0){
                time = time +1;
                s[x] = time;
                color[x] = 1;
                st.push(x);
                
                for(int v=0; v<n; v++){
                    if(adj[x][v] == 1 && color[v] == 0){
                        prev[v] = u;
                        st.push(v);
                    }
                }
            }
            
            else if(color[x] == 1){
                time = time +1;
                f[x] = time;
                color[x] = 2;
                System.out.println(x);
            }
        }
    }
    
}
