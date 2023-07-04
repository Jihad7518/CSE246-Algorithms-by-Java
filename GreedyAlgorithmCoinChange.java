
package lab05;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GreedyAlgorithmCoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int sum;
        System.out.println("Enter Number of Coins: ");
        n = sc.nextInt();
        
        System.out.println("Enter Some Coins: ");
        
        PriorityQueue <Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for(int i = 0; i < n; i++){
            pq.add(sc.nextInt());
        }

        /*while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }*/
        System.out.println("Exchanged Currency: ");
        sum = sc.nextInt();
        
        int c;
        int num;
        while(sum>0 || !pq.isEmpty()){
            c = pq.poll();
            if(c <= sum){
                num = sum / c;
                sum = sum - c * num;
                System.out.println("Used Coin: "+c +" Required: " +num +" times");
            
            }
            
            if(pq.isEmpty()){
                break;
            }
        }
        
        
    }
    
}
