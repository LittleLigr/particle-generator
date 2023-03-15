package ru.particlegenerator;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec2f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.particlegenerator.effect.EffectPattern;
import ru.particlegenerator.animation.spawn.ParticleSpawnRandom;
import ru.particlegenerator.command.CommandContainer;
import ru.particlegenerator.util.EffectTextureContainer;
import ru.particlegenerator.util.ParticlePattern;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "particle-generator";

	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	public static ParticlePattern pattern;
	public static EffectPattern animation = null;
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			EffectTextureContainer.registerFolder(new File(classloader.getResource("assets\\particle-generator\\effects").toURI()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}

		pattern = EffectTextureContainer
					.convert("circe2")
					.sizeInBlocks(new Vec2f(1, 1));

		animation = new EffectPattern(pattern, ParticleTypes.ELECTRIC_SPARK, new ParticleSpawnRandom(0));


		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> CommandContainer.register(dispatcher));


	}
}
