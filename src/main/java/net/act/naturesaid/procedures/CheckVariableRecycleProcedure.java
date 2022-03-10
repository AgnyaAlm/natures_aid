package net.act.naturesaid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.init.NaturesAidModGameRules;

import java.util.Iterator;

public class CheckVariableRecycleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems >= 1) {
			if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements()
							.getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:recycledfirst_adv")))
							.isDone()
					: false)) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:recycledfirst_adv"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemainingCriteria().iterator();
						while (_iterator.hasNext())
							_player.getAdvancements().award(_adv, (String) _iterator.next());
					}
				}
			}
		} else if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems >= 10) {
			if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements()
							.getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:recyclesecond_adv")))
							.isDone()
					: false)) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:recyclesecond_adv"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemainingCriteria().iterator();
						while (_iterator.hasNext())
							_player.getAdvancements().award(_adv, (String) _iterator.next());
					}
				}
			}
		} else if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems >= 100) {
			if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements()
							.getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:recyclethird_adv")))
							.isDone()
					: false)) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:recyclethird_adv"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemainingCriteria().iterator();
						while (_iterator.hasNext())
							_player.getAdvancements().award(_adv, (String) _iterator.next());
					}
				}
			}
		}
		{
			double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation + 1;
			entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.stat_reputation = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("\u00A7a" + new TranslatableComponent("ecorep.gain.recycle").getString())), (true));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")),
							SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
