package interfacePractice;

import java.util.LinkedList;

public class StudentOperatorImpl2 implements StudentOperator {

    @Override
    public void printAllInfo(LinkedList<Student> students) {
        int b = 0;
        int g = 0;

        System.out.println("---------All students Info--------");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println("Name:" + s.getName() + " Sex:" + s.getSex() + "Score:" + s.getScore());
            if (s.getSex() == 'b') {
                b++;
            } else {
                g++;
            }
        }
        System.out.println("Boy number:" + b);
        System.out.println("Girl number:" + g);
        System.out.println("-----------------");
    }

    @Override
    public void printAverageScore(LinkedList<Student> students) {
        double allScore = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            allScore += s.getScore();
        }

        double highestScore = students.get(0).getScore();
        double lowestScore = students.get(0).getScore();
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getScore() > highestScore)
                highestScore = s.getScore();
            if (s.getScore() < lowestScore)
                lowestScore = s.getScore();
        }
        double averageScore = (allScore-lowestScore-highestScore) / (students.size()-2);
        System.out.println("Average Score:" + averageScore);
    }

}