
package net.act.naturesaid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class BookIconItem extends Item {
	public BookIconItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
