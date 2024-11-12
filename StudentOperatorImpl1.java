package interfacePractice;

import java.util.LinkedList;

public class StudentOperatorImpl1 implements StudentOperator {

    @Override
    public void printAllInfo(LinkedList<Student> students) {
        System.out.println("---------All students Info--------");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println("Name:" + s.getName() + " Sex:" + s.getSex() + " Score:" + s.getScore());
        }
        System.out.println("-----------------");
    }

    @Override
    public void printAverageScore(LinkedList<Student> students) {
        double allScore = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            allScore += s.getScore();
        }
        double averageScore = allScore / students.size();
        System.out.println("Average Score:" + averageScore);
    }
}