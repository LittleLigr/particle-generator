package ru.particlegenerator.generator;

import net.minecraft.particle.ParticleEffect;
import net.minecraft.world.World;
import ru.particlegenerator.util.ParticlePattern;

public abstract class ParticleFabric {

    public static void draw(World world, ParticlePattern pattern, double x, double y, double z, ParticleEffect effect) {
        pattern.points().forEach((pos) -> {
            world.addParticle(effect, x + pos.x, y, z + pos.y, 0, 0, 0);
        });
    }
}
