package net.act.naturesaid.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.init.NaturesAidModGameRules;

import javax.annotation.Nullable;

import java.util.Iterator;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class WoodOrFaunaOnFireProcedure {
	@SubscribeEvent
	public static void onSaplingGrow(SaplingGrowTreeEvent event) {
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OAK_LOG) {
					{
						double _setval = (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null))
										.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation
								+ 1;
						((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
								.sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null))
										.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.stat_reputation = _setval;
											capability.syncPlayerVariables(((Entity) world
													.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
													.sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(null)));
										});
					}
					if (world.getLevelData().getGameRules().getBoolean(NaturesAidModGameRules.ENABLEREPUTATION) == true) {
						if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
								.sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null))
										.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation < 0) {
							if (!(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
									.sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null))instanceof ServerPlayer _plr
									&& _plr.level instanceof ServerLevel
											? _plr.getAdvancements()
													.getOrStartProgress(_plr.server.getAdvancements()
															.getAdvancement(new ResourceLocation("natures_aid:reputation_hated")))
													.isDone()
											: false)) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
										.sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null))instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements()
											.getAdvancement(new ResourceLocation("natures_aid:reputation_hated"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										Iterator _iterator = _ap.getRemainingCriteria().iterator();
										while (_iterator.hasNext())
											_player.getAdvancements().award(_adv, (String) _iterator.next());
									}
								}
							}
						} else if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
								.sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null))
										.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation < 10) {
							if (!(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
									.sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null))instanceof ServerPlayer _plr
									&& _plr.level instanceof ServerLevel
											? _plr.getAdvancements()
													.getOrStartProgress(_plr.server.getAdvancements()
															.getAdvancement(new ResourceLocation("natures_aid:reputation_enemy")))
													.isDone()
											: false)) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
										.sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null))instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements()
											.getAdvancement(new ResourceLocation("natures_aid:reputation_enemy"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										Iterator _iterator = _ap.getRemainingCriteria().iterator();
										while (_iterator.hasNext())
											_player.getAdvancements().award(_adv, (String) _iterator.next());
									}
								}
							}
						} else if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
								.sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null))
										.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation > 10) {
							if (!(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
									.sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null))instanceof ServerPlayer _plr
									&& _plr.level instanceof ServerLevel
											? _plr.getAdvancements()
													.getOrStartProgress(_plr.server.getAdvancements()
															.getAdvancement(new ResourceLocation("natures_aid:reputation_admired")))
													.isDone()
											: false)) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
										.sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null))instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements()
											.getAdvancement(new ResourceLocation("natures_aid:reputation_admired"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										Iterator _iterator = _ap.getRemainingCriteria().iterator();
										while (_iterator.hasNext())
											_player.getAdvancements().award(_adv, (String) _iterator.next());
									}
								}
							}
						} else if ((((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
								.sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null))
										.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation > 35) {
							if (!(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
									.sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null))instanceof ServerPlayer _plr
									&& _plr.level instanceof ServerLevel
											? _plr.getAdvancements()
													.getOrStartProgress(_plr.server.getAdvancements()
															.getAdvancement(new ResourceLocation("natures_aid:reputation_hero")))
													.isDone()
											: false)) {
								if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
										.sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null))instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements()
											.getAdvancement(new ResourceLocation("natures_aid:reputation_hero"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										Iterator _iterator = _ap.getRemainingCriteria().iterator();
										while (_iterator.hasNext())
											_player.getAdvancements().award(_adv, (String) _iterator.next());
									}
								}
							}
						}
						if (((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream()
								.sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null))instanceof Player _player && !_player.level.isClientSide())
							_player.displayClientMessage(
									new TextComponent(
											("\u00A7a" + new TranslatableComponent("ecorep.gain.sapling").getString() + "\u00A77 "
													+ new TranslatableComponent("ecorep.currentrep").getString()
													+ (((Entity) world
															.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
																}
															}.compareDistOf(x, y, z)).findFirst().orElse(null))
																	.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation
													+ ")")),
									(false));
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 4);
	}
}
