package com.mitko1239.miscutilities.blocks;

import com.mitko1239.miscutilities.Main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class BlockFlower extends BlockBush implements IMetaBlockName {

	public static final IProperty<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

	@SuppressWarnings("unchecked")
	public BlockFlower(Material material, String blockName) {
		super(material);
        setBlockName(this, blockName);
		this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.setCreativeTab(Main.creativeTab);
	}

    public static void setBlockName(Block block, String blockName) {
        block.setRegistryName(Main.MODID, blockName);
        block.setUnlocalizedName(blockName);
    }

    @SideOnly(Side.CLIENT)
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, VARIANT);
	}

	@SuppressWarnings({"unchecked", "deprecation"})
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(VARIANT, EnumType.byMetadata(meta));
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(VARIANT).getMeta();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		for (final EnumType enumType : EnumType.values()) {
            list.add(new ItemStack(this, 1, enumType.getMeta()));
        }
	}

	public enum EnumType implements IStringSerializable {
		ROSE(0, "rose"),
        PAEONIA(1, "paeonia"),
		CYAN(2, "cyan");

        private static final EnumType[] META_LOOKUP = Stream.of(values()).sorted(Comparator.comparing(EnumType::getMeta)).toArray(EnumType[]::new);

		private int meta;
		private String name;

		EnumType(int meta, String name) {
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
        int i = stack.getItemDamage();
        if (i == 0) {
            return "rose";
        } else if (i == 1) {
            return "paeonia";
        } else if (i == 2) {
            return "cyan";
        } else {
            return null;
        }
    }

	@Override
	public ItemStack getPickBlock(RayTraceResult target, World world,
                                  BlockPos pos) {
		return new ItemStack(Item.getItemFromBlock(this), 1,
				this.getMetaFromState(world.getBlockState(pos)));
	}
}
