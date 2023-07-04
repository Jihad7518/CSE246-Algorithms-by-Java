
package lab06_cse246_knapsack;

import java.util.Scanner;

public class Lab06_CSE246_Knapsack {


    public static void main(String[] args) {
        
        int n;             // number of products
        int wi[];           // weight of each products
        int b[];          // benefit for each product
        int B[][];       // profit table
        int W;            // bag size
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number products: ");
        
        n = sc.nextInt();        // input number of products
        wi = new int[n+1];
        b = new int[n+1];
        
        System.out.println("Enter each product's weight: ");
        
        for(int i = 1; i <= n; i++){
            wi[i] = sc.nextInt();
        }
        
        System.out.println("Enter the profit of each value: ");
        
        for(int i = 1; i <= n; i++){
            b[i] = sc.nextInt();
        }
        
        System.out.println("Enter the size of the bag: ");
        W = sc.nextInt();
        
        B = new int[n+1][W+1];
        
        for(int w = 0; w <= W; w++){
            B[0][w] = 0;
        }
        
        for(int i=0; i<=n; i++){
            B[i][0] = 0;
        }
        
        for(int i = 1; i <= n; i++){
            for(int w =0; w <= W; w++){
                if(wi[i] <= w){
                    if(b[i] + B[i-1][w-wi[i]] > B[i-1][w]){
                        B[i][w] = b[i] + B[i-1][w-wi[i]];
                    }
                    else{
                        B[i][w] = B[i-1][w];
                    }
                }
                else{
                    B[i][w] = B[i-1][w];
                }
            }
        }
        
        System.out.println("Total Maximum Profit: "+B[n][W]);
        
    }
    
}
