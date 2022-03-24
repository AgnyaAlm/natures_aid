package net.act.naturesaid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.act.naturesaid.init.NaturesAidModBlocks;

public class LeafCatcherNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).is(BlockTags.create(new ResourceLocation("minecraft:logs")))
				|| (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).is(BlockTags.create(new ResourceLocation("minecraft:logs")))
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).is(BlockTags.create(new ResourceLocation("minecraft:logs")))
				|| (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
						.is(BlockTags.create(new ResourceLocation("minecraft:logs"))))) {
			world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			if (world instanceof Level _level && !_level.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(NaturesAidModBlocks.LEAF_CATCHER.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
