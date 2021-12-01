import java.util.*;

public class basic {

// infix conversion to post and pre fix
    public static void main(String [] args) {
        Scanner s= new Scanner(System.in);
        //infix string
        String str=s.nextLine();
        Stack<String>prefix=new Stack<>();
        Stack<String>postfix=new Stack<>();
        Stack<Character> opt=new Stack<>();
        System.out.println("hello");
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('){
                                  opt.push(ch);     }
            else if ((ch>='0'&& ch<='9')||
                    (ch>='A'&& ch<='Z')||
                    (ch>='a'&& ch<='z')){
                                  prefix.push(ch+"");
                                  postfix.push(ch+"");
             System.out.println("hello");}
            else if(ch==')'){
                               while(opt.peek()!='('){
                                process(prefix,postfix,opt);}
                               System.out.println("hello");
                                     opt.pop();}
            else if(ch=='+'|| ch=='-'||ch=='*'|| ch=='/') {
                                while (opt.peek() != '(' && opt.size() > '0' && precedence(ch) <= precedence(opt.peek())) {
                                    process(prefix, postfix, opt);

                                   }
           opt.push(ch);
               }}
             // poping up the remaining part
                                while(opt.size()>0){
                                 process(prefix,postfix,opt);
                                }
               //printing the string
                System.out.println(prefix.pop());
                  System.out.println(postfix.pop());
               }

         //precedence function
         public static int precedence(char ch){
            if(ch=='+'|| ch=='-'){
                return 1;        }
            else if( ch=='*'|| ch=='/'){
                return 2;
                                       }
             else{
                 return 0 ;             }}
            //process function
        public static void process(Stack<String> pre,Stack<String> post,Stack<Character> opt){

            char op= opt.pop();
            String   pre2=pre.pop();
            String   pre1=pre.pop();
            String preresult= pre1+pre2+op;
            pre.push(preresult);
            String   post2=post.pop();
            String   post1=post.pop();
            String postresult=op+post1+post2;
            post.push(postresult);}
        }






























