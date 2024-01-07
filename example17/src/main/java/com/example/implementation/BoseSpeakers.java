package com.example.implementation;

import com.example.model.interfaces.Speakers;
import com.example.model.Song;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {

    @Override
    public String makeSound(Song song) {
        return "Playing the song "+song.getTitle()+ " by "+song.getSingerName()+ " with Bose speakers";
    }
}
