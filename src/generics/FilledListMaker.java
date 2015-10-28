//: generics/FilledListMaker.java
package generics; /* Added by Eclipse.py */

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {
    public static void main(String[] args) {
        FilledListMaker<String> stringMaker =
                new FilledListMaker<String>();
        List<String> list = stringMaker.create("Hello", 4);
        System.out.println(list);
    }

    List<T> create(T t, int n) {
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < n; i++)
            result.add(t);
        return result;
    }
} /* Output:
[Hello, Hello, Hello, Hello]
*///:~
