package com.mitko1239.miscutilities.items;

import com.mitko1239.miscutilities.Main;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlockSpecial;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by dimit on 2.6.2016 г..
 */
public class ItemBirthdayChocolateCake extends ItemBlockSpecial {
    public ItemBirthdayChocolateCake (Block block, String unlocalizedName) {
        super(block);
        this.setCreativeTab(Main.creativeTab);
        this.setUnlocalizedName(unlocalizedName);
    }
}
