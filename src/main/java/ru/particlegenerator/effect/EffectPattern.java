package ru.particlegenerator.effect;

import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec2f;
import ru.particlegenerator.animation.spawn.ParticleSpawnSettings;
import ru.particlegenerator.util.ParticlePattern;


public class EffectPattern {
    public ParticleSpawnSettings spawnSettings;

    public ParticlePattern pattern;
    public ParticleEffect effect;

    public Vec2f size = new Vec2f(1, 1);

    public boolean horizontal = false;


    public EffectPattern(ParticlePattern pattern, ParticleEffect effect, ParticleSpawnSettings spawnSettings){
        this.pattern = pattern;
        this.effect = effect;
        this.spawnSettings = spawnSettings;
    }

    public void draw (EffectWorldData worldData) {
        for(Vec2f pos: pattern.points())
            if (spawnSettings.generate())
                worldData.world().spawnParticles(effect,
                        worldData.pos().x + pos.x * size.x,
                        worldData.pos().y + (horizontal ? 0: pos.y * size.y),
                        worldData.pos().z + (horizontal ? pos.y * size.y: 0),
                        1, 0, 0, 0, 0);
    }
}
