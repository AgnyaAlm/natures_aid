package net.act.naturesaid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.init.NaturesAidModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MaxRepEffectProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.HERO_OF_THE_VILLAGE) : false) {
			if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
				if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation <= 34) {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)
							? _livEnt.getEffect(MobEffects.HERO_OF_THE_VILLAGE).getDuration()
							: 0) >= 900) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
					}
				}
			} else if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == false) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)
						? _livEnt.getEffect(MobEffects.HERO_OF_THE_VILLAGE).getDuration()
						: 0) >= 900) {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
				}
			}
		} else {
			if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
				if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation >= 35) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 9999999, 0, (false), (false)));
				}
			}
		}
	}
}
