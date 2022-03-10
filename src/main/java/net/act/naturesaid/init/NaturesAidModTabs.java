
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.act.naturesaid.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class NaturesAidModTabs {
	public static CreativeModeTab TAB_NATURESAIDTAB;

	public static void load() {
		TAB_NATURESAIDTAB = new CreativeModeTab("tabnaturesaidtab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(NaturesAidModItems.NATURESAIDPREV.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
