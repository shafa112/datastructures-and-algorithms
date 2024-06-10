package javabasics;

import java.util.Arrays;

public class Exp1 {

    public static void main(String[] args) {

        A1 z = new A1();
        System.out.println("object of A , z.toString() will be printed = " + z);
        A1 a = new B1();
        System.out.println(a instanceof B1); //true
        System.out.println(a instanceof C1); //false

        A1 a1 = new C1();
        System.out.println(a1 instanceof B1); //true

        B1 b1 = new B1();
        System.out.println("b1.x = "+b1.x); //0
        System.out.println("b1.name = "+b1.name);//null
        // b1.br is null hence toString method will return "null" | Here constructor initialized with default value as null
        System.out.println("b1.br[] = "+ Arrays.toString(b1.br));


        int ar[] = new int[9];
        System.out.println(Arrays.toString(ar)); // [0,..9 times]
        System.out.println("ar: = " + ar); // ar: = [I@75b84c92
        System.out.println("ar.length = "+ar.length); //9
        String name = "shahzad";
        System.out.println("name length = "+name.length()); //7
        boolean arbool[] = new boolean[8];
        System.out.println(Arrays.toString(arbool)); // [false,...8 times]
        Boolean arrBool[] = new Boolean[7];
        System.out.println(Arrays.toString(arrBool)); // [null,...7 times]


        boolean ar1[];
        // ar1 is null hence toString method will return "null" -- wrong ans(compile time error ar1 is not initialized)
        //System.out.println(Arrays.toString(ar1)); // "null"
        int x;
        // 0 -- wrong ans(compile time error x is not initialized)
        //System.out.println(x); // 0

        // checkArray will be called and int a[] = null will happen and null will be printed
        checkArray(null);

        int b2[] = null;
        //null will be printed
        System.out.println(b2);
        // checkArray will be called and int a[] = b2 will happen and null will be printed as b2 is null
        checkArray(b2);


    }

    public static void checkArray(int a[])
    {
        System.out.println(a);
    }
}

class A1{
    int x;
    String name;
}

class B1 extends A1{
    int h;
    String location;
    int br[];
}

class C1 extends B1{}
