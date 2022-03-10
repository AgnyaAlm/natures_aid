package net.act.naturesaid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.init.NaturesAidModItems;

import java.util.function.Supplier;
import java.util.Map;

public class DoRecycleProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).getItem() == NaturesAidModItems.PLASTIC_SPOON.get()) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
					? ((Slot) _slt.get(1)).getItem()
					: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 0;
						final int _amount = 1;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								ItemStack _stk = capability.getStackInSlot(_slotid).copy();
								_stk.shrink(_amount);
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
							}
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 1;
						final ItemStack _setstack = new ItemStack(NaturesAidModItems.PLASTIC_BLOB.get());
						_setstack.setCount(2);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems + 1;
					entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stat_recycleditems = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("\u00A7c" + new TranslatableComponent("recycle.error.removeitems").getString())),
							(true));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
			}
		} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof SwordItem) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
					? ((Slot) _slt.get(1)).getItem()
					: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 0;
						final int _amount = 1;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								ItemStack _stk = capability.getStackInSlot(_slotid).copy();
								_stk.shrink(_amount);
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
							}
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 1;
						final ItemStack _setstack = new ItemStack(Items.STICK);
						_setstack.setCount(1);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems + 1;
					entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stat_recycleditems = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
				if (((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)).isEnchanted()) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI);
							_setstack.setCount(2);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					if (world instanceof Level _level && !_level.isClientSide())
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 20));
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("\u00A7c" + new TranslatableComponent("recycle.error.removeitems").getString())),
							(true));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
					? ((Slot) _slt.get(1)).getItem()
					: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 0;
						final int _amount = 1;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								ItemStack _stk = capability.getStackInSlot(_slotid).copy();
								_stk.shrink(_amount);
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
							}
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 1;
						final ItemStack _setstack = new ItemStack(Items.STICK);
						_setstack.setCount(1);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems + 1;
					entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stat_recycleditems = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
				if (((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)).isEnchanted()) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI);
							_setstack.setCount(2);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					if (world instanceof Level _level && !_level.isClientSide())
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 20));
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("\u00A7c" + new TranslatableComponent("recycle.error.removeitems").getString())),
							(true));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
					? ((Slot) _slt.get(1)).getItem()
					: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 0;
						final int _amount = 1;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								ItemStack _stk = capability.getStackInSlot(_slotid).copy();
								_stk.shrink(_amount);
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
							}
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 1;
						final ItemStack _setstack = new ItemStack(Items.STICK);
						_setstack.setCount(2);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems + 1;
					entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stat_recycleditems = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
				if (((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)).isEnchanted()) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI);
							_setstack.setCount(2);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					if (world instanceof Level _level && !_level.isClientSide())
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 20));
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("\u00A7c" + new TranslatableComponent("recycle.error.removeitems").getString())),
							(true));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
					? ((Slot) _slt.get(1)).getItem()
					: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 0;
						final int _amount = 1;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								ItemStack _stk = capability.getStackInSlot(_slotid).copy();
								_stk.shrink(_amount);
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
							}
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 1;
						final ItemStack _setstack = new ItemStack(Items.STICK);
						_setstack.setCount(2);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems + 1;
					entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stat_recycleditems = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
				if (((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)).isEnchanted()) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI);
							_setstack.setCount(2);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					if (world instanceof Level _level && !_level.isClientSide())
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 20));
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("\u00A7c" + new TranslatableComponent("recycle.error.removeitems").getString())),
							(true));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof HoeItem) {
			if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
					? ((Slot) _slt.get(1)).getItem()
					: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
					&& (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
							&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 0;
						final int _amount = 1;
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								ItemStack _stk = capability.getStackInSlot(_slotid).copy();
								_stk.shrink(_amount);
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _stk);
							}
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 1;
						final ItemStack _setstack = new ItemStack(Items.STICK);
						_setstack.setCount(2);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					double _setval = (entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems + 1;
					entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.stat_recycleditems = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
				if (((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)).isEnchanted()) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI);
							_setstack.setCount(2);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					if (world instanceof Level _level && !_level.isClientSide())
						_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 20));
				}
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("\u00A7c" + new TranslatableComponent("recycle.error.removeitems").getString())),
							(true));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
								ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")),
								SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("\u00A7c" + new TranslatableComponent("recycle.error.wrongitem").getString())),
						(true));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos((int) x, (int) y, (int) z),
							ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")),
							SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
