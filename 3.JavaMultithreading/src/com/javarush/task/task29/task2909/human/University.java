package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {//extends Student {

    private List<Student> students;
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        students=new ArrayList<>();
        //super(name, age, 0);
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student student=null;
        for (Student s:students) {
            if (s.getAverageGrade()==averageGrade){
                student=s;
            }
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student student=null;
        double maxAverageGrade=students.get(0).getAverageGrade();
        //int index=0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > maxAverageGrade) {
                maxAverageGrade=students.get(i).getAverageGrade();
                student=students.get(i);
            }
        }
        return student;
    }



    public Student getStudentWithMinAverageGrade(){
        double minAverageGrade=students.get(0).getAverageGrade();
        Student student=null;
        //int index=0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < minAverageGrade) {
                minAverageGrade=students.get(i).getAverageGrade();
                student=students.get(i);
            }
        }
        return student;
    }

    public void expel(Student student){
        if(students.contains(student)) students.remove(student);
    }
}