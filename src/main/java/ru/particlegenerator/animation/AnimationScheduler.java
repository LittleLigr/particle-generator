package ru.particlegenerator.animation;

import ru.particlegenerator.effect.Effect;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class AnimationScheduler {
    public static final String INSTANT = "instant";
    protected static HashMap<Effect, Integer> tick = new HashMap<>();
    protected static HashMap<String, List<Effect>> keys = new HashMap<>();

    public static void tick() {
        tick.forEach((effect, tickCounter) -> {
            effect.effectAnimation().lambda.accept(new AnimationTick(effect.worldData(), tickCounter));
        });
    }

    public static void subscribe(String key, Effect effect) {
        if (keys.containsKey(key))
            keys.get(key).add(effect);
        else keys.put(key, List.of(effect));

        if (key == INSTANT)
            tick.put(effect, 0);
    }

    public static void stop(Effect effect){
        tick.remove(effect);
    }

    public static void unsubscribe(String key, Effect effect) {
        if (keys.containsKey(key))
            keys.get(key).remove(effect);
    }

    public static void trigger(String key){
        List<Effect> animations = keys.get(key);
        animations.forEach((effect -> tick.put(effect, 0)));
    }
}
