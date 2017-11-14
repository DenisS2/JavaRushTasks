package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    private double averageGrade;
    //private String university;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Student(String name, int age, double averageGrade) {
        super(name,age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getPosition(){
        return "Студент";
    }

    public int getCourse() {
        return course;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    //public String getUniversity() {
    //    return university;
    //}

    //public void setUniversity(String university) {
    //    this.university = university;
    //}

    //public void printData() {
    //    System.out.println("Студент: " + name);
    //}

    //public void incAverageGradeBy01() {
    //    averageGrade += 0.1;
    //}

    //public void incAverageGradeBy02() {
    //    averageGrade += 0.2;
    //}

    public void incAverageGrade(double delta){
        double a=getAverageGrade();
        a += delta;
        setAverageGrade(a);
    }


    /*public void setValue(String name, double value) {
        if (name.equals("averageGrade")) {
            averageGrade = value;
            return;
        }
        if (name.equals("course")) {
            course = (int) value;
            return;
        }
    }*/

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}