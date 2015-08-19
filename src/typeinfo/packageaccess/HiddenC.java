//: typeinfo/packageaccess/HiddenC.java
package typeinfo.packageaccess;

import typeinfo.interfacea.A;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static net.mindview.util.Print.print;

class C implements A {
    public void f() {
        print("public C.f()");
    }

    public void g() {
        print("public C.g()");
    }

    void u() {
        print("package C.u()");
    }

    protected void v() {
        print("protected C.v()");
    }

    private void w() {
        print("private C.w()");
    }
}

public class HiddenC {
    public static A makeA() {
        return new C();
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        A a = makeA();
//        C c = (C) a;
//        c.g();
//        c.u();
//        c.v();
        Method m = a.getClass().getDeclaredMethod("u");
        Method m1 = a.getClass().getDeclaredMethod("w");
        m.setAccessible(true);
        m.invoke(a);
        m1.setAccessible(true);
        m1.invoke(a);


//        c.w();
    }
} ///:~
