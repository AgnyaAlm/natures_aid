package net.act.naturesaid.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;

import net.act.naturesaid.init.NaturesAidModItems;

public class CoconutBreakProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		(itemstack).shrink(1);
		if (world instanceof Level _level && !_level.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(NaturesAidModItems.HALF_COCONUT.get()));
			entityToSpawn.setPickUpDelay(2);
			_level.addFreshEntity(entityToSpawn);
		}
		if (world instanceof Level _level && !_level.isClientSide()) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(NaturesAidModItems.HALF_COCONUT.get()));
			entityToSpawn.setPickUpDelay(2);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}
