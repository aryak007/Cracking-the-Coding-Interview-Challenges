import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long countInversions(int arr[]) {
        return mergeSort(arr,0,arr.length-1);
    }

    static long mergeSort(int arr[],int low,int high){
        int mid;
        long iCount = 0;
        if(low<high){
            mid = (low+high)/2;
            iCount = mergeSort(arr,low,mid);
            iCount+= mergeSort(arr,mid+1,high);
            iCount+= merge(arr,low,mid+1,high);
        }
        return iCount;
    }

    static long merge(int arr[],int low,int mid,int high){
        long iCount = 0;
        int n1 = mid-low+1;
        int n2 = high - mid;
        int i,j;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(i = 0;i<n1;i++)
            L[i] = arr[low+i];

        for(j = 0;j<n2;j++)
            R[j] = arr[mid+j+1];

        i = 0;
        j = 0;
        int k  = low;

        while(i<n1 && j<n2){
            if(L[i]<=R[j])
            {
                iCount++;
                arr[k] = L[i];
                i++;
            }
            else
            {
                iCount++;
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j<n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
        return iCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}
