import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Solution S = new Solution();
        PriorityQueue<Integer> upperMinHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> lowerMaxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        	public int compare(Integer a,Integer b){
        		return -1*a.compareTo(b);
        	}
        });
        for(int i = 0;i<a.length;i++){
        	S.addNumberToHeaps(a[i],lowerMaxHeap,upperMinHeap);
        	S.rebalanceHeaps(lowerMaxHeap,upperMinHeap);
        	System.out.println(S.calculateMedian(lowerMaxHeap,upperMinHeap));
        }
    }

    void addNumberToHeaps(int n,PriorityQueue<Integer> lowerMaxHeap,PriorityQueue<Integer> upperMinHeap){
    	if(lowerMaxHeap.size()==0 || n<lowerMaxHeap.peek())
    		lowerMaxHeap.add(n);
    	else
    		upperMinHeap.add(n);
    }

    void rebalanceHeaps(PriorityQueue<Integer> lowerMaxHeap,PriorityQueue<Integer> upperMinHeap){
    	PriorityQueue<Integer> biggerHeap = lowerMaxHeap.size()>upperMinHeap.size()?lowerMaxHeap:upperMinHeap;
    	PriorityQueue<Integer> smallerHeap = lowerMaxHeap.size()<upperMinHeap.size()?lowerMaxHeap:upperMinHeap;

    	if(biggerHeap.size()-smallerHeap.size()>=2){
    		smallerHeap.add(biggerHeap.poll());
    	}
    }

    double calculateMedian(PriorityQueue<Integer> lowerMaxHeap,PriorityQueue<Integer> upperMinHeap){
		PriorityQueue<Integer> biggerHeap = lowerMaxHeap.size()>upperMinHeap.size()?lowerMaxHeap:upperMinHeap;
    	PriorityQueue<Integer> smallerHeap = lowerMaxHeap.size()<upperMinHeap.size()?lowerMaxHeap:upperMinHeap;

    	if(biggerHeap.size()==lowerMaxHeap.size())
    		return ((double)biggerHeap.peek()+lowerMaxHeap.peek())/2;
    	return (biggerHeap.peek());
    }


}
