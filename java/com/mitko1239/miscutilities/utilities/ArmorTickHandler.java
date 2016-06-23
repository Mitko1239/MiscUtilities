package com.mitko1239.miscutilities.utilities;

import com.mitko1239.miscutilities.items.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by dimit on 31.5.2016 г..
 */
public class ArmorTickHandler {
    public static Map<EntityPlayer, Boolean> playersWithFlight = new WeakHashMap<EntityPlayer, Boolean>();

    @SubscribeEvent
    public void onEvent(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START || !event.player.worldObj.isRemote) return;


//        System.out.println("Equipment Stack "+event.player.inventory.armorItemInSlot(3));
//        if (event.player.inventory.armorItemInSlot(3) != null) System.out.println("Item "+event.player.inventory.armorItemInSlot(3).getItem());
//        System.out.println("Target Item "+ModItems.tutorialChestplate);

//        System.out.println(event.player.inventory.armorItemInSlot(3) != null && event.player.inventory.armorItemInSlot(3).getItem() == ModItems.tutorialChestplate);


        if (event.player.inventory.armorItemInSlot(3) != null && event.player.inventory.armorItemInSlot(3).getItem() == ModItems.tutorialChestplate) {

            playersWithFlight.put(event.player, true);
            event.player.capabilities.allowFlying = true;

        } else {

            if (!playersWithFlight.containsKey(event.player) && !event.player.capabilities.isCreativeMode) {
                playersWithFlight.put(event.player, false);
            }

//            if (playersWithFlight.get(event.player) && !event.player.capabilities.isCreativeMode) {
//                playersWithFlight.put(event.player, false);
//
//                if (!event.player.capabilities.isCreativeMode) {
//                    event.player.capabilities.allowFlying = false;
//                    event.player.capabilities.isFlying = false;
//                    event.player.sendPlayerAbilities();
//                }
//            }
        }
    }
}
