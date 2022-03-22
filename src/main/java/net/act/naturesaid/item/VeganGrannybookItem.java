
package net.act.naturesaid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.act.naturesaid.init.NaturesAidModTabs;

public class VeganGrannybookItem extends Item {
	public VeganGrannybookItem() {
		super(new Item.Properties().tab(NaturesAidModTabs.TAB_BOOK_TAB).stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
