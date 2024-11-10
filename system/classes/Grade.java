package com.example.model;

import java.sql.Date;

public class Grade {

    private int gradeId;
    private int studentId;
    private int courseId;
    private String assessmentType;
    private String grade;
    private double score;
    private String comments;
    private Date gradedDate;

    // Constructor
    public Grade(int studentId, int courseId, String assessmentType, String grade, double score, String comments, Date gradedDate) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.assessmentType = assessmentType;
        this.grade = grade;
        this.score = score;
        this.comments = comments;
        this.gradedDate = gradedDate;
    }

    // Constructor for getting grade from database (with gradeId)
    public Grade(int gradeId, int studentId, int courseId, String assessmentType, String grade, double score, String comments, Date gradedDate) {
        this.gradeId = gradeId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.assessmentType = assessmentType;
        this.grade = grade;
        this.score = score;
        this.comments = comments;
        this.gradedDate = gradedDate;
    }

    // Getters and Setters
    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getGradedDate() {
        return gradedDate;
    }

    public void setGradedDate(Date gradedDate) {
        this.gradedDate = gradedDate;
    }
}
