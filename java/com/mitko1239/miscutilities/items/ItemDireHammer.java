package com.mitko1239.miscutilities.items;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Set;

import static net.minecraft.init.Blocks.*;

public class ItemDireHammer extends ItemModHammer {

    private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] {ACTIVATOR_RAIL, COAL_ORE, COBBLESTONE, DETECTOR_RAIL, DIAMOND_BLOCK, DIAMOND_ORE, DOUBLE_STONE_SLAB, GOLDEN_RAIL, GOLD_BLOCK, GOLD_ORE, ICE, IRON_BLOCK, IRON_ORE, LAPIS_BLOCK, LAPIS_ORE, LIT_REDSTONE_ORE, MOSSY_COBBLESTONE, NETHERRACK, PACKED_ICE, RAIL, REDSTONE_ORE, SANDSTONE, RED_SANDSTONE, STONE, STONE_SLAB});

    public ItemDireHammer(String unlocalizedName, ToolMaterial material) {
        super(4, 0, 2.0F, material, EFFECTIVE_ON, "pickaxe", 4);
        this.setUnlocalizedName(unlocalizedName);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Creates a Direwolf20-sized hole (or tunnel)");
    }

}
