package net.act.naturesaid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.init.NaturesAidModGameRules;

import javax.annotation.Nullable;

import java.util.Iterator;

@Mod.EventBusSubscriber
public class TrampleRepDecreaseProcedure {
	@SubscribeEvent
	public static void onFarmlandTrampled(BlockEvent.FarmlandTrampleEvent event) {
		execute(event, event.getWorld(), event.getEntity(), event.getFallDistance());
	}

	public static void execute(LevelAccessor world, Entity entity, double falldistance) {
		execute(null, world, entity, falldistance);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double falldistance) {
		if (entity == null)
			return;
		if (falldistance <= 3) {
			if (!(world.getDifficulty() == Difficulty.PEACEFUL)) {
				{
					double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation + 1;
					entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stat_reputation = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
					if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation < 0) {
						if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
								? _plr.getAdvancements()
										.getOrStartProgress(
												_plr.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:reputation_hated")))
										.isDone()
								: false)) {
							if (entity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements()
										.getAdvancement(new ResourceLocation("natures_aid:reputation_hated"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									Iterator _iterator = _ap.getRemainingCriteria().iterator();
									while (_iterator.hasNext())
										_player.getAdvancements().award(_adv, (String) _iterator.next());
								}
							}
						}
					} else if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation < 10) {
						if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
								? _plr.getAdvancements()
										.getOrStartProgress(
												_plr.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:reputation_enemy")))
										.isDone()
								: false)) {
							if (entity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements()
										.getAdvancement(new ResourceLocation("natures_aid:reputation_enemy"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									Iterator _iterator = _ap.getRemainingCriteria().iterator();
									while (_iterator.hasNext())
										_player.getAdvancements().award(_adv, (String) _iterator.next());
								}
							}
						}
					} else if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation > 10) {
						if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
								? _plr.getAdvancements()
										.getOrStartProgress(
												_plr.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:reputation_admired")))
										.isDone()
								: false)) {
							if (entity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements()
										.getAdvancement(new ResourceLocation("natures_aid:reputation_admired"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									Iterator _iterator = _ap.getRemainingCriteria().iterator();
									while (_iterator.hasNext())
										_player.getAdvancements().award(_adv, (String) _iterator.next());
								}
							}
						}
					} else if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation > 35) {
						if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
								? _plr.getAdvancements()
										.getOrStartProgress(
												_plr.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:reputation_hero")))
										.isDone()
								: false)) {
							if (entity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements()
										.getAdvancement(new ResourceLocation("natures_aid:reputation_hero"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									Iterator _iterator = _ap.getRemainingCriteria().iterator();
									while (_iterator.hasNext())
										_player.getAdvancements().award(_adv, (String) _iterator.next());
								}
							}
						}
					}
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent(("\u00A7c" + new TranslatableComponent("ecorep.penalty.farmlandtrampled").getString() + "\u00A77 "
										+ new TranslatableComponent("ecorep.currentrep").getString()
										+ (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation
										+ ")")),
								(true));
				}
			}
		}
	}
}
