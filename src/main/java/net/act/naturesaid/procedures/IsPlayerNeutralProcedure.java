package net.act.naturesaid.procedures;

import net.minecraft.world.entity.Entity;

import net.act.naturesaid.network.NaturesAidModVariables;

public class IsPlayerNeutralProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation >= 0
				&& (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation <= 9) {
			return true;
		}
		return false;
	}
}
