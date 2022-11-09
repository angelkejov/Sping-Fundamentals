package com.likebookapp.service.impl;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.enums.MoodName;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    @Autowired
    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }



    @Override
    public void initMoods() {
        if (moodRepository.count() != 0){
            return;
        }
        Arrays.stream(MoodName.values())
                .forEach(moodName -> {
                    Mood mood = new Mood();
                    mood.setMoodName(moodName);
                    moodRepository.save(mood);
                });
    }

    @Override
    public Mood findByMoodNameEnum(MoodName moodName) {
        return moodRepository
                .findByMoodName(moodName)
                .orElse(null);
    }
}
