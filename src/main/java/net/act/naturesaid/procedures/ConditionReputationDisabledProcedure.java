package net.act.naturesaid.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.act.naturesaid.init.NaturesAidModGameRules;

public class ConditionReputationDisabledProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == false) {
			return true;
		}
		return false;
	}
}
