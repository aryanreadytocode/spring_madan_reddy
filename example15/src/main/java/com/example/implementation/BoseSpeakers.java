package com.example.implementation;

import com.example.interfaces.Speakers;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BoseSpeakers implements Speakers {

    @Override
    public String makeSound() {
        return "Playing music with Bose speakers";
    }
}
