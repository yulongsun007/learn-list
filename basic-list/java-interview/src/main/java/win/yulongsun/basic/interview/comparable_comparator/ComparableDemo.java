package win.yulongsun.basic.interview.comparable_comparator;

import java.util.Comparator;

/**
 * @author sunyulong on 2017/2/8.
 *
 * http://www.cnblogs.com/szlbm/p/5504634.html
 */
public class ComparableDemo {

    public static void main(String[] args) {

    }

}


//Comparator
class Student implements Comparator<Student> {

    Integer grade;

    public Student(Integer grade) {
        this.grade = grade;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getGrade() > o2.getGrade()) {
            return 1;
        } else if (o1.getGrade() < o2.getGrade()) {
            return -1;
        } else {
            return 0;
        }
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}


//Comparable
//能和自己比较
class Student2 implements Comparable<Student2> {
    Integer grade;

    public Student2(Integer grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Student2 o) {
        if (this.grade > o.grade) {
            return 1;
        } else if (this.grade < o.grade) {
            return -1;
        } else {
            return 0;
        }
    }
}