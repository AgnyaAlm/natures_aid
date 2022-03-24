
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.act.naturesaid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.act.naturesaid.block.RecyclingTrophyBlock;
import net.act.naturesaid.block.RecyclingTableBlock;
import net.act.naturesaid.block.MortarAndPestleBlock;
import net.act.naturesaid.block.MapleBlockBlock;
import net.act.naturesaid.block.LeafCatcherBlock;
import net.act.naturesaid.NaturesAidMod;

public class NaturesAidModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, NaturesAidMod.MODID);
	public static final RegistryObject<Block> LEAF_CATCHER = REGISTRY.register("leaf_catcher", () -> new LeafCatcherBlock());
	public static final RegistryObject<Block> MORTAR_AND_PESTLE = REGISTRY.register("mortar_and_pestle", () -> new MortarAndPestleBlock());
	public static final RegistryObject<Block> RECYCLING_TABLE = REGISTRY.register("recycling_table", () -> new RecyclingTableBlock());
	public static final RegistryObject<Block> MAPLE_BLOCK = REGISTRY.register("maple_block", () -> new MapleBlockBlock());
	public static final RegistryObject<Block> RECYCLING_TROPHY = REGISTRY.register("recycling_trophy", () -> new RecyclingTrophyBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			LeafCatcherBlock.registerRenderLayer();
			MortarAndPestleBlock.registerRenderLayer();
			RecyclingTableBlock.registerRenderLayer();
			MapleBlockBlock.registerRenderLayer();
			RecyclingTrophyBlock.registerRenderLayer();
		}
	}
}
