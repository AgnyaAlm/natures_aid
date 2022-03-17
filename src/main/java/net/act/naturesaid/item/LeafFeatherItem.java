
package net.act.naturesaid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.act.naturesaid.init.NaturesAidModTabs;

public class LeafFeatherItem extends Item {
	public LeafFeatherItem() {
		super(new Item.Properties().tab(NaturesAidModTabs.TAB_VEGAN_ALTERNATIVES).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
