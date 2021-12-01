import java.util.*;

public class javabasics {
    public  static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int b = s.nextInt();
        System.out.println("Base of input =" + b);
        // take number  from the user
        int n1 = s.nextInt();
        System.out.print("Number1 =" + n1);
        // take input base
        int n2 = s.nextInt();
        System.out.println("Number2 =" + n2);

        // get sum
         int val=getsum(n2, n1,b);
         System.out.println("NEW NUMBER="+ val);

    }
    public static int getsum(int n2,int n1,int b){
        int p=1;
        int rv=0;
        int c=0;
        while(n1>0 || n2>0 || c>0){
           int d2= n1%10;
            n2 = n2/10;
           int d1= n2%10;
            n1 = n1/10;
            int d=0;
           d2 = d2+c;
           if(d2>=d1){
               c=0;
               d=d2-d1;
           }else{
               c=1;
               d=d2+b-d1;
           }

           rv+=d*p;
           p=p*10;

        }
        return rv;
    }
}












