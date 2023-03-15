package ru.particlegenerator.util;

import net.minecraft.util.math.Vec2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EffectTextureContainer {
    protected static final HashMap<String, BufferedImage> effectTextures = new HashMap<>();

    public static void registerFolder(File path) throws IOException {
        for (final File textureFile : path.listFiles())
            if (textureFile.isDirectory())
                registerFolder(textureFile);
            else effectTextures.put(processFileName(textureFile.getName()), ImageIO.read(textureFile));
    }

    protected static String processFileName(String name) {
        String name2 = name
                .toLowerCase()
                .substring(0, name.lastIndexOf('.'));
        return name2;
    }

    public static ParticlePattern convert(String textureName) {
        BufferedImage image = effectTextures.get(textureName);
        List<Vec2f> points = new LinkedList<>();

        for (int x = 0; x < image.getWidth(); x++)
            for (int y = 0; y < image.getHeight(); y++) {
                Color pixel = new Color(image.getRGB(x, y), true);
                if(pixel.getAlpha() != 0)
                    points.add(new Vec2f(x, y));
            }

        List<Vec2f> centered = points.stream().map(point -> new Vec2f(point.x - image.getWidth() / 2, point.y - image.getHeight() / 2)).toList();

        return new ParticlePattern(centered, new Vec2f(image.getWidth(), image.getHeight()));
    }
}
