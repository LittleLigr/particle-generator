package ru.particlegenerator.util;

import net.minecraft.util.math.Vec2f;

import java.util.List;
import java.util.stream.Collectors;

public record ParticlePattern(List<Vec2f> points, Vec2f size) {
    public List<Vec2f> build(double density) {
        if(density == 1)
            return points;
        return points;
    }

    public ParticlePattern sizeInBlocks(Vec2f size) {
        double stepX = 1.0 / this.size.x;
        double stepY = 1.0 / this.size.y;
        List<Vec2f> newPoints = points
                .stream()
                .map((pos) -> new Vec2f((float) (pos.x * stepX * size.x), (float) (pos.y * stepY * size.y)))
                .collect(Collectors.toList());

        return new ParticlePattern(newPoints, size);
    }
}
