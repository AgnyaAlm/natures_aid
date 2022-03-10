package net.act.naturesaid.procedures;

import net.minecraft.world.entity.Entity;

import net.act.naturesaid.network.NaturesAidModVariables;

public class IsPlayerHatedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation <= -1
				&& (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation >= 10) {
			return true;
		}
		return false;
	}
}
