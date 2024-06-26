package Inheritance;

public class Drived extends Simple_Inhe {

    public Drived() {
        System.out.println("I am Drived Class");
    }
    class A{
        A(){
            System.out.println("I am A..");
        }

    }
    class B extends A{
        B(){
            System.out.println("I am B");
        }
    }

    class C extends B{
        C(){
            System.out.println("I am C");
        }

    }

    class D extends A{
        D(){
            System.out.println("I am D..");
        }
    }

}
