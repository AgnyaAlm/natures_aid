
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.act.naturesaid.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.act.naturesaid.block.entity.RecyclingTableBlockEntity;
import net.act.naturesaid.block.entity.MortarAndPestleBlockEntity;
import net.act.naturesaid.block.entity.LeafCatcherBlockEntity;
import net.act.naturesaid.NaturesAidMod;

public class NaturesAidModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, NaturesAidMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> LEAF_CATCHER = register("leaf_catcher", NaturesAidModBlocks.LEAF_CATCHER,
			LeafCatcherBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MORTAR_AND_PESTLE = register("mortar_and_pestle", NaturesAidModBlocks.MORTAR_AND_PESTLE,
			MortarAndPestleBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RECYCLING_TABLE = register("recycling_table", NaturesAidModBlocks.RECYCLING_TABLE,
			RecyclingTableBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
