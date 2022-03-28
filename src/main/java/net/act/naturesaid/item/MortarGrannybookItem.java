
package net.act.naturesaid.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.act.naturesaid.procedures.MBOpenPage1Procedure;
import net.act.naturesaid.init.NaturesAidModTabs;

public class MortarGrannybookItem extends Item {
	public MortarGrannybookItem() {
		super(new Item.Properties().tab(NaturesAidModTabs.TAB_BOOK_TAB).stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemstack) {
		return new ItemStack(this);
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		MBOpenPage1Procedure.execute(world, x, y, z, entity);
		return ar;
	}
}
