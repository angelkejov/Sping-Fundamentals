package com.likebookapp.model.entity;

import com.likebookapp.model.entity.enums.MoodName;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private MoodName moodName;

    private String description;

    public Mood() {

    }

    public Mood(Long id, MoodName moodName, String description) {
        this.id = id;
        this.moodName = moodName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoodName getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodName moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
