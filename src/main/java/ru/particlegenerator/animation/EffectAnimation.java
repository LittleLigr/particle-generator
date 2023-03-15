package ru.particlegenerator.animation;

import java.util.function.Consumer;

public class EffectAnimation {
    public final Consumer<AnimationTick> lambda;
    public final String startKey;
    public final String endKey;
    protected int tickCounter;

    public EffectAnimation(String startKey, String endKey, Consumer<AnimationTick> lambda) {
        this.lambda = lambda;
        this.startKey = startKey;
        this.endKey = endKey;

    }
}
