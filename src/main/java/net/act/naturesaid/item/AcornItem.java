
package net.act.naturesaid.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import net.act.naturesaid.init.NaturesAidModTabs;

public class AcornItem extends Item {
	public AcornItem() {
		super(new Item.Properties().tab(NaturesAidModTabs.TAB_NATURESAIDTAB).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(1).saturationMod(0f).alwaysEat()

						.build()));
	}
}
