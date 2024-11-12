package interfacePractice;

import java.util.LinkedList;

public class ClassManager extends LinkedList {
    private LinkedList<Student> students = new LinkedList<>();
    private StudentOperator studentOperator=new StudentOperatorImpl2();

    public ClassManager() {
        students.add(new Student("Houser",100,'b'));
        students.add(new Student("A",10,'b'));
        students.add(new Student("B",80,'g'));
        students.add(new Student("C",60,'g'));
    }

    public void printInfo(){
        studentOperator.printAllInfo(students);
    }

    public void printScore(){
        studentOperator.printAverageScore(students);
    }

}
