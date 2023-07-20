package org.example;

import java.util.ArrayList;
import java.util.List;

public class Arithmetics {

       public int  add(int a, int b){
           return a+b;

       }
       public int sub(int a, int b){
           return a-b;
       }
       public int mult(int a, int b){
           return a*b;
       }
       public int div(int a, int b){
           if(b==0){
               throw new ArithmeticException();
           }
           return a/b;
       }


       public List<Integer> printEven(List<Integer>number){
           return number.stream().filter((num)->num%2==0).toList();

       }
       public  List<Integer> printOdd(List<Integer>number){
           return number.stream().filter((num)->num%2!=0).toList();
       }
   //List<Integer> list=new ArrayList<Integer>();
      // list.add()



}
