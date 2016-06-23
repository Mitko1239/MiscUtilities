package com.mitko1239.miscutilities.utilities;

/**
 * Created by dimit on 16.6.2016 г..
 */
import com.mitko1239.miscutilities.items.ItemMagnet;
import com.mitko1239.miscutilities.items.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
public class MagnetHandler {
    @SubscribeEvent
    public void itemTossed(ItemTossEvent event)
    {
        if(getItemsSlot(event.getPlayer(), ModItems.magnet) != -1)
        {
            ItemMagnet plant = (ItemMagnet) event.getPlayer().inventory.getStackInSlot(getItemsSlot(event.getPlayer(), ModItems.magnet)).getItem();
            plant.addCoolDown(event.getPlayer().inventory.getStackInSlot(getItemsSlot(event.getPlayer(), ModItems.magnet)), event.getPlayer().worldObj);
        }
    }

    @SubscribeEvent
    public void stitchTexture(TextureStitchEvent.Pre event)
    {
        ResourceLocation magnet_fx = new ResourceLocation("miscutilities:particles/magnet_fx");
        event.getMap().registerSprite(magnet_fx);
    }

    private int getItemsSlot(EntityPlayer player, Item item)
    {
        for (int i = 0; i < player.inventory.mainInventory.length; ++i)
        {
            if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item)
            {
                return i;
            }
        }
        return -1;
    }
}
