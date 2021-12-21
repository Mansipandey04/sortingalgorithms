import java.util.*;
public class mansi{
// utility functions //
    public static boolean issmaller(int[] arr,int i ,int j){
  System.out.println("comparing"+arr[i]+"and"+arr[j]);
     if(arr[i]<arr[j]){
      return true;}
     else{
         return false;
     }
  }
    public static void swap(int[] arr,int i,int j){
      System.out.println("swapping"+arr[i]+"and"+arr[j]);
      int temp= arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
  }
    public static boolean isgreater(int[] arr,int i,int j){
        if(arr[i]>arr[j]){
            return true;
        }else{
            return false;
        }
    }
    public static int[] mergetwosortedarrays(int[] arr1,int [] arr2 ){
        int [] res= new int[arr1.length+arr2.length];
        int i=0;int j=0;int k=0;
        while(i <arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                res[k]=arr1[i];
                i++;
                k++;
            }else{
                res[k]=arr2[j];
                j++;
                k++;
            }}
        while(i<arr1.length){
            res[k]=arr1[i];
            k++;
            i++;
        }
        while(j<arr2.length){
            res[k]=arr2[j];
            k++;
            j++;
        }

        return res;

    }
    public static int partioning(int[] arr,int p ,int lo,int hi){
        int i=lo;
        int j=lo;
        while(i<=hi){
            if(arr[i]>p){
                i++;
            }else{
                swap(arr,i,j);
                i++;
                j++;
            }

        }
        return (j-1);
        }

// here are sorting algorithms//
  public static void bubblesort(int[] arr){
      for(int i=1;i<arr.length-1;i++){
          for(int j=0;j<arr.length-i;j++){
              if(issmaller(arr,j,j+1)){
                  swap(arr,j,j+1);
              }
          }
      }
  }
  public static void selectionsort(int[] arr){
      for(int i=0;i<arr.length-1;i++){
          int m=arr[i];
          for(int j=i+1;j<arr.length;j++){
              if (issmaller(arr, m, j)) {
                  m=j;
              }
              swap(arr,m,i);
          }

      }
  }
  public static void insertionsort(int [] arr){
      for(int i=0;i<arr.length;i++){
          for(int j=i-1;j>=0;j--){
              if(isgreater(arr,j,j+1)){
                  swap(arr,j+1,j);
              }else{
                  break;
              }
          }
      }
  }
  public static int[]  mergesort(int[] arr,int lo,int hi){
      if(lo==hi){
          int [] ba= new int [1];
          ba[0]=arr[lo];
          return ba;
      }
      int m=(lo+hi)/2;
      int[] lsa=mergesort(arr,lo,m);
      int [] rsa=mergesort(arr,m+1,hi);
      int[] fsa=mergetwosortedarrays(lsa ,rsa);
      return fsa;

  }
  public static void  quicksort(int [] arr ,int lo,int hi) {
        if(lo>=hi){
            return;
        }

        int pivot=arr[hi];
        int pi=partioning(arr,pivot,lo,hi);
        System.out.println(pi);
        quicksort(arr,lo,pi-1);
        quicksort(arr,pi+1,hi);

  }
  public static int  quickselect(int[] arr ,int lo,int hi,int k){
        int pivot=arr[hi];
        int pi=partioning(arr,pivot,lo,hi);
            if(k>pi){
               return quickselect(arr,pi+1, hi, k);
            }
            else if(k<pi){
                return quickselect(arr,lo,pi-1,k);
            }else{
                return arr[pi];
            }

      }
  public static int[] countsort(int [] arr,int max,int min){
        int range=max-min+1;
        int [] farr= new int[range];
        for(int i=0;i<arr.length;i++){
            int idx=arr[i]-min;
            farr[idx]++;
        }
        // frequency sum arr
      for(int i=1;i<=farr.length-1;i++){
          farr[i]=farr[i-1]+farr[i];
      }
      int [] ans=new int[arr.length];
      // inserting values from the orignal arr to new ans array
      for(int i=arr.length-1;i>=0;i--) {
          int val = arr[i];
          int pos = farr[val - min];
          int idx = pos - 1;
          ans[idx] = val;
          farr[val - min]--;
      }
      for(int i=0;i<ans.length;i++) {
          arr[i] = ans[i];
      }
    return arr;}

      //utility functions//
  public static void print(int[] arr){
      for(int i=0;i<arr.length;i++){
          System.out.println(arr[i]);
      }
  }
  //code compilation //
  public static void main(String[] args){

      int [] arr={9,6,3,5,3,4,3,9,6,4,6,5,8,9,9};
   int[] res=  countsort(arr,9,3);
   print(arr);


  }
}

