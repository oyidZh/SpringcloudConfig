package com.activiti.pojo.email;

/**
 * 邮件封装
 * Created by 12490 on 2017/8/19.
 */
public class EmailDto {
    private String address;
    private EmailType type;
    private String subject;
    private String content;
    private String rscPath;
    private String rscId;

    public EmailDto() {
    }

    public EmailDto(String address, EmailType type, String subject, String content) {
        this.address = address;
        this.type = type;
        this.subject = subject;
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public EmailType getType() {
        return type;
    }

    public void setType(EmailType type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRscPath() {
        return rscPath;
    }

    public void setRscPath(String rscPath) {
        this.rscPath = rscPath;
    }

    public String getRscId() {
        return rscId;
    }

    public void setRscId(String rscId) {
        this.rscId = rscId;
    }

    @Override
    public String toString() {
        return "EmailDto{" +
                "address='" + address + '\'' +
                ", type=" + type +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", rscPath='" + rscPath + '\'' +
                ", rscId='" + rscId + '\'' +
                '}';
    }
}
