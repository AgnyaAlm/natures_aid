
package net.act.naturesaid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.act.naturesaid.init.NaturesAidModTabs;

public class RecyclingTrophyItem extends Item {
	public RecyclingTrophyItem() {
		super(new Item.Properties().tab(NaturesAidModTabs.TAB_PLASTICSTUFF).stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
