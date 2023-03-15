package ru.particlegenerator.animation.spawn;

import java.util.Random;

public class ParticleSpawnRandom implements ParticleSpawnSettings {

    public static Random random = new Random();
    public double chance;

    public ParticleSpawnRandom(double chance) {
        this.chance = chance;
    }

    @Override
    public boolean generate() {
        return random.nextDouble() <= chance;
    }
}
