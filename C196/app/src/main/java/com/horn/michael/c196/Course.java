package com.horn.michael.c196;

import java.util.Date;
import java.util.Vector;

/**
 * Created by Mike on 4/14/2017.
 */



public class Course {
    private String title;
    private Date startDate;
    private Date endDate;
    private CourseStatus status;

    public Course() {
    }

    public Course(String title, Date startDate, Date endDate, CourseStatus status, Vector<Mentor> mentors) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.mentors = mentors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Vector<Mentor> getMentors() {
        return mentors;
    }

    public void setMentors(Vector<Mentor> mentors) {
        this.mentors = mentors;
    }

    private Vector<Mentor> mentors;


}
