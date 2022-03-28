
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
import net.act.naturesaid.item.VeganGrannybookItem;
import net.act.naturesaid.item.SyntheticLeatherItem;
import net.act.naturesaid.item.StartingbookItem;
import net.act.naturesaid.item.SmallLeafItem;
import net.act.naturesaid.item.SeitanSteakItem;
import net.act.naturesaid.item.SeitanDoughItem;
import net.act.naturesaid.item.RecyclingGrannybookItem;
import net.act.naturesaid.item.PureCocoItem;
import net.act.naturesaid.item.PlasticStickItem;
import net.act.naturesaid.item.PlasticSpoonItem;
import net.act.naturesaid.item.PlasticBlobItem;
import net.act.naturesaid.item.OilBottleItem;
import net.act.naturesaid.item.NaturesaidprevItem;
import net.act.naturesaid.item.NaturesAidDiscItem;
import net.act.naturesaid.item.MortarGrannybookItem;
import net.act.naturesaid.item.MaskorangeItem;
import net.act.naturesaid.item.MasklightblueItem;
import net.act.naturesaid.item.MaskgreenItem;
import net.act.naturesaid.item.MaskblueItem;
import net.act.naturesaid.item.MaskblackItem;
import net.act.naturesaid.item.MaskYellowItem;
import net.act.naturesaid.item.MaskWhiteItem;
import net.act.naturesaid.item.MaskRedItem;
import net.act.naturesaid.item.MaskMagentaItem;
import net.act.naturesaid.item.MapleSyrupItem;
import net.act.naturesaid.item.MapleSugarItem;
import net.act.naturesaid.item.MapleLeafItem;
import net.act.naturesaid.item.LeafpaperItem;
import net.act.naturesaid.item.LeafFeatherItem;
import net.act.naturesaid.item.IcoheroItem;
import net.act.naturesaid.item.IcohatedItem;
import net.act.naturesaid.item.IcoenemyItem;
import net.act.naturesaid.item.IcoadmiredItem;
import net.act.naturesaid.item.IcoAnimatedCosmeticsItem;
import net.act.naturesaid.item.HalfCoconutItem;
import net.act.naturesaid.item.CottonleafClothItem;
import net.act.naturesaid.item.CottonFiberItem;
import net.act.naturesaid.item.CosmeticGrannybookItem;
import net.act.naturesaid.item.CoconutMilkItem;
import net.act.naturesaid.item.CoconutItem;
import net.act.naturesaid.item.CelluloseFiberItem;
import net.act.naturesaid.item.BookIconItem;
import net.act.naturesaid.item.ApplePureeItem;
import net.act.naturesaid.item.AlcoholBottleItem;
import net.act.naturesaid.item.AcornMushItem;
import net.act.naturesaid.item.AcornItem;
import net.act.naturesaid.NaturesAidMod;

public class NaturesAidModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NaturesAidMod.MODID);
	public static final RegistryObject<Item> LEAF_CATCHER = block(NaturesAidModBlocks.LEAF_CATCHER, NaturesAidModTabs.TAB_NATURESAIDTAB);
	public static final RegistryObject<Item> MORTAR_AND_PESTLE = block(NaturesAidModBlocks.MORTAR_AND_PESTLE, NaturesAidModTabs.TAB_NATURESAIDTAB);
	public static final RegistryObject<Item> SMALL_LEAF = REGISTRY.register("small_leaf", () -> new SmallLeafItem());
	public static final RegistryObject<Item> CELLULOSE_FIBER = REGISTRY.register("cellulose_fiber", () -> new CelluloseFiberItem());
	public static final RegistryObject<Item> MAPLE_LEAF = REGISTRY.register("maple_leaf", () -> new MapleLeafItem());
	public static final RegistryObject<Item> ACORN = REGISTRY.register("acorn", () -> new AcornItem());
	public static final RegistryObject<Item> COCONUT = REGISTRY.register("coconut", () -> new CoconutItem());
	public static final RegistryObject<Item> HALF_COCONUT = REGISTRY.register("half_coconut", () -> new HalfCoconutItem());
	public static final RegistryObject<Item> PURE_COCO = REGISTRY.register("pure_coco", () -> new PureCocoItem());
	public static final RegistryObject<Item> COTTON_FIBER = REGISTRY.register("cotton_fiber", () -> new CottonFiberItem());
	public static final RegistryObject<Item> ALCOHOL_BOTTLE = REGISTRY.register("alcohol_bottle", () -> new AlcoholBottleItem());
	public static final RegistryObject<Item> LEAFPAPER = REGISTRY.register("leafpaper", () -> new LeafpaperItem());
	public static final RegistryObject<Item> COTTONLEAF_CLOTH = REGISTRY.register("cottonleaf_cloth", () -> new CottonleafClothItem());
	public static final RegistryObject<Item> RECYCLING_TABLE = block(NaturesAidModBlocks.RECYCLING_TABLE, NaturesAidModTabs.TAB_PLASTICSTUFF);
	public static final RegistryObject<Item> OIL_BOTTLE = REGISTRY.register("oil_bottle", () -> new OilBottleItem());
	public static final RegistryObject<Item> PLASTIC_BLOB = REGISTRY.register("plastic_blob", () -> new PlasticBlobItem());
	public static final RegistryObject<Item> PLASTIC_STICK = REGISTRY.register("plastic_stick", () -> new PlasticStickItem());
	public static final RegistryObject<Item> PLASTIC_SPOON = REGISTRY.register("plastic_spoon", () -> new PlasticSpoonItem());
	public static final RegistryObject<Item> ACORN_MUSH = REGISTRY.register("acorn_mush", () -> new AcornMushItem());
	public static final RegistryObject<Item> MAPLE_SUGAR = REGISTRY.register("maple_sugar", () -> new MapleSugarItem());
	public static final RegistryObject<Item> MAPLE_SYRUP = REGISTRY.register("maple_syrup", () -> new MapleSyrupItem());
	public static final RegistryObject<Item> MAPLE_BLOCK = block(NaturesAidModBlocks.MAPLE_BLOCK, NaturesAidModTabs.TAB_VEGAN_ALTERNATIVES);
	public static final RegistryObject<Item> COCONUT_MILK = REGISTRY.register("coconut_milk", () -> new CoconutMilkItem());
	public static final RegistryObject<Item> WHEAT_FLOUR = REGISTRY.register("wheat_flour", () -> new WheatFlourItem());
	public static final RegistryObject<Item> SEITAN_DOUGH = REGISTRY.register("seitan_dough", () -> new SeitanDoughItem());
	public static final RegistryObject<Item> SEITAN_STEAK = REGISTRY.register("seitan_steak", () -> new SeitanSteakItem());
	public static final RegistryObject<Item> LEAF_FEATHER = REGISTRY.register("leaf_feather", () -> new LeafFeatherItem());
	public static final RegistryObject<Item> APPLE_PUREE = REGISTRY.register("apple_puree", () -> new ApplePureeItem());
	public static final RegistryObject<Item> SYNTHETIC_LEATHER = REGISTRY.register("synthetic_leather", () -> new SyntheticLeatherItem());
	public static final RegistryObject<Item> MASKBLUE_HELMET = REGISTRY.register("maskblue_helmet", () -> new MaskblueItem.Helmet());
	public static final RegistryObject<Item> MASKBLACK_HELMET = REGISTRY.register("maskblack_helmet", () -> new MaskblackItem.Helmet());
	public static final RegistryObject<Item> MASKGREEN_HELMET = REGISTRY.register("maskgreen_helmet", () -> new MaskgreenItem.Helmet());
	public static final RegistryObject<Item> MASKLIGHTBLUE_HELMET = REGISTRY.register("masklightblue_helmet", () -> new MasklightblueItem.Helmet());
	public static final RegistryObject<Item> MASKORANGE_HELMET = REGISTRY.register("maskorange_helmet", () -> new MaskorangeItem.Helmet());
	public static final RegistryObject<Item> MASK_MAGENTA_HELMET = REGISTRY.register("mask_magenta_helmet", () -> new MaskMagentaItem.Helmet());
	public static final RegistryObject<Item> MASK_RED_HELMET = REGISTRY.register("mask_red_helmet", () -> new MaskRedItem.Helmet());
	public static final RegistryObject<Item> MASK_WHITE_HELMET = REGISTRY.register("mask_white_helmet", () -> new MaskWhiteItem.Helmet());
	public static final RegistryObject<Item> MASK_YELLOW_HELMET = REGISTRY.register("mask_yellow_helmet", () -> new MaskYellowItem.Helmet());
	public static final RegistryObject<Item> STARTINGBOOK = REGISTRY.register("startingbook", () -> new StartingbookItem());
	public static final RegistryObject<Item> MORTAR_GRANNYBOOK = REGISTRY.register("mortar_grannybook", () -> new MortarGrannybookItem());
	public static final RegistryObject<Item> VEGAN_GRANNYBOOK = REGISTRY.register("vegan_grannybook", () -> new VeganGrannybookItem());
	public static final RegistryObject<Item> RECYCLING_GRANNYBOOK = REGISTRY.register("recycling_grannybook", () -> new RecyclingGrannybookItem());
	public static final RegistryObject<Item> COSMETIC_GRANNYBOOK = REGISTRY.register("cosmetic_grannybook", () -> new CosmeticGrannybookItem());
	public static final RegistryObject<Item> NATURESAIDPREV = REGISTRY.register("naturesaidprev", () -> new NaturesaidprevItem());
	public static final RegistryObject<Item> ICOENEMY = REGISTRY.register("icoenemy", () -> new IcoenemyItem());
	public static final RegistryObject<Item> ICOHATED = REGISTRY.register("icohated", () -> new IcohatedItem());
	public static final RegistryObject<Item> ICOADMIRED = REGISTRY.register("icoadmired", () -> new IcoadmiredItem());
	public static final RegistryObject<Item> ICOHERO = REGISTRY.register("icohero", () -> new IcoheroItem());
	public static final RegistryObject<Item> ICO_ANIMATED_COSMETICS = REGISTRY.register("ico_animated_cosmetics",
			() -> new IcoAnimatedCosmeticsItem());
	public static final RegistryObject<Item> BOOK_ICON = REGISTRY.register("book_icon", () -> new BookIconItem());
	public static final RegistryObject<Item> RECYCLING_TROPHY = block(NaturesAidModBlocks.RECYCLING_TROPHY, NaturesAidModTabs.TAB_PLASTICSTUFF);
	public static final RegistryObject<Item> NATURES_AID_DISC = REGISTRY.register("natures_aid_disc", () -> new NaturesAidDiscItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
