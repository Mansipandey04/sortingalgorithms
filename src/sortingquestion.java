import java.util.*;

public class sortingquestion {

    public static int findpivot(int[]arr){

        int lo=0;
        int hi=arr.length-1;

        while(lo<hi){
            int mid=(lo+hi)/2;
            if(arr[mid]<arr[hi]){
                hi=mid;
                System.out.println(arr[mid]);
            }else{
                lo=mid+1;
                System.out.println(arr[mid]);
            }}
            return arr[hi];
        }
    public static void  targetsumpair(int [] arr,int tar){
        Arrays.sort(arr);
        int l=0;
        int r=arr.length-1;
        while(l<r){
            if(arr[l]+arr[r]>tar){
                r--;
            }
            else if (arr[l]+arr[r]==tar){
                l++;
                r--;
                System.out.println(arr[l]+" "+arr[r]);
            }else if(arr[l]+arr[r]<tar){
                l++;
            }
        }
    }
    public static void sort01(int[] arr){
        int i=0;
        int j=0;
        while(i<arr.length){
            if(arr[i]==1){
                i++;
            }else{
                swap(arr,i,j);
                i++;
                j++;
            }
        }}
    public static void sort012(int[] arr){
        int i=0;
        int j=0;
        int k=arr.length-1;
        while(i<=k){
            if(arr[i]==1){
                i++;
            }else if(arr[i]==0){
                swap(arr,i,j);
                j++;
                i++;
            }else if(arr[i]==2){
                swap(arr,i,k);
                k--;

            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        System.out.println("swapping"+arr[i]+"and"+arr[j]);
        int temp= arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){
       // int[] arr= {30,40,50,10,20};
       // int tar=70;
        //targetsumpair(arr,tar);
        // sort the format
        int [] arr={1,1,2,1,0,2,1,0,2,0,0,1};
         sort012(arr);
        print(arr);


    }
}
