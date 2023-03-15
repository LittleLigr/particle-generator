package ru.particlegenerator.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import ru.particlegenerator.ExampleMod;
import ru.particlegenerator.animation.EffectAnimation;
import ru.particlegenerator.animation.spawn.ParticleSpawnRandom;
import ru.particlegenerator.animation.AnimationScheduler;
import ru.particlegenerator.effect.Effect;
import ru.particlegenerator.effect.EffectWorldData;


import java.util.List;

import static net.minecraft.server.command.CommandManager.literal;

public abstract class CommandContainer {


    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        var chot = literal("magic").requires(source -> source.hasPermissionLevel(4));

        dispatcher.register(chot.then(literal("draw").executes(
                source -> {
                    Vec3d pos = source.getSource().getPlayer().getPos();

                    EffectAnimation effectAnimation = new EffectAnimation(AnimationScheduler.INSTANT, "end", data -> {
                        if (data.tick() % 2 == 1)
                            data.worldData().effect().effect = ParticleTypes.FLAME;
                        else data.worldData().effect().effect = ParticleTypes.SOUL_FIRE_FLAME;
                    });



                   /* AnimationFragment a = new AnimationFragment(animationTick -> {
                        animationTick.effect().effectPattern().effect = animationTick.tickCounter() % 2 == 1 ? ParticleTypes.FLAME: ParticleTypes.SOUL_FIRE_FLAME;
                        ((ParticleSpawnRandom)animationTick.effect().effectPattern().spawnSettings).chance += 0.0001;
                        animationTick.effect().effectPattern().size =
                                new Vec2f((float) (animationTick.effect().effectPattern().size.x + 0.1),
                                        (float) (animationTick.effect().effectPattern().size.y + 0.1)
                        );

                        return animationTick.effect().effectPattern().size.x > 5;
                    });*/


                    //Effect effect = new Effect(ExampleMod.animation, new EffectWorldData(source.getSource().getWorld(), source.getSource().getPosition(), new Vec2f(0,0)), chain);
                    //AnimationScheduler.register(effect);
                    return 1;
                }
        )));
    }
}
