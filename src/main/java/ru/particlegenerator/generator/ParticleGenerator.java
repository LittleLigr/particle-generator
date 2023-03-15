package ru.particlegenerator.generator;

import ru.particlegenerator.animation.spawn.ParticleSpawnSettings;
import ru.particlegenerator.util.ParticlePattern;

public class ParticleGenerator {

    public final ParticlePattern pattern;
    public final ParticleSpawnSettings spawnSettings;


    public ParticleGenerator(ParticlePattern pattern, ParticleSpawnSettings spawnSettings) {
        this.pattern = pattern;
        this.spawnSettings = spawnSettings;
    }
}
