package org.example;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Example{
    int age,roll;
    String name;

    static int f;

    // Default Constructure..
    Example(){
        this.age = 0;
        this.roll = 0;
        this.name = "##";
        System.out.println("Constructure invoked of Example class");
    }

    void display(){
        System.out.println("Name = "+name+" age = "+age+" and roll no = "+roll);
    }

    public void m(Example e){
        System.out.println("M method of Example class..");
        System.out.println("NAme = "+e.name);
    }

    // Parametrise Con..
    Example(int age,int roll,String name){
        this();      // invoked the cons. of class
        this.age = age;
        this.roll = roll;
        this.name = name;
        System.out.println("Parametrise Const.. invoked..");
        this.display();
        m(this);
    }
    public static void hello(){
        System.out.println("Static Method");

    }
static {
        int a = 10;
        final int b = 11;
        System.out.print("Hello static block");
}

}


abstract class A{
    public abstract void Hello();
    public static void Hello2(){
        System.out.println("Hello static");
    }
    final void fun1(){
        System.out.println("final method");
    }
    public A(){
        System.out.println(" i am in a");
    }
    public void fun(){
        System.out.println("Fun in a");
    }
}

class B extends A{

    @Override
    public void Hello() {
        System.out.println("I am hello");
    }
}

class box{
    int a;
    public void funOut(){
        System.out.println("In box class");
    }
    class box1{
        void fun(){
            System.out.println("i inner class");
        }
    }
}

class D extends A implements It{
    @Override
    public void Hello() {
     int a = 20;
    }

    public void fun(){
        System.out.println("i am D");
    }
}
interface I1{
    int a = 10;  // by default public final static
    void show(); // by default public abstarct
}
@FunctionalInterface
interface I2{
    public void show();

}
 enum Laptop{
    a(100),b(200),c(300);
   private int i;
   private Laptop(int i) {
         this.i = i;
     }
 }

@FunctionalInterface
interface I5{
    public void show();

}

class A1 implements Runnable{
    public void run(){
        for(int i=0;i<10;i++) System.out.println(i+":Hi ");
    }
}

class A2 extends Thread{
    public void run() {
        for(int i=0;i<10;i++) System.out.println(i+":Hello ");
    }
}

sealed class X1 permits X2,X3{

}
non-sealed class X2 extends X1{

}

final class X3 extends X1{

}

record Info(int id,String name) {}

//Serialization
class StudentInfo implements Serializable {
    private String name;
    private int age,roll;

    public StudentInfo(String name,int age, int roll) {
        this.age = age;
        this.name = name;
        this.roll = roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getRoll() {
        return roll;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", roll=" + roll +
                '}';
    }
}

public class Main {
    public static void printPattern(int n)
    {
        int i, j;
        // outer loop to handle number of rows
        for (i = 1; i <= n; i++) {
            // inner loop to print space
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // inner loop to print star
            for (j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            // print new line for each row
            System.out.println();
        }
    }

    void SwitchStatements(){
String name = "";
        // new switch statment after java 12 version
//    switch (name){
//        case "car" -> System.out.println("Car Price 2000");
//        case "dog" -> System.out.println("Dog price 100");
//        case "animal" -> System.out.println("Animal Price 201");
//        default -> System.out.println("nothing...");
//    }

        // return the data by switch
//    String x = switch (name){
//        case "car" -> "2000";
//        case "dog" -> "3000";
//        default -> "-1";
//    };

        // using yield
        String x = switch (name){
            case "car" : yield "2000";
            case "dog" : yield "3000";
            default : yield  "-1";
        };
        System.out.println(x);

    }

   public static void sortData(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(10);
        list.add(4);
        list.add(9);

        Comparator<Integer> comparator = ( a, b)->{
             if(a>b) return -1;
             else return 1;
        };

       Collections.sort(list,comparator);

        for(Integer i:list){
            System.out.println(i);
        }
    }

    static void streamApi(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//        list.forEach(n-> System.out.println(n+1));
        Stream<Integer> s1 = list.stream();
//        s1.forEach(n-> System.out.println(n));
//        Stream<Integer> s2 = s1.filter(n->n%2==1)
//                .map(n->n+1);
//        int i = s2.reduce(0,(a, b)->a+b);
//        System.out.println(i);
//        s2.forEach(n-> System.out.println(n));

        Predicate<Integer> p = (n)->{ // by lambda expression..
          return n%2==0;
        };

        Predicate<Integer> p1 = new Predicate<Integer>(){   // by anonymous class...
            @Override
            public boolean test(Integer integer) {
                return integer%2==1;
            }
        };

        Function<Integer,Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer+1;
            }
        };

        Function<Integer,Integer> function1 = (n)->{  // n -> n*2
            return n*2;
        };

        Stream<Integer> s4 = s1.filter(p1)
                .map(function1);
        s4.forEach(n-> System.out.println(n));
    }

    public static void main(String[] args) throws ClassNotFoundException{
//       D d = new D(){
//           public void fun(){
//               System.out.println("i am not d"); // Anonymous inner class
//           }
//       } ;
//       d.fun();
//       C1 c = new C1();
//        c.show();
//
//
//        Laptop e = Laptop.a;
//        for(Laptop i: Laptop.values()){
//            System.out.println(i);
//        }

//        I5 i = new I5(){
//            public void show(){
//                System.out.println("i am show");
//            }
//        };
//        I5 i = ()->
//                System.out.println("i am show"); //Lambda Expression..
//        i.show();

//
//       String a = "kartik";
//       String b = new String("kartik");
//       System.out.println(a.equals(b));
//       A1 a1 = new A1();
//       A2 a2 = new A2();
//       a1.run();
//       a2.start();
//       System.out.println(a2.getPriority());

//   sortData();
// streamApi();
// Info i = new Info(1,"kartik");
// Info j = new Info(2,"jasiwal");
//        System.out.println(i+" "+j);
//        System.out.println(i.equals(j));

//        serialization();
        deSerialization();

    }

    private static void deSerialization() {
        try {
            FileInputStream fileInputStream = new FileInputStream("Serial.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            StudentInfo studentInfo = (StudentInfo) objectInputStream.readObject();
            System.out.println(studentInfo);
            fileInputStream.close();
            objectInputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void serialization() {
        StudentInfo studentInfo = new StudentInfo("kartik lohate",21,84);
        System.out.println(studentInfo);
        try {
            FileOutputStream fileInputStream = new FileOutputStream("Serial.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
            objectOutputStream.writeObject(studentInfo);
            fileInputStream.close();
            objectOutputStream.close();
            System.out.println("Object is Serialized...");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}