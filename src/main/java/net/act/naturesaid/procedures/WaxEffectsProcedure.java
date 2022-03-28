package net.act.naturesaid.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.act.naturesaid.init.NaturesAidModParticles;

import java.util.Iterator;

public class WaxEffectsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
						ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honeycomb.wax_on")), SoundSource.BLOCKS, 1, (float) 0.9);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.honeycomb.wax_on")),
						SoundSource.BLOCKS, 1, (float) 0.9, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(NaturesAidModParticles.MAPLE_WAX, x, y, z, 15, 1, 1, 1, 0.1);
		if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements()
						.getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/wax_on"))).isDone()
				: false)) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:husbandry/wax_on"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		}
	}
}
