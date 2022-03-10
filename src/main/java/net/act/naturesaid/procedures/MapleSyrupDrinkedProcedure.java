package net.act.naturesaid.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class MapleSyrupDrinkedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.POISON) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.POISON);
		}
	}
}
