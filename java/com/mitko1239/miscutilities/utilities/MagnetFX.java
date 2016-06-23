package com.mitko1239.miscutilities.utilities;

/**
 * Created by dimit on 16.6.2016 г..
 */

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MagnetFX extends Particle
{
    private ResourceLocation texture = new ResourceLocation("miscutilities:particles/magnet_fx");
    Random rand = new Random();
    public int life = 8;

    public MagnetFX(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn)
    {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);

        this.particleRed = (float)0.92;
        this.particleGreen = (float)0.92;
        this.particleBlue = (float)0.92;

        this.particleAge = life;

        TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(texture.toString());
        this.setParticleTexture(sprite);

    }

    @Override
    public int getFXLayer(){
        return 1;
    }

    @Override
    public void onUpdate()
    {

        if (this.particleAge-- <= 0){
            this.setExpired();
        }

        if(this.particleAge % 2 == 0)
        {
            this.particleRed = (float)0.92;
            this.particleGreen = (float)0.92;
            this.particleBlue = (float)0.92;
        }
        else
        {
            this.particleRed = (float)0.94;
            this.particleGreen = (float)1.0;
            this.particleBlue = (float)1.0;
        }

    }


}