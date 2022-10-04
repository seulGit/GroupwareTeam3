package com.team3.groupware.seongyu.model;

public class EDMS_certificateVO {
    private String certificate_docu_title;
    private String certificate_docu_contents;
    private String certificate_name;
    private String certificate_purpose;
    private String certificate_submit_to;
    private int EDMS_docu_num;

    public String getCertificate_docu_title() {
        return certificate_docu_title;
    }

    public void setCertificate_docu_title(String certificate_docu_title) {
        this.certificate_docu_title = certificate_docu_title;
    }

    public String getCertificate_docu_contents() {
        return certificate_docu_contents;
    }

    public void setCertificate_docu_contents(String certificate_docu_contents) {
        this.certificate_docu_contents = certificate_docu_contents;
    }

    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public String getCertificate_purpose() {
        return certificate_purpose;
    }

    public void setCertificate_purpose(String certificate_purpose) {
        this.certificate_purpose = certificate_purpose;
    }

    public String getCertificate_submit_to() {
        return certificate_submit_to;
    }

    public void setCertificate_submit_to(String certificate_submit_to) {
        this.certificate_submit_to = certificate_submit_to;
    }

    public int getEDMS_docu_num() {
        return EDMS_docu_num;
    }

    public void setEDMS_docu_num(int EDMS_docu_num) {
        this.EDMS_docu_num = EDMS_docu_num;
    }

    @Override
    public String toString() {
        return "EDMS_certificateVO{" +
                "certificate_docu_title='" + certificate_docu_title + '\'' +
                ", certificate_docu_contents='" + certificate_docu_contents + '\'' +
                ", certificate_name='" + certificate_name + '\'' +
                ", certificate_purpose='" + certificate_purpose + '\'' +
                ", certificate_submit_to='" + certificate_submit_to + '\'' +
                ", EDMS_docu_num=" + EDMS_docu_num +
                '}';
    }
}
