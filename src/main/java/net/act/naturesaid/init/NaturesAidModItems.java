
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.act.naturesaid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.act.naturesaid.item.WheatFlourItem;
import net.act.naturesaid.item.SmallLeafItem;
import net.act.naturesaid.item.SeitanSteakItem;
import net.act.naturesaid.item.SeitanDoughItem;
import net.act.naturesaid.item.PureCocoItem;
import net.act.naturesaid.item.PlasticStickItem;
import net.act.naturesaid.item.PlasticSpoonItem;
import net.act.naturesaid.item.PlasticBlobItem;
import net.act.naturesaid.item.OilBottleItem;
import net.act.naturesaid.item.NaturesaidprevItem;
import net.act.naturesaid.item.MapleSyrupItem;
import net.act.naturesaid.item.MapleSugarItem;
import net.act.naturesaid.item.MapleLeafItem;
import net.act.naturesaid.item.LeafpaperItem;
import net.act.naturesaid.item.HalfCoconutItem;
import net.act.naturesaid.item.CottonleafClothItem;
import net.act.naturesaid.item.CottonFiberItem;
import net.act.naturesaid.item.CoconutMilkItem;
import net.act.naturesaid.item.CoconutItem;
import net.act.naturesaid.item.CelluloseFiberItem;
import net.act.naturesaid.item.AcornItem;
import net.act.naturesaid.NaturesAidMod;

public class NaturesAidModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NaturesAidMod.MODID);
	public static final RegistryObject<Item> LEAF_CATCHER = block(NaturesAidModBlocks.LEAF_CATCHER, NaturesAidModTabs.TAB_NATURESAIDTAB);
	public static final RegistryObject<Item> MORTAR_AND_PESTLE = block(NaturesAidModBlocks.MORTAR_AND_PESTLE, NaturesAidModTabs.TAB_NATURESAIDTAB);
	public static final RegistryObject<Item> LEAFPAPER = REGISTRY.register("leafpaper", () -> new LeafpaperItem());
	public static final RegistryObject<Item> SMALL_LEAF = REGISTRY.register("small_leaf", () -> new SmallLeafItem());
	public static final RegistryObject<Item> CELLULOSE_FIBER = REGISTRY.register("cellulose_fiber", () -> new CelluloseFiberItem());
	public static final RegistryObject<Item> MAPLE_LEAF = REGISTRY.register("maple_leaf", () -> new MapleLeafItem());
	public static final RegistryObject<Item> ACORN = REGISTRY.register("acorn", () -> new AcornItem());
	public static final RegistryObject<Item> MAPLE_BLOCK = block(NaturesAidModBlocks.MAPLE_BLOCK, NaturesAidModTabs.TAB_NATURESAIDTAB);
	public static final RegistryObject<Item> MAPLE_SYRUP = REGISTRY.register("maple_syrup", () -> new MapleSyrupItem());
	public static final RegistryObject<Item> MAPLE_SUGAR = REGISTRY.register("maple_sugar", () -> new MapleSugarItem());
	public static final RegistryObject<Item> COCONUT = REGISTRY.register("coconut", () -> new CoconutItem());
	public static final RegistryObject<Item> HALF_COCONUT = REGISTRY.register("half_coconut", () -> new HalfCoconutItem());
	public static final RegistryObject<Item> PURE_COCO = REGISTRY.register("pure_coco", () -> new PureCocoItem());
	public static final RegistryObject<Item> OIL_BOTTLE = REGISTRY.register("oil_bottle", () -> new OilBottleItem());
	public static final RegistryObject<Item> PLASTIC_BLOB = REGISTRY.register("plastic_blob", () -> new PlasticBlobItem());
	public static final RegistryObject<Item> PLASTIC_STICK = REGISTRY.register("plastic_stick", () -> new PlasticStickItem());
	public static final RegistryObject<Item> PLASTIC_SPOON = REGISTRY.register("plastic_spoon", () -> new PlasticSpoonItem());
	public static final RegistryObject<Item> NATURESAIDPREV = REGISTRY.register("naturesaidprev", () -> new NaturesaidprevItem());
	public static final RegistryObject<Item> COCONUT_MILK = REGISTRY.register("coconut_milk", () -> new CoconutMilkItem());
	public static final RegistryObject<Item> RECYCLING_TABLE = block(NaturesAidModBlocks.RECYCLING_TABLE, NaturesAidModTabs.TAB_NATURESAIDTAB);
	public static final RegistryObject<Item> COTTON_FIBER = REGISTRY.register("cotton_fiber", () -> new CottonFiberItem());
	public static final RegistryObject<Item> COTTONLEAF_CLOTH = REGISTRY.register("cottonleaf_cloth", () -> new CottonleafClothItem());
	public static final RegistryObject<Item> WHEAT_FLOUR = REGISTRY.register("wheat_flour", () -> new WheatFlourItem());
	public static final RegistryObject<Item> SEITAN_DOUGH = REGISTRY.register("seitan_dough", () -> new SeitanDoughItem());
	public static final RegistryObject<Item> SEITAN_STEAK = REGISTRY.register("seitan_steak", () -> new SeitanSteakItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
