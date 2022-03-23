package net.act.naturesaid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.init.NaturesAidModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ItemThrownWaterProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(),
				event.getEntityItem().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!(world.getDifficulty() == Difficulty.PEACEFUL)) {
			if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
				if (world.getBiome(new BlockPos((int) x, (int) y, (int) z)).value().getRegistryName() != null
						&& BiomeDictionary
								.hasType(
										ResourceKey
												.create(Registry.BIOME_REGISTRY,
														world.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).getKey(world.getBiome(
																new BlockPos((int) x, (int) y, (int) z))
																.value())),
										BiomeDictionary.Type.OCEAN)
						|| world.getBiome(new BlockPos((int) x, (int) y, (int) z)).value().getRegistryName() != null && BiomeDictionary.hasType(
								ResourceKey.create(Registry.BIOME_REGISTRY,
										world.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY)
												.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)).value())),
								BiomeDictionary.Type.BEACH)) {
					sx = -3;
					found = false;
					for (int index0 = 0; index0 < (int) (6); index0++) {
						sy = -3;
						for (int index1 = 0; index1 < (int) (6); index1++) {
							sz = -3;
							for (int index2 = 0; index2 < (int) (6); index2++) {
								if ((world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz)))).getBlock() == Blocks.WATER
										|| (world.getBlockState(new BlockPos((int) (x + sx), (int) (y + sy), (int) (z + sz))))
												.getBlock() == Blocks.WATER) {
									found = true;
								}
								sz = sz + 1;
							}
							sy = sy + 1;
						}
						sx = sx + 1;
					}
					if (found == true) {
						if (itemstack.is(ItemTags.create(new ResourceLocation("forge:plastic")))) {
							{
								double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation - 5;
								entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.stat_reputation = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							CheckRepAdvOnJoinProcedure.execute(entity);
							if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
								if (found == true) {
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(
												new TextComponent(("\u00A7c"
														+ new TranslatableComponent("ecorep.penalty.plasticoceanorbeach").getString() + " \u00A77"
														+ new TranslatableComponent("ecorep.currentrep").getString()
														+ (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation
														+ ")")),
												(true));
								}
							}
						} else {
							{
								double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation - 1;
								entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.stat_reputation = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							CheckRepAdvOnJoinProcedure.execute(entity);
							if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
								if (found == true) {
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(
												new TextComponent(("\u00A7c" + new TranslatableComponent("ecorep.penalty.oceanorbeach").getString()
														+ " \u00A77" + new TranslatableComponent("ecorep.currentrep").getString()
														+ (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation
														+ ")")),
												(true));
								}
							}
						}
					}
				}
			}
		}
	}
}
