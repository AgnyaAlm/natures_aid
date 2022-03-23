package net.act.naturesaid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;

import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.init.NaturesAidModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TrampleRepDecreaseProcedure {
	@SubscribeEvent
	public static void onFarmlandTrampled(BlockEvent.FarmlandTrampleEvent event) {
		execute(event, event.getWorld(), event.getEntity(), event.getFallDistance());
	}

	public static void execute(LevelAccessor world, Entity entity, double falldistance) {
		execute(null, world, entity, falldistance);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, double falldistance) {
		if (entity == null)
			return;
		if (falldistance <= 3) {
			CheckRepAdvOnJoinProcedure.execute(entity);
			if (!(world.getDifficulty() == Difficulty.PEACEFUL)) {
				if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
					if (entity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(
								new TextComponent(("\u00A7c" + new TranslatableComponent("ecorep.penalty.farmlandtrampled").getString() + "\u00A77 "
										+ new TranslatableComponent("ecorep.currentrep").getString()
										+ (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation
										+ ")")),
								(true));
				}
			}
		}
	}
}
