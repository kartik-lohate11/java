package org.example;


interface It{
    static int x = 10;
    int a = -1;
}
public class TempCode {

    int a;
    public String name = "kartik loahte";
    TempCode(int a){
        this.a = a;
        System.out.println("a = "+a);
    }

        public void hello(){
        System.out.println("Hello Windows"+a);
    }
}

 class Tem2 extends TempCode implements It{

     int a = 10;
     final int k = 9;
     int [] arr = new int[]{1,2,3,4,5};
     Tem2(int a) {
         super(a);
         System.out.println("Tem2 Called");
         System.out.println("it = "+It.x);
         String i = "kartik",j = "kartik";
         String k = new String("kartik");
         System.out.println("i = "+(i==k));
     }

 }
