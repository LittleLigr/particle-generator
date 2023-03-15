package ru.particlegenerator.effect;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;

public record EffectWorldData(ServerWorld world, Vec3d pos, Vec2f size, EffectPattern effect) {
}
