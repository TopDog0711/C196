package com.horn.michael.c196.POJO;

import java.util.Date;

/**
 * Created by Mike on 4/14/2017.
 */

public class CourseAlert {
    private int courseId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getAlertDate() {
        return alertDate;
    }

    public void setAlertDate(Date alertDate) {
        this.alertDate = alertDate;
    }

    private Date alertDate;

    public CourseAlert(int courseId, Date alertDate) {
        this.courseId = courseId;
        this.alertDate = alertDate;
    }

    public CourseAlert() {
    }
}
