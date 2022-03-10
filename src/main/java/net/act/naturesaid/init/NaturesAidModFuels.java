
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.act.naturesaid.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

@Mod.EventBusSubscriber
public class NaturesAidModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == NaturesAidModItems.SMALL_LEAF.get())
			event.setBurnTime(60);
		else if (event.getItemStack().getItem() == NaturesAidModItems.MAPLE_LEAF.get())
			event.setBurnTime(80);
	}
}
