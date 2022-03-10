package net.act.naturesaid.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.act.naturesaid.network.NaturesAidModVariables;

import java.util.HashMap;

public class SetReputationCommandExecutedProcedure {
	public static void execute(Entity entity, HashMap cmdparams) {
		if (entity == null || cmdparams == null)
			return;
		if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "") <= 100 && new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "") >= -100) {
			{
				double _setval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "");
				entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.stat_reputation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7aSuccessfully set."), (false));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7cUsage: /setecorep [-100 to 100]"), (false));
		}
	}
}
