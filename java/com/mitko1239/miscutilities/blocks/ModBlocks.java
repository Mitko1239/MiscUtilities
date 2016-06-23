package com.mitko1239.miscutilities.blocks;

import com.mitko1239.miscutilities.Main;
import com.mitko1239.miscutilities.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemMultiTexture;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public final class ModBlocks {

    public static String modid = Main.MODID;
    public static final Set<Block> BLOCKS = new HashSet<>();

//	public static Block tutorialBlock;
//	public static Block propertyBlock;
//	public static Block bluestoneOre;
//	public static Block randomOre;

    public static BlockColoredCobblestone COLORED_COBBLESTONE;
    public static Block tutorialBlock;
    public static Block bluestoneOre;
    public static Block randomOre;

    static {
        // THE REAL ONE
//        GameRegistry.register(propertyBlock = new BlockColoredCobblestone(
//                "block_prorperties"), new ResourceLocation(modid + ":" + propertyBlock.getUnlocalizedName()));

//        was attached to the registry entry for propertyBlock (the one below)
//        ItemBlockMeta.class


//		GameRegistry.register(propertyBlock = new BlockColoredCobblestone(Material.ROCK), block -> new ItemMultiTexture(block, block, BlockColoredCobblestone.EnumType.getNames());
        COLORED_COBBLESTONE = registerBlock(new BlockColoredCobblestone(Material.ROCK, "colored_cobblestone"), block -> new ItemMultiTexture(block, block, BlockColoredCobblestone.EnumType.getNames()));

        tutorialBlock = registerBlock(new BasicBlock("tutorial_block", Material.GLASS, 0.5F, 10.0F, SoundType.GLASS).setLightLevel(1.0f).setRegistryName(modid, "tutorial_block"));
        bluestoneOre = registerBlock(new ModBlockOre("bluestoneOre", Material.ROCK, ModItems.bluestone, 2, 4).setRegistryName(modid, "bluestoneOre"));
        randomOre = registerBlock(new ModBlockMultiOre("randomOre", Material.ROCK).setRegistryName(modid, "randomOre"));

//		GameRegistry.register(tutorialBlock = new BasicBlock(
//                "tutorial_block", Material.GLASS, 0.5F, 10.0F, SoundType.GLASS).setLightLevel(1.0f).setRegistryName(modid, "tutorial_block"));
//		GameRegistry.register(bluestoneOre = new ModBlockOre(
//                "bluestoneOre", Material.ROCK, ModItems.bluestone, 2, 4).setRegistryName(modid, "bluestoneOre"));
//		GameRegistry.register(randomOre = new ModBlockMultiOre(
//                "randomOre", Material.ROCK).setRegistryName(modid, "randomOre"));
//        GameRegistry.register(new ItemBlock(tutorialBlock).setRegistryName(modid, "tutorial_block"));
//        GameRegistry.register(new ItemBlock(bluestoneOre).setRegistryName(modid, "bluestoneOre"));
//        GameRegistry.register(new ItemBlock(randomOre).setRegistryName(modid, "randomOre"));
	}


    public static void registerBlocks() {
        // Dummy method to make sure the static initialiser runs
    }

    /**
     * Register a Block with the default ItemBlock class.
     *
     * @param block   The Block instance
     * @param <BLOCK> The Block type
     * @return The Block instance
     */
    protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block) {
        return registerBlock(block, ItemBlock::new);
    }

    /**
     * Register a Block with a custom ItemBlock class.
     *
     * @param <BLOCK>     The Block type
     * @param block       The Block instance
     * @param itemFactory A function that creates the ItemBlock instance, or null if no ItemBlock should be created
     * @return The Block instance
     */
    protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory) {
        GameRegistry.register(block);

        if (itemFactory != null) {
            final ItemBlock itemBlock = itemFactory.apply(block);

            GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
        }

        BLOCKS.add(block);
        return block;
    }
}
