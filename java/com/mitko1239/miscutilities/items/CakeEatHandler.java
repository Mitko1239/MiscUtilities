package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCake;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * Created by dimit on 2.6.2016 г..
 */
public class CakeEatHandler {

    public static String modid = Main.MODID;
    private static final Random rand = new Random();

    @SubscribeEvent
    public void cakeEating(PlayerInteractEvent.RightClickBlock event) {
        if(event.getEntityPlayer().getHeldItemMainhand() == null) {
            IBlockState state = event.getWorld().getBlockState(event.getPos());
            Block block = state.getBlock();
            if(block instanceof BlockCake) {
                event.getEntityPlayer().addPotionEffect(new PotionEffect(MobEffects.SPEED, 460, 22, false, false));
//                event.getEntityPlayer().
//                event.getWorld().spawnEntityInWorld(new EntityFireworkRocket(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.FIREWORKS)));
                if (!event.getWorld().isRemote) {
                    for(int i = 0; i < 4; i++) {
                        CakeEatHandler.spawnFireworkAround(new BlockPos(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ()), 0);
                    }
                    event.getEntityPlayer().addChatMessage(new TextComponentString(ChatFormatting.AQUA + "Happy birthday, Axil!"));
//                    event.getWorld().spawnEntityInWorld(new EntityFireworkRocket(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(Items.FIREWORKS)));
//                    EntityFireworkRocket firework = new EntityFireworkRocket(event.getEntityPlayer().worldObj);
//                    firework.setLocationAndAngles(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntityPlayer().cameraYaw, event.getEntityLiving().cameraPitch);
//
//
//
//
//
//                    event.getEntityPlayer().worldObj.spawnEntityInWorld(firework);
                }
            }
        }
    }

    public static void spawnFireworkAround(BlockPos block, int dimID)
    {
        World world = DimensionManager.getWorld(dimID);

//        BlockPos pos = new BlockPos(0, 0, 0);
        BlockPos pos = new BlockPos(block.getX(), block.getY(), block.getZ());

        int tries = -1;
        while (!world.isAirBlock(pos) && !world.getBlockState(pos).getBlock().isReplaceable(world, pos))
        {
            tries++;
            if (tries > 100)
            {
                return;
            }

            pos = new BlockPos(moveRandomly(block.getX()), block.getY() + 2, moveRandomly(block.getZ()));
        }

        ItemStack firework = new ItemStack(Items.FIREWORKS);
        firework.setTagCompound(new NBTTagCompound());
        NBTTagCompound expl = new NBTTagCompound();
        expl.setBoolean("Flicker", true);
        expl.setBoolean("Trail", true);

        int[] colors = new int[rand.nextInt(8) + 1];
        for (int i = 0; i < colors.length; i++)
        {
            colors[i] = ItemDye.DYE_COLORS[rand.nextInt(16)];
        }
        expl.setIntArray("Colors", colors);
        byte type = (byte) (rand.nextInt(3) + 1);
        type = type == 3 ? 4 : type;
        expl.setByte("Type", type);

        NBTTagList explosions = new NBTTagList();
        explosions.appendTag(expl);

        NBTTagCompound fireworkTag = new NBTTagCompound();
        fireworkTag.setTag("Explosions", explosions);
        fireworkTag.setByte("Flight", (byte) 1);
        firework.getTagCompound().setTag("Fireworks", fireworkTag);

        EntityFireworkRocket e = new EntityFireworkRocket(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, firework);
        world.spawnEntityInWorld(e);
    }

    private static final double distMult = 12d;

    private static double moveRandomly(double base)
    {
        return base + 0.5 + rand.nextDouble() * distMult - (distMult / 2);
    }

}
