package com.example.model;

public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private String enrollmentNumber;
    private String email;
    private String course;
    private int semester;

    // Constructor
    public Student(String firstName, String lastName, String enrollmentNumber, String email, String course, int semester) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentNumber = enrollmentNumber;
        this.email = email;
        this.course = course;
        this.semester = semester;
    }

    // Constructor for getting student from database (with studentId)
    public Student(int studentId, String firstName, String lastName, String enrollmentNumber, String email, String course, int semester) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentNumber = enrollmentNumber;
        this.email = email;
        this.course = course;
        this.semester = semester;
    }

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEnrollmentNumber() {
        return enrollmentNumber;
    }

    public void setEnrollmentNumber(String enrollmentNumber) {
        this.enrollmentNumber = enrollmentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
