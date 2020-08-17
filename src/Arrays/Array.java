package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Array
{
    static void insertAtPosition(int[] arr,int elem,int pos){
        int totalSize = arr.length;
        if(pos>=totalSize) return;
        for(int k=totalSize-2;k>=pos;k--){
            arr[k+1]=arr[k];
        }
        arr[pos]=elem;
    }
    
    static void deleteAtPosition(int[] arr,int pos){
        int totalSize = arr.length;
        for(int k=pos;k<=totalSize-2;k++){
            arr[k]=arr[k+1];
        }
        arr[totalSize-1]=0;
    }
    
    static void printArray(int[] arr){
        System.out.print("[ ");
        for(int elem: arr){
            System.out.print(elem+" ");
        }
        System.out.println("]");
    }
    public static void main(String[] args)
    {
        int[] arr = new int[]{1,2,3,4,5,0,0,0};
        printArray(arr);
        insertAtPosition(arr,55,0);
        printArray(arr);
        deleteAtPosition(arr,0);
        printArray(arr);
        
    }
}
