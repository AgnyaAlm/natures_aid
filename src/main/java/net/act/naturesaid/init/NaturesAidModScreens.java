
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.act.naturesaid.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.act.naturesaid.client.gui.VAPage5Screen;
import net.act.naturesaid.client.gui.VAPage4Screen;
import net.act.naturesaid.client.gui.VAPage3Screen;
import net.act.naturesaid.client.gui.VAPage2Screen;
import net.act.naturesaid.client.gui.VAPage1Screen;
import net.act.naturesaid.client.gui.SBPage2Screen;
import net.act.naturesaid.client.gui.SBFirstPageScreen;
import net.act.naturesaid.client.gui.ReputationUIScreen;
import net.act.naturesaid.client.gui.RecycleTableUIScreen;
import net.act.naturesaid.client.gui.MortarGUIScreen;
import net.act.naturesaid.client.gui.MBPage4Screen;
import net.act.naturesaid.client.gui.MBPage3Screen;
import net.act.naturesaid.client.gui.MBPage2Screen;
import net.act.naturesaid.client.gui.MBPage1Screen;
import net.act.naturesaid.client.gui.LeafCatcherInventoryScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NaturesAidModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(NaturesAidModMenus.LEAF_CATCHER_INVENTORY, LeafCatcherInventoryScreen::new);
			MenuScreens.register(NaturesAidModMenus.MORTAR_GUI, MortarGUIScreen::new);
			MenuScreens.register(NaturesAidModMenus.RECYCLE_TABLE_UI, RecycleTableUIScreen::new);
			MenuScreens.register(NaturesAidModMenus.REPUTATION_UI, ReputationUIScreen::new);
			MenuScreens.register(NaturesAidModMenus.SB_FIRST_PAGE, SBFirstPageScreen::new);
			MenuScreens.register(NaturesAidModMenus.SB_PAGE_2, SBPage2Screen::new);
			MenuScreens.register(NaturesAidModMenus.MB_PAGE_1, MBPage1Screen::new);
			MenuScreens.register(NaturesAidModMenus.MB_PAGE_2, MBPage2Screen::new);
			MenuScreens.register(NaturesAidModMenus.MB_PAGE_3, MBPage3Screen::new);
			MenuScreens.register(NaturesAidModMenus.MB_PAGE_4, MBPage4Screen::new);
			MenuScreens.register(NaturesAidModMenus.VA_PAGE_1, VAPage1Screen::new);
			MenuScreens.register(NaturesAidModMenus.VA_PAGE_2, VAPage2Screen::new);
			MenuScreens.register(NaturesAidModMenus.VA_PAGE_3, VAPage3Screen::new);
			MenuScreens.register(NaturesAidModMenus.VA_PAGE_4, VAPage4Screen::new);
			MenuScreens.register(NaturesAidModMenus.VA_PAGE_5, VAPage5Screen::new);
		});
	}
}
