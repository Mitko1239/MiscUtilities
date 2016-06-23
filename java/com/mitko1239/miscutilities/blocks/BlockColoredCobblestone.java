package com.mitko1239.miscutilities.blocks;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.mitko1239.miscutilities.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockColoredCobblestone extends Block implements IMetaBlockName {

	@SuppressWarnings("rawtypes")
	/*public static final PropertyEnum TYPE = PropertyEnum.create("type",
			BlockColoredCobblestone.EnumType.class);*/
	public static final IProperty<EnumType> COLOR = PropertyEnum.create("color", EnumType.class);

	@SuppressWarnings("unchecked")
	public BlockColoredCobblestone(Material material, String blockName) {
		super(material);
        this.setBlockName(this, blockName);
        this.setCreativeTab(Main.creativeTab);
	}

    public static void setBlockName(Block block, String blockName) {
        block.setRegistryName(Main.MODID, blockName);
        block.setUnlocalizedName(blockName);
    }

//	public BlockColoredCobblestone(String unlocalizedName, float hardness,
//			float resistance) {
//		this(unlocalizedName, Material.ROCK, hardness, resistance);
//	}
//
//	public BlockColoredCobblestone(String unlocalizedName) {
//		this(unlocalizedName, 2.0f, 10.0f);
//	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, COLOR);
	}

	@SuppressWarnings({"unchecked", "deprecation"})
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(COLOR, EnumType.byMetadata(meta));
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(COLOR).getMeta();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

//    @Override
//    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
//        return worldIn.setBlockState(pos, state.cycleProperty(COLOR));
//    }

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for (final EnumType enumType : EnumType.values()) {
            list.add(new ItemStack(this, 1, enumType.getMeta()));
        }
	}

	public enum EnumType implements IStringSerializable {
		WHITE(0, "white"),
        BLACK(1, "black");

        private static final EnumType[] META_LOOKUP = Stream.of(values()).sorted(Comparator.comparing(EnumType::getMeta)).toArray(EnumType[]::new);

		private int meta;
		private String name;

		private EnumType(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

        public int getMeta() {
            return meta;
        }

		@Override
		public String getName() {
			return name;
		}

        public static EnumType byMetadata(int meta) {
            if (meta < 0 || meta >= META_LOOKUP.length) {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public static String[] getNames() {
            return Stream.of(META_LOOKUP).map(EnumType::getName).toArray(String[]::new);
        }
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return stack.getItemDamage() == 0 ? "white" : "black";
	}

	@Override
	public ItemStack getPickBlock(RayTraceResult target, World world,
                                  BlockPos pos) {
		return new ItemStack(Item.getItemFromBlock(this), 1,
				this.getMetaFromState(world.getBlockState(pos)));
	}
}
