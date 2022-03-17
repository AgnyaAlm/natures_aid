package net.act.naturesaid.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.act.naturesaid.init.NaturesAidModGameRules;

public class IsReputationEnabledProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
			return true;
		}
		return false;
	}
}
