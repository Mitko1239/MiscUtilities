package com.mitko1239.miscutilities.creativetabs;

import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by dimit on 1.6.2016 г..
 */
public class ModCreativeTabs extends CreativeTabs {

    public ModCreativeTabs() {
        super(Main.MODID);
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.BLUESTONE_DUST;
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
