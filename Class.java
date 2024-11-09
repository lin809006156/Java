package Inheritance;

public class Class {
    public String name;
    private int age;

    public Class() {
    }

    public void BeingAsked(String name, int age) {
        System.out.println("Hello");
        System.out.println(name +" "+ age);
    }

    private void SB() {
        System.out.println("Bye");
    }
}
