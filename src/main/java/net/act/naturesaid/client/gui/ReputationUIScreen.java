
package net.act.naturesaid.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.act.naturesaid.world.inventory.ReputationUIMenu;
import net.act.naturesaid.procedures.IsReputationEnabledProcedure;
import net.act.naturesaid.procedures.IsPlayerNeutralProcedure;
import net.act.naturesaid.procedures.IsPlayerHatedProcedure;
import net.act.naturesaid.procedures.IsPlayerAnEnemyProcedure;
import net.act.naturesaid.procedures.IsPlayerAdmiredProcedure;
import net.act.naturesaid.procedures.IsPlayerAHeroProcedure;
import net.act.naturesaid.network.ReputationUIButtonMessage;
import net.act.naturesaid.network.NaturesAidModVariables;
import net.act.naturesaid.NaturesAidMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ReputationUIScreen extends AbstractContainerScreen<ReputationUIMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ReputationUIScreen(ReputationUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 188;
		this.imageHeight = 190;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		if (IsPlayerNeutralProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/repneutral.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 7, 0, 0, 32, 32, 32, 32);
		}
		if (IsPlayerAdmiredProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/repadmired.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 7, 0, 0, 32, 32, 32, 32);
		}
		if (IsPlayerAHeroProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/rephero.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 7, 0, 0, 32, 32, 32, 32);
		}
		if (IsPlayerAnEnemyProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/repenemy.png"));
			this.blit(ms, this.leftPos + 78, this.topPos + 7, 0, 0, 32, 32, 32, 32);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/rep32x.png"));
		this.blit(ms, this.leftPos + 77, this.topPos + 77, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/recycled32x.png"));
		this.blit(ms, this.leftPos + 76, this.topPos + 93, 0, 0, 16, 16, 16, 16);

		if (IsPlayerHatedProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/hatedbar.png"));
			this.blit(ms, this.leftPos + 14, this.topPos + 49, 0, 0, 160, 39, 160, 39);
		}
		if (IsPlayerAdmiredProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/admiredbar.png"));
			this.blit(ms, this.leftPos + 13, this.topPos + 49, 0, 0, 160, 39, 160, 39);
		}
		if (IsPlayerNeutralProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/neutralbar.png"));
			this.blit(ms, this.leftPos + 14, this.topPos + 49, 0, 0, 160, 39, 160, 39);
		}
		if (IsPlayerAnEnemyProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/enemybar.png"));
			this.blit(ms, this.leftPos + 14, this.topPos + 49, 0, 0, 160, 39, 160, 39);
		}
		if (IsPlayerHatedProcedure.execute(entity)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("natures_aid:textures/rephated.png"));
			this.blit(ms, this.leftPos + 79, this.topPos + 7, 0, 0, 32, 32, 32, 32);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		if (IsPlayerAHeroProcedure.execute(entity))
			this.font.draw(poseStack, "Hero of the world", 50, 43, -7152089);
		if (IsPlayerAnEnemyProcedure.execute(entity))
			this.font.draw(poseStack, "Enemy of the world", 47, 43, -8514540);
		if (IsPlayerHatedProcedure.execute(entity))
			this.font.draw(poseStack, "Hated", 80, 43, -3573126);
		if (IsPlayerAdmiredProcedure.execute(entity))
			this.font.draw(poseStack, "Admired", 76, 43, -7548259);
		if (IsPlayerNeutralProcedure.execute(entity))
			this.font.draw(poseStack, "Neutral", 76, 43, -3158065);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NaturesAidModVariables.PlayerVariables())).stat_reputation) + "", 95, 81, -1);
		this.font.draw(poseStack, "" + (int) ((entity.getCapability(NaturesAidModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NaturesAidModVariables.PlayerVariables())).stat_recycleditems) + "", 95, 97, -5316388);
		if (IsReputationEnabledProcedure.execute(world))
			this.font.draw(poseStack, "The reputation system is disabled in this world.", -25, 52, -10676200);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 69, this.topPos + 160, 51, 20, new TextComponent("Close"), e -> {
			if (true) {
				NaturesAidMod.PACKET_HANDLER.sendToServer(new ReputationUIButtonMessage(0, x, y, z));
				ReputationUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
