package com.team3.groupware.seongyu.model;

public class meetingroomVO {
    private int meetingroom_num;
    private int meetingroom_available;
    private String meetingroom_name;

    public int getMeetingroom_num() {
        return meetingroom_num;
    }

    public void setMeetingroom_num(int meetingroom_num) {
        this.meetingroom_num = meetingroom_num;
    }

    public int getMeetingroom_available() {
        return meetingroom_available;
    }

    public void setMeetingroom_available(int meetingroom_available) {
        this.meetingroom_available = meetingroom_available;
    }

    public String getMeetingroom_name() {
        return meetingroom_name;
    }

    public void setMeetingroom_name(String meetingroom_name) {
        this.meetingroom_name = meetingroom_name;
    }

    @Override
    public String toString() {
        return "meetingroomVO{" +
                "meetingroom_num=" + meetingroom_num +
                ", meetingroom_available=" + meetingroom_available +
                ", meetingroom_name='" + meetingroom_name + '\'' +
                '}';
    }
}
