package ru.particlegenerator.animation.spawn;

import java.util.Random;

public interface ParticleSpawnSettings {
    default boolean generate() {
        return true;
    }
}

