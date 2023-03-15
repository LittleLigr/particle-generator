package ru.particlegenerator.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.particlegenerator.animation.AnimationScheduler;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin {

	@Inject(at = @At("HEAD"), method = "tick")
	private void tick(CallbackInfo info) {
		AnimationScheduler.tick();
	}

}
