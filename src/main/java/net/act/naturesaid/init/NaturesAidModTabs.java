
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
	public static CreativeModeTab TAB_PLASTICSTUFF;
	public static CreativeModeTab TAB_VEGAN_ALTERNATIVES;
	public static CreativeModeTab TAB_COSMETICS;

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
		TAB_PLASTICSTUFF = new CreativeModeTab("tabplasticstuff") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(NaturesAidModBlocks.RECYCLING_TABLE.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_VEGAN_ALTERNATIVES = new CreativeModeTab("tabvegan_alternatives") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(NaturesAidModItems.MAPLE_SYRUP.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
		TAB_COSMETICS = new CreativeModeTab("tabcosmetics") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(NaturesAidModItems.ICO_ANIMATED_COSMETICS.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
