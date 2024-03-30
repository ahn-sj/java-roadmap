package lang.object;

public class Parent {
    public Parent() {
        System.out.println("Parent.Parent()");
    }

    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}

class Child extends Parent {
    public Child() {
        System.out.println("Child.Child()");
    }

    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}

