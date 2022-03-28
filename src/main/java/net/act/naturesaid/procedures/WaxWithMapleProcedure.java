package net.act.naturesaid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.act.naturesaid.init.NaturesAidModItems;

import javax.annotation.Nullable;

import java.util.Map;

@Mod.EventBusSubscriber
public class WaxWithMapleProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == NaturesAidModItems.MAPLE_SYRUP
					.get()) {
				if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.COPPER_BLOCK) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_COPPER_BLOCK.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CUT_COPPER) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_CUT_COPPER.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.EXPOSED_COPPER) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_EXPOSED_COPPER.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WEATHERED_COPPER) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_WEATHERED_COPPER.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OXIDIZED_COPPER) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_OXIDIZED_COPPER.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.EXPOSED_CUT_COPPER) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_EXPOSED_CUT_COPPER.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WEATHERED_CUT_COPPER) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_WEATHERED_CUT_COPPER.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OXIDIZED_CUT_COPPER) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_OXIDIZED_CUT_COPPER.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CUT_COPPER_STAIRS) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_CUT_COPPER_STAIRS.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.EXPOSED_CUT_COPPER_STAIRS) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WEATHERED_CUT_COPPER_STAIRS) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OXIDIZED_CUT_COPPER_STAIRS) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.CUT_COPPER_SLAB) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_CUT_COPPER_SLAB.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.EXPOSED_CUT_COPPER_SLAB) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WEATHERED_CUT_COPPER_SLAB) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				} else if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OXIDIZED_CUT_COPPER_SLAB) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB.defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
							if (_property != null && _bs.getValue(_property) != null)
								try {
									_bs = _bs.setValue(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						world.setBlock(_bp, _bs, 3);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					WaxEffectsProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}
}
