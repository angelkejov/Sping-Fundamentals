package com.likebookapp.init;

import com.likebookapp.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ImportEnums implements CommandLineRunner {

    private final MoodService moodService;

    @Autowired
    public ImportEnums(MoodService moodService) {
        this.moodService = moodService;
    }


    @Override
    public void run(String... args) throws Exception {
        moodService.initMoods();
    }
}
