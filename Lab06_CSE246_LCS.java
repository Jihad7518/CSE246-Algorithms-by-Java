
package lab06_cse246;

import java.util.Scanner;


public class Lab06_CSE246_LCS {


    public static void main(String[] args) {
        
        String x, y;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter two string x and y");
        
        x = sc.next();
        y = sc.next();
        
        int m = x.length()+1;
        int n = y.length()+1;
        
        System.out.println("String 1: "+x +"& String2: "+y);
        
        int c[][] = new int[m][n];
        int b[][] = new int[m][n];
        
        for(int j = 0; j < n; j++){
            c[0][j] = 0;
        }
        for(int i = 0; i < m; i++){
            c[i][0] = 0;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 2;
                }
                else{
                    if(c[i-1][j] > c[i][j-1]){
                        c[i][j] = c[i-1][j];
                        b[i][j] = 0;
                    }
                    else{
                        c[i][j] = c[i][j-1];
                        b[i][j] = 1;
                    }
                }
            }
        }
        
        System.out.println("LCS Length: "+c[m-1][n-1]);
        printLCS(b, x, x.length(), y.length());
    }
    
    static int printLCS(int b[][], String x, int i, int j){
        if(i==0 || j==0){
            return 0;
        }
        else if(b[i][j] == 2){
            printLCS(b, x, i-1, j-1);
            System.out.print(x.charAt(i-1));
        }
        else if(b[i][j] == 0){
            printLCS(b, x, i-1, j);
        }
        else{
            printLCS(b, x, i, j-1);
        }
        System.out.println();
        return 0;
    }
    
}
