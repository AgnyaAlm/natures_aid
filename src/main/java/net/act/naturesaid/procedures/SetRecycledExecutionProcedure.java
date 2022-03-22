package net.act.naturesaid.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.act.naturesaid.network.NaturesAidModVariables;

import java.util.HashMap;

public class SetRecycledExecutionProcedure {
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
		}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "") <= 100000 && new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(cmdparams.containsKey("0") ? cmdparams.get("0").toString() : "") >= 0) {
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
					capability.stat_recycleditems = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7aSuccessfully set."), (false));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("\u00A7cUsage: /setrecycled [0 to 100000]"), (false));
		}
	}
}
