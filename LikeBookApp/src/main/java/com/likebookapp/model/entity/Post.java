package com.likebookapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_likes_id")
    private User userLikes;

    @ManyToOne
    @JoinColumn(name = "mood_id", nullable = false)
    private Mood mood;

    public Post() {

    }

    public Post(Long id, String content, User user, User userLikes, Mood mood) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.userLikes = userLikes;
        this.mood = mood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(User userLikes) {
        this.userLikes = userLikes;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }
}
