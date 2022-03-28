
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

import net.act.naturesaid.world.inventory.VAPage5Menu;
import net.act.naturesaid.world.inventory.VAPage4Menu;
import net.act.naturesaid.world.inventory.VAPage3Menu;
import net.act.naturesaid.world.inventory.VAPage2Menu;
import net.act.naturesaid.world.inventory.VAPage1Menu;
import net.act.naturesaid.world.inventory.SBPage2Menu;
import net.act.naturesaid.world.inventory.SBFirstPageMenu;
import net.act.naturesaid.world.inventory.ReputationUIMenu;
import net.act.naturesaid.world.inventory.RecycleTableUIMenu;
import net.act.naturesaid.world.inventory.MortarGUIMenu;
import net.act.naturesaid.world.inventory.MBPage4Menu;
import net.act.naturesaid.world.inventory.MBPage3Menu;
import net.act.naturesaid.world.inventory.MBPage2Menu;
import net.act.naturesaid.world.inventory.MBPage1Menu;
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
	public static final MenuType<SBPage2Menu> SB_PAGE_2 = register("sb_page_2", (id, inv, extraData) -> new SBPage2Menu(id, inv, extraData));
	public static final MenuType<MBPage1Menu> MB_PAGE_1 = register("mb_page_1", (id, inv, extraData) -> new MBPage1Menu(id, inv, extraData));
	public static final MenuType<MBPage2Menu> MB_PAGE_2 = register("mb_page_2", (id, inv, extraData) -> new MBPage2Menu(id, inv, extraData));
	public static final MenuType<MBPage3Menu> MB_PAGE_3 = register("mb_page_3", (id, inv, extraData) -> new MBPage3Menu(id, inv, extraData));
	public static final MenuType<MBPage4Menu> MB_PAGE_4 = register("mb_page_4", (id, inv, extraData) -> new MBPage4Menu(id, inv, extraData));
	public static final MenuType<VAPage1Menu> VA_PAGE_1 = register("va_page_1", (id, inv, extraData) -> new VAPage1Menu(id, inv, extraData));
	public static final MenuType<VAPage2Menu> VA_PAGE_2 = register("va_page_2", (id, inv, extraData) -> new VAPage2Menu(id, inv, extraData));
	public static final MenuType<VAPage3Menu> VA_PAGE_3 = register("va_page_3", (id, inv, extraData) -> new VAPage3Menu(id, inv, extraData));
	public static final MenuType<VAPage4Menu> VA_PAGE_4 = register("va_page_4", (id, inv, extraData) -> new VAPage4Menu(id, inv, extraData));
	public static final MenuType<VAPage5Menu> VA_PAGE_5 = register("va_page_5", (id, inv, extraData) -> new VAPage5Menu(id, inv, extraData));

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
