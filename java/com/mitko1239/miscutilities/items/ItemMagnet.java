package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.helpers.NBTHelper;
import com.mitko1239.miscutilities.utilities.MagnetFX;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemMagnet extends Item {


//    String[] items = new String[] {};
//
//    private static final List<String> BLACKLIST = Arrays.asList(items);

    public boolean enabled = true;

    public ItemMagnet(String unlocalizedName) {
        this.setCreativeTab(Main.creativeTab);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(unlocalizedName);
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote)
        {
            if(this.enabled == true)
            {
                this.enabled = false;
            }
            else
            {
                this.enabled = true;
            }
        }
        return EnumActionResult.SUCCESS;
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if (stack.getTagCompound() == null)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        if (!worldIn.isRemote)
        {
            stack.getTagCompound().setInteger("cooldown", 0);
            stack.getTagCompound().setInteger("pull", 0);
        }
    }

    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected)
    {
        if (stack.getTagCompound() == null)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        if(entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)entity;

            if(amountHeld(player) <= 1 && enabled == true)
            {
                double x = player.posX;
                double y = player.posY + 1.5;
                double z = player.posZ;

                int range = 5;
                int cooldown = stack.getTagCompound().getInteger("cooldown");
                int pull = stack.getTagCompound().getInteger("pull");

                boolean isPulling = false;

                List<EntityItem> items = entity.worldObj.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x - range, y - range, z - range, x + range, y + range, z + range));
                for(EntityItem e: items)
                {
                    if(!player.isSneaking() && cooldown == 0)
                    {
                        //if(!isBlackListed(e.getEntityItem()))
                        //{
                            isPulling = true;

                            double factor = 0.03;

                            e.addVelocity((x - e.posX) * factor, (y - e.posY) * factor, (z - e.posZ) * factor);

                            if(world.isRemote && true)
                            {
                                MagnetFX mag1= new MagnetFX(world, e.posX, e.posY + 0.3, e.posZ, 0, 0, 0);
                                Minecraft.getMinecraft().effectRenderer.addEffect(mag1);
                            }

                            if(pull == 75)
                            {
                                cooldown = 50;
                                pull = 0;
                            }
                        //}
                    }
                }
                if(items.isEmpty())
                {
                    pull = 0;
                    stack.getTagCompound().setInteger("pull", pull);
                    isPulling = false;
                }
                if(isPulling == true)
                {
                    pull++;
                    stack.getTagCompound().setInteger("pull", pull);
                }
                if(cooldown > 0)
                {
                    cooldown--;
                    stack.getTagCompound().setInteger("cooldown", cooldown);
                }
            }
        }
    }

    public void addCoolDown(ItemStack stack, World worldIn)
    {
        if (stack.getTagCompound() == null)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        if (!worldIn.isRemote)
        {
            stack.getTagCompound().setInteger("cooldown", 50);
        }
    }

    public int amountHeld(EntityPlayer player)
    {
        int amount = 0;
        for (int i = 0; i < player.inventory.mainInventory.length; ++i)
        {
            if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == this)
            {
                amount++;
            }
        }
        return amount;
    }

//    public static List<ItemStack> getBlacklist(ItemStack stack) {
//        List<ItemStack> blacklist = new ArrayList<>();
//        NBTTagCompound compound = NBTHelper.getItemStackCompound(stack);
//        if (compound.hasKey("MagnetBlacklist")) {
//            NBTTagList blacklistList = compound.getTagList("MagnetBlacklist", Constants.NBT.TAG_COMPOUND);
//            for (int i = 0; i < blacklistList.tagCount(); i++) {
//                NBTTagCompound itemTag = blacklistList.getCompoundTagAt(i);
//                blacklist.add(ItemStack.loadItemStackFromNBT(itemTag));
//            }
//        }
//        return blacklist;
//    }
//
//    public static List<Byte> getBlacklistCompareTypes(ItemStack stack) {
//        List<Byte> blacklist = new ArrayList<>();
//        NBTTagCompound compound = NBTHelper.getItemStackCompound(stack);
//        if (compound.hasKey("MagnetBlacklist")) {
//            NBTTagList blacklistList = compound.getTagList("MagnetBlacklist", Constants.NBT.TAG_COMPOUND);
//            for (int i = 0; i < blacklistList.tagCount(); i++) {
//                NBTTagCompound itemTag = blacklistList.getCompoundTagAt(i);
//                blacklist.add(itemTag.getByte("CompareType"));
//            }
//        }
//        return blacklist;
//    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
    {
        if (stack.getTagCompound() == null)
        {
            stack.setTagCompound(new NBTTagCompound());
        }
        //tooltip.add("Cooldown: "+Integer.toString(stack.getTagCompound().getInteger("cooldown")));
        //tooltip.add("Pull: "+Integer.toString(stack.getTagCompound().getInteger("pull")));
        if(this.amountHeld(playerIn) > 1)
        {
            tooltip.add("Cannot hold more than 1 magnet!");
        }
        if(this.enabled == true)
        {
            tooltip.add("Enabled");
        }
        else
        {
            tooltip.add("Disabled");
        }
    }
}