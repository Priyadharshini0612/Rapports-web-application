package com.intern.demo.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "emailnotification")
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id",nullable = false, insertable=false)
    private int notification_id;
    @Column(name = "timestamb")
    private Instant createdtimestamp = Instant.now();
    @Column(name = "user_id")
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Instant getTimestamb() {
        return createdtimestamp ;
    }

    public void setTimestamb(Instant timestamp) {
        this.createdtimestamp  = timestamp;
    }

    public int getnotification_id() {
        return notification_id;
    }

    public void setnotification_id(int notification_id) {
        this.notification_id = notification_id;
    }
}
