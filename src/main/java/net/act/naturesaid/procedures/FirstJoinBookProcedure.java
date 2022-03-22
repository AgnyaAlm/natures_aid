package net.act.naturesaid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.init.NaturesAidModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FirstJoinBookProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NaturesAidModVariables.PlayerVariables())).firstjoin == false) {
			{
				boolean _setval = true;
				entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.firstjoin = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(NaturesAidModItems.STARTINGBOOK.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()),
							new ItemStack(NaturesAidModItems.STARTINGBOOK.get()));
					entityToSpawn.setPickUpDelay(4);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
