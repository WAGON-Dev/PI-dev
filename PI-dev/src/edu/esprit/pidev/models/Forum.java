/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;
import java.sql.Date;
/**
 *
 * @author omarfarouk
 */
public class Forum {
    private int userId;
    private int postId;
    private String image;
    private String title;
    private String content;
    private String topic;
    private Date date;
    
    public Forum(){}

    public Forum(String title ,String topic, Date date){
    this.title= title;
    this.topic = topic;
    this.date= date;
    
    }      
    
    public Forum(int userId, int postId, String image, String title, String content, String topic, Date date) {
        this.userId = userId;
        this.postId = postId;
        this.image = image;
        this.title = title;
        this.content = content;
        this.topic = topic;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Forum{" + "userId=" + userId + ", postId=" + postId + ", image=" + image + ", title=" + title + ", content=" + content + ", date=" + date + ", topic=" + topic + '}';
    }

    
    
        }