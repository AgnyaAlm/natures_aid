
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.act.naturesaid.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.act.naturesaid.network.ReputationKeyMessage;
import net.act.naturesaid.NaturesAidMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class NaturesAidModKeyMappings {
	public static final KeyMapping REPUTATION_KEY = new KeyMapping("key.natures_aid.reputation_key", GLFW.GLFW_KEY_I, "key.categories.naturesaid");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(REPUTATION_KEY);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == REPUTATION_KEY.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						NaturesAidMod.PACKET_HANDLER.sendToServer(new ReputationKeyMessage(0, 0));
						ReputationKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
