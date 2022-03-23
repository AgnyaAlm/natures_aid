
package net.act.naturesaid.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.act.naturesaid.init.NaturesAidModTabs;

import java.util.List;

public class SeitanSteakItem extends Item {
	public SeitanSteakItem() {
		super(new Item.Properties().tab(NaturesAidModTabs.TAB_VEGAN_ALTERNATIVES).stacksTo(64).rarity(Rarity.COMMON)
				.food((new FoodProperties.Builder()).nutrition(8).saturationMod(12.8f)

						.build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("\u00A78Alternative to Steak"));
	}
}
