package com.team3.groupware.seongyu.model;

public class fixtureVO {
    private int fixtures_num;
    private int fixtures_available;
    private String fixtures_name;

    public int getFixtures_num() {
        return fixtures_num;
    }

    public void setFixtures_num(int fixtures_num) {
        this.fixtures_num = fixtures_num;
    }

    public int getFixtures_available() {
        return fixtures_available;
    }

    public void setFixtures_available(int fixtures_available) {
        this.fixtures_available = fixtures_available;
    }

    public String getFixtures_name() {
        return fixtures_name;
    }

    public void setFixtures_name(String fixtures_name) {
        this.fixtures_name = fixtures_name;
    }

    @Override
    public String toString() {
        return "fixtureVO{" +
                "fixtures_num=" + fixtures_num +
                ", fixtures_available=" + fixtures_available +
                ", fixtures_name='" + fixtures_name + '\'' +
                '}';
    }
}
