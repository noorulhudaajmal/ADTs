package Stack;

import Stack.ModifiedStack.ArrayBoundedStack2;
import Stack.ModifiedStack.LinkedStack2;
import Stack.SafeStack.SafeArrayListStack;
import Stack.SafeStack.SafeLinkedStack;
import Stack.SafeStack.SafeStackInterface;

public class Demo {

    public static void main(String[] args) {
        System.out.println("ArrayBoundedStack Test:");
        arrayBoundedStackTest();
        System.out.println("LinkedStack Test:");
        linkedStackTest();
        System.out.println("SafeStack Test:");
        safeStackTest();
    }

    private static void safeStackTest(){
        SafeStackInterface<String> a = new SafeLinkedStack<String>();
        SafeStackInterface<String> b = new SafeArrayListStack<String>();

        System.out.println("a.size = "+a.size());
        System.out.println("b.size = "+b.size());

        boolean push_a = a.safePush("Apple");
        boolean push_b = b.safePush("Apple");

        System.out.println("Apple pushed to a : "+push_a);
        System.out.println("Apple pushed to b : "+push_b);

        System.out.println("a = \n"+a);
        System.out.println("b = \n"+b);

        System.out.println("a.size = "+a.size());
        System.out.println("b.size = "+b.size());

        push_a = a.safePush("Orange");
        push_b = b.safePush("Orange");

        System.out.println("Orange pushed to a : "+push_a);
        System.out.println("Orange pushed to b : "+push_b);

        System.out.println("a = "+a.toString());
        System.out.println("b = "+b.toString());

        System.out.println("a.size = "+a.size());
        System.out.println("b.size = "+b.size());

        String top_a = a.safeTop();
        String top_b = b.safeTop();

        System.out.println("a.safeTop = "+ top_a);
        System.out.println("b.safeTop = "+ top_b);

        System.out.println("clearing stacks.....");
        while (a.safePop())
            ;

        while (b.safePop())
            ;

        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }

    private static void arrayBoundedStackTest() {

        ArrayBoundedStack2<String> a = new ArrayBoundedStack2<>(2);

        System.out.println(" - push Orange");
        a.push("Orange");
        System.out.println(a.toSting());

        System.out.println(" - push Apple");
        a.push("Apple");
        System.out.println(a.toSting());


        System.out.println(" - push Guava");
        try {
            a.push("Guava");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a.toSting());

        System.out.println(" - swapStart()");

        System.out.println(a.toSting());

        System.out.println(" - popSome(3)");
        try {
            a.popSome(3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a.toSting());

        System.out.println(" - popSome(2)");
        a.popSome(2);
        System.out.println(a.toSting());

        System.out.println("- poptop()");
        try {
            a.poptop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a.toSting());

        System.out.println(" - push Guava");
        a.push("Guava");
        System.out.println(a.toSting());

        System.out.println(" - poptop()");
        a.poptop();
        System.out.println(a.toSting());

        System.out.println(" - swapStart()");
        System.out.println(a.toSting());

    }

    private static void linkedStackTest() {

        LinkedStack2<String> a = new LinkedStack2<>();

        System.out.println(" - push Orange");
        a.push("Orange");
        System.out.println(a.toSting());

        System.out.println(" - push Apple");
        a.push("Apple");
        System.out.println(a.toSting());

        System.out.println(" - push Guava");
        a.push("Guava");
        System.out.println(a.toSting());

        System.out.println(" - swapStart()");
        System.out.println(a.toSting());

        System.out.println(" - popSome(2)");
        a.popSome(2);
        System.out.println(a.toSting());

        System.out.println(" - popSome(2)");
        try {
            a.popSome(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a.toSting());

        System.out.println(" - poptop()");
        a.poptop();
        System.out.println(a.toSting());

        System.out.println(" - poptop()");
        try {
            a.poptop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a.toSting());

        System.out.println(" - push Guava");
        a.push("Guava");
        System.out.println(a.toSting());

        System.out.println(" - swapStart()");
        System.out.println(a.toSting());
    }

}
