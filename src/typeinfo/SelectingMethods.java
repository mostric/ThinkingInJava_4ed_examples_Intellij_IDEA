//: typeinfo/SelectingMethods.java
package typeinfo; /* Added by Eclipse.py */
// Looking for particular methods in a dynamic proxy.

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.mindview.util.Print.print;

interface SomeMethods {
    void boring1();

    void boring2();

    void interesting(String arg);

    void boring3();
}

interface SomeMethods2 {
    void bor1();

    void bor2();

    void interes(String argst);

    void bor3();
}

class MethodSelector implements InvocationHandler {
    private Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interesting"))
            print("Proxy detected the interesting method");
        return method.invoke(proxied, args);
    }
}

class Implementation implements SomeMethods {
    public void boring1() {
        print("boring1");
    }

    public void boring2() {
        print("boring2");
    }

    public void interesting(String arg) {
        print("interesting " + arg);
    }

    public void boring3() {
        print("boring3");
    }


}

class Implementation2 implements SomeMethods2 {
    public void bor1() {
        print("borg1");
    }

    public void bor2() {
        print("borsding2");
    }

    public void interes(String arg) {
        print("interestsdsding " + arg);
    }

    public void bor3() {
        print("borisdasdng3");
    }
}

class SelectingMethods {
    public static void main(String[] args) {
        SomeMethods2 proxy = (SomeMethods2) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class, SomeMethods2.class},
                new MethodSelector(new Implementation2()));
        proxy.bor1();
        proxy.bor2();
        proxy.interes("bonobo");
        proxy.bor3();

    }
} /* Output:
boring1
boring2
Proxy detected the interesting method
interesting bonobo
boring3
*///:~
