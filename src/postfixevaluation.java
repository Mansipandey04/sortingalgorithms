import java.util.*;

public class postfixevaluation {
    //postfix evaluation
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        //taking input of string
        String exp=s.nextLine();
        Stack<String> pv=new Stack<>();
        Stack<String> iv=new Stack<>();
        Stack<Integer> v=new Stack<>();
        //postfix evaluation
        for(int i=0;i<exp.length();i++){
            char ch=exp.charAt(i);
            if(ch=='+'|| ch=='-'|| ch=='*'|| ch=='/'){
                int v2=v.pop();
                int v1=v.pop();
                int val=operation(v1,v2,ch);
                v.push(val);
                String pv2=pv.pop();
                String pv1=pv.pop();
                String pval=v1+pv2+ch;
                pv.push(pval);
                String iv2=iv.pop();
                String iv1=iv.pop();
                String ival=iv1+ ch+iv2;
                iv.push(ival);


            }else{
                v.push(ch-'0');
                iv.push(ch+"");
                pv.push(ch+"");

            }

        }
        System.out.println(v.pop());
        System.out.println(iv.pop());
        System.out.println(pv.pop());
    }
    //operation functon
    public static int operation(int a,int b,char ch){
        if(ch=='+'){
            return a+b;
        }else if(ch=='-'){
            return a-b;
        }else if(ch=='*'){
            return a*b;
        }else{
            return a/b;
        }
    }
}
