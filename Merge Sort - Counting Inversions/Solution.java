import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long countInversions(int arr[]) {
        int temp[] = new int[arr.length];
        long iCount =  mergeSort(arr,temp, 0, arr.length - 1);
        return iCount;
    }

    static long mergeSort(int arr[], int temp[], int low, int high) {
        int mid;
        long iCount = 0;
        if (low < high) {
            mid = (low + high) / 2;
            iCount = mergeSort(arr, temp, low, mid);
            iCount += mergeSort(arr, temp, mid + 1, high);
            iCount += merge(arr, temp, low, mid + 1, high);
            //System.out.println(iCount);
        }
        return iCount;
    }

    static long merge(int arr[], int temp[], int low, int mid, int high) {
        long iCount = 0;
        int i,j,k;
        i = low; 
        j = mid;  
        k = low; 
        while ((i <= mid - 1) && (j <= high)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                iCount = iCount + (mid - i);
            }
        }

        while (i <= mid - 1)
            temp[k++] = arr[i++];

        while (j <= high)
            temp[k++] = arr[j++];

        for (i = low; i <= high; i++)
            arr[i] = temp[i];

        return iCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}
