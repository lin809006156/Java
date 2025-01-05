package exception;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        try {
            saveAge(a);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception occurred");
        }

        try {
            saveAge2(199);
        } catch (ageException e) {
            e.printStackTrace();
            System.out.println("Exception occurred2");
        }
    }

    public static void saveAge(int age) {
        if (age > 0 && age < 200) {
            System.out.println("Saved successfully");
        } else {
            throw new ageRuntimeException("/Wrong age" + age);
        }
    }

    public static void saveAge2(int age) throws ageException {
        if (age > 0 && age < 200) {
            System.out.println("Saved successfully2");
        } else {
            throw new ageException("/Wrong age" + age);
        }
    }
}
