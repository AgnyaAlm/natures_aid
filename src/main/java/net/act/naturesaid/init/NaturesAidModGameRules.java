
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.act.naturesaid.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NaturesAidModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> ENABLEREPUTATION = GameRules.register("enableReputation", GameRules.Category.PLAYER,
			GameRules.BooleanValue.create(true));
}
