package org.jay.java;

public class myClass {
    public  static  void main(String[] a){
        C1 c1=new C1();
        c1.f();
    }
    public static class A {
         void  f() {
             System.out.print("A");
         }
        void  a() {  }
    }

    interface B {
        void  f() ;
        void  b() ;
    }


    static class C1 extends A implements B{
        public String a;
        @Override
        public void f() {
            System.out.print("C1.f()");
        }


        @Override
        public void b() {

        }
    }
}
