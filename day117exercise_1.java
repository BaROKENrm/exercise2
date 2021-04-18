package day117;

import java.util.Scanner;

public class day117exercise_1 {

      public static void main(String args[]){
       Scanner scan = new Scanner(System.in);
       int n = scan.nextInt();
       String[] str1 = new String[n];
       String[] str2 = new String[n];
       for(int i = 0; i < n; i ++){
           String s1 = scan.next();
           String s2 = scan.next();
           str1[i] = s1;
           str2[i] = s2;
       }
       for(int i = 0; i < n; i ++){
           if(str1[i].length() % 2 == 1){
               if(str1[i].equals(str2[i])){
                   System.out.println("Yes");
               }
               else{
                   System.out.println("No");
               }
           }
           else{
               if(isSame(str1[i],str2[i])){
                   System.out.println("Yes");
               }
               else{
                   System.out.println("No");
               }
           }
       }
   }
   public static boolean isSame(String s1,String s2){
       if(s1.length() == 1){
           return s1.equals(s2);
       }
       int index = s1.length() / 2;
       String a1 = s1.substring(0,index);
       String a2 = s1.substring(index);
       String b1 = s2.substring(0,index);
       String b2 = s2.substring(index);
       if(a1.equals(b1) && a2.equals(b2)){
           return true;
       }
       if(a1.equals(b2) && a2.equals(b1)){
           return true;
       }
       return (isSame(a1,b1) && isSame(a2,b2)) || (isSame(a1,b2) && isSame(a2,b1));
   }


}
