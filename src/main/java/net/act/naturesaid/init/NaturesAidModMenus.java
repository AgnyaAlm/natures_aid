
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.act.naturesaid.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.act.naturesaid.world.inventory.SBFirstPageMenu;
import net.act.naturesaid.world.inventory.ReputationUIMenu;
import net.act.naturesaid.world.inventory.RecycleTableUIMenu;
import net.act.naturesaid.world.inventory.MortarGUIMenu;
import net.act.naturesaid.world.inventory.LeafCatcherInventoryMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NaturesAidModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<LeafCatcherInventoryMenu> LEAF_CATCHER_INVENTORY = register("leaf_catcher_inventory",
			(id, inv, extraData) -> new LeafCatcherInventoryMenu(id, inv, extraData));
	public static final MenuType<MortarGUIMenu> MORTAR_GUI = register("mortar_gui", (id, inv, extraData) -> new MortarGUIMenu(id, inv, extraData));
	public static final MenuType<RecycleTableUIMenu> RECYCLE_TABLE_UI = register("recycle_table_ui",
			(id, inv, extraData) -> new RecycleTableUIMenu(id, inv, extraData));
	public static final MenuType<ReputationUIMenu> REPUTATION_UI = register("reputation_ui",
			(id, inv, extraData) -> new ReputationUIMenu(id, inv, extraData));
	public static final MenuType<SBFirstPageMenu> SB_FIRST_PAGE = register("sb_first_page",
			(id, inv, extraData) -> new SBFirstPageMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
