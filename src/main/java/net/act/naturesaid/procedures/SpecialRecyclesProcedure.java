package net.act.naturesaid.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.act.naturesaid.init.NaturesAidModItems;
import net.act.naturesaid.init.NaturesAidModBlocks;

import java.util.function.Supplier;
import java.util.Map;
import java.util.Iterator;

public class SpecialRecyclesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get()instanceof Map _slt
				? ((Slot) _slt.get(0)).getItem()
				: ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:recyclable_netherite")))) {
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
						final ItemStack _setstack = new ItemStack(Items.NETHERITE_SCRAP);
						_setstack.setCount(2);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 2;
						final ItemStack _setstack = new ItemStack(Items.STICK);
						_setstack.setCount(1);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 3;
						final ItemStack _setstack = new ItemStack(Items.DIAMOND);
						_setstack.setCount(2);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
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
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(new ResourceLocation("forge:recyclable_diamond")))) {
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
						final ItemStack _setstack = new ItemStack(Items.DIAMOND);
						_setstack.setCount(2);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 3;
						final ItemStack _setstack = new ItemStack(Items.STICK);
						_setstack.setCount(1);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
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
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(new ResourceLocation("forge:recyclable_diamond_armor")))) {
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
						final ItemStack _setstack = new ItemStack(Items.DIAMOND);
						_setstack.setCount(2);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_CHESTPLATE) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.DIAMOND);
							_setstack.setCount(3);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
				} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Items.DIAMOND_LEGGINGS) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.DIAMOND);
							_setstack.setCount(2);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
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
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.is(ItemTags.create(new ResourceLocation("forge:recyclable_netherite_armor")))) {
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
						final ItemStack _setstack = new ItemStack(Items.DIAMOND);
						_setstack.setCount(2);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
								.getItem() == Items.NETHERITE_CHESTPLATE) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.NETHERITE_SCRAP);
							_setstack.setCount(3);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
				} else if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
						&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Items.NETHERITE_LEGGINGS) {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.NETHERITE_SCRAP);
							_setstack.setCount(3);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
				} else {
					{
						BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _slotid = 2;
							final ItemStack _setstack = new ItemStack(Items.NETHERITE_SCRAP);
							_setstack.setCount(2);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
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
				&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
						.getItem() == NaturesAidModBlocks.RECYCLING_TROPHY.get().asItem()) {
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
						_setstack.setCount(24);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _slotid = 2;
						final ItemStack _setstack = new ItemStack(Items.DIAMOND);
						_setstack.setCount(3);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable)
								((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
						});
					}
				}
				CheckVariableRecycleProcedure.execute(world, x, y, z, entity);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 10));
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("natures_aid:recyclesecret_adv"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemainingCriteria().iterator();
						while (_iterator.hasNext())
							_player.getAdvancements().award(_adv, (String) _iterator.next());
					}
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
		}
	}
}
