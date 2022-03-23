package net.act.naturesaid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.init.NaturesAidModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class VillagerLowRepInteractionProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getTarget(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Villager) {
			CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
			if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
				if ((sourceentity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation < 0) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 10, 1, 2, 1, 1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")), SoundSource.VOICE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")),
									SoundSource.VOICE, 1, 1, false);
						}
					}
					if (sourceentity instanceof Player _player && !_player.level.isClientSide())
						_player.displayClientMessage(new TextComponent(("\u00A7c" + new TranslatableComponent("ecorep.villager.no").getString())),
								(true));
				}
			}
		}
	}
}
