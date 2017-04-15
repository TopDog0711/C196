package com.horn.michael.c196.POJO;

import java.util.Date;

/**
 * Created by Mike on 4/14/2017.
 */

public class AssessmentAlert {
    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Date getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(Date goalDate) {
        this.goalDate = goalDate;
    }

    private int assessmentId;
    private Date goalDate;

}
