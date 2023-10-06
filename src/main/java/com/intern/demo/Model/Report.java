package com.intern.demo.Model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "report")
public class Report {

    public Report()
    {

    }
    public Report(int report_id, char report_type, Instant timestamps, int content_id, int user_id, int post_id) {
        this.report_id = report_id;
        this.report_type = report_type;
        this.timestamps= timestamps;
        this.content_id = content_id;
        this.user_id = user_id;
        this.post_id = post_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "report_id",nullable = false)
    private int report_id;
    @Column(name = "report_type")
    private char report_type;
    @Column(name = "timestamps")
    private Instant timestamps = Instant.now();;
    @Column(name = "content_id")
    private int content_id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "post_id")
    private int post_id;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getContent_id() {
        return content_id;
    }

    public void setContent_id(int content_id) {
        this.content_id = content_id;
    }

    public Instant getTimestamp() {
        return timestamps;
    }

    public void setTimestamp(Instant timestamps) {
        this.timestamps = timestamps;
    }

    public char getReport_type() {
        return report_type;
    }

    public void setReport_type(char report_type) {
        this.report_type = report_type;
    }

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }
}
