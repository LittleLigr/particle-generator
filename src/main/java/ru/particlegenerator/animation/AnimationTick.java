package ru.particlegenerator.animation;

import ru.particlegenerator.effect.Effect;
import ru.particlegenerator.effect.EffectWorldData;

public record AnimationTick(EffectWorldData worldData, int tick) {
}
