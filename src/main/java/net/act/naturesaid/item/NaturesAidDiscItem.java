
package net.act.naturesaid.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.act.naturesaid.init.NaturesAidModTabs;
import net.act.naturesaid.init.NaturesAidModSounds;

public class NaturesAidDiscItem extends RecordItem {
	public NaturesAidDiscItem() {
		super(0, NaturesAidModSounds.REGISTRY.get(new ResourceLocation("natures_aid:naturesaidmain")),
				new Item.Properties().tab(NaturesAidModTabs.TAB_COSMETICS).stacksTo(1).rarity(Rarity.RARE));
	}
}
