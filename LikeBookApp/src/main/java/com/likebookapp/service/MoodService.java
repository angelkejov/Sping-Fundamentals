package com.likebookapp.service;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodName;
import org.springframework.stereotype.Service;

@Service
public interface MoodService {
    void initMoods();

    Mood findByMoodNameEnum(MoodName moodName);
}
