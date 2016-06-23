package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.*;
import net.minecraft.world.World;

import java.util.Set;

/**
 * Created by dimit on 9.5.2016 г..
 */
public class ItemModHammer extends ItemTool {

    private int breakRadius;
    private int breakDepth;

    public Set EFFECTIVE_ON;

    private String harvesttool;
    private int harvestlevel;

    public ItemModHammer(int breakr, int breakd, float attackDamage, Item.ToolMaterial material, Set effectiveBlocks, String hartool, int harlevel) {
        super(breakr, attackDamage, material, effectiveBlocks);
        this.setHarvestLevel(hartool, harlevel);
        this.setCreativeTab(Main.creativeTab);
        this.breakRadius = breakr;
        this.breakDepth = breakd;
        this.EFFECTIVE_ON = effectiveBlocks;
        this.harvesttool = hartool;
        this.harvestlevel = harlevel;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
        IBlockState blockstate = player.worldObj.getBlockState(pos);

        RayTraceResult mop2 = this.rayTrace(player.worldObj, player, false);
//        MovingObjectPosition mop = this.raytraceFromEntity(player.worldObj, player, false, 4.5D);
        if(mop2 == null) {
            return super.onBlockStartBreak(itemstack, pos, player);
        }
        EnumFacing sideHit = mop2.sideHit;

        int xRange = breakRadius;
        int yRange = breakRadius;
        int zRange = breakDepth;
        switch(sideHit) {
            case DOWN:
            case UP:
                yRange = breakDepth;
                zRange = breakRadius;
                break;
            case NORTH:
            case SOUTH:
                xRange = breakRadius;
                zRange = breakDepth;
                break;
            case WEST:
            case EAST:
                xRange = breakDepth;
                zRange = breakRadius;
                break;
        }
        for(int xPos = pos.getX() - xRange; xPos <= pos.getX() + xRange; xPos++)
            for(int yPos = pos.getY() - yRange; yPos <= pos.getY() + yRange; yPos++)
                for(int zPos = pos.getZ() - zRange; zPos <= pos.getZ() + zRange; zPos++) {
                    if(xPos == pos.getX() && yPos == pos.getY() && zPos == pos.getZ())
                        continue;
                    if(!super.onBlockStartBreak(itemstack, new BlockPos(xPos, yPos, zPos), player))
                        breakBlocks(player.worldObj, xPos, yPos, zPos, sideHit, player, pos.getX(), pos.getY(), pos.getZ());
                }
        return super.onBlockStartBreak(itemstack, pos, player);
    }

    private void breakBlocks(World world, int x, int y, int z, EnumFacing sideHit, EntityPlayer player, int refX, int refY, int refZ) {
        BlockPos pos = new BlockPos(x, y, z);
        IBlockState blockstate = world.getBlockState(pos);
        Block block = blockstate.getBlock();
        if(!(player instanceof EntityPlayerMP)) {
            return;
        }
        EntityPlayerMP playermp = (EntityPlayerMP) player;
        if(world.isAirBlock(pos)) {
            return;
        }
        if(!(block.getHarvestTool(blockstate) == harvesttool) || (block.getHarvestLevel(blockstate) > harvestlevel)) {
            return;
        }
        if(!world.isRemote) {
            block.onBlockHarvested(world, pos, blockstate, player);
            if(block.removedByPlayer(blockstate, world, pos, player, true)) {
                block.onBlockDestroyedByPlayer(world, pos, blockstate);
                if(!player.capabilities.isCreativeMode) {
                    block.harvestBlock(world, player, pos, blockstate, null, null);
                    block.addDestroyEffects(world, pos, Minecraft.getMinecraft().effectRenderer);
                    block.dropXpOnBlockBreak(world, pos, block.getExpDrop(blockstate, world, pos, 0));
                }
            }
//            playermp.playerNetServerHandler.sendPacket(new S23PacketBlockChange(world, pos));
        }
    }

    private RayTraceResult raytraceFromEntity(World world, EntityPlayer player, PlayerControllerMP pcmp, boolean b, double range) {
        float f = 1.0F;
        float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
        float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
        double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double) f;
        double d1 = player.prevPosY + (player.posY - player.prevPosY) * (double) f;
        if(!world.isRemote && player instanceof EntityPlayer) {
            d1 += 1.62D;
        }
        double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double) f;
        Vec3d vec3 = new Vec3d(d0, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float) Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float) Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
        float f6 = MathHelper.sin(-f1 * 0.017453292F);
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = range;
        if(player instanceof EntityPlayer) {
            d3 = pcmp.getBlockReachDistance();
        }
        Vec3d vec31 = vec3.addVector((double) f7 * d3, (double) f6 * d3, (double) f8 * d3);
        return world.rayTraceBlocks(vec3, vec31, b, !b, b);
    }
}