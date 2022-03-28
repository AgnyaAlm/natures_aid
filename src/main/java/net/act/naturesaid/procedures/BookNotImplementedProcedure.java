package net.act.naturesaid.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class BookNotImplementedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent("\u00A7cBook yet not implemented!"), (true));
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(new TextComponent(
					"\u00A77(\u00A74\u00A7l!\u00A77) This book isn't implemented yet. We are working on it. As an alternative, you can check the images from the curseforge page to see the crafting recipes. Don't hesitate to open an issue too!"),
					(false));
	}
}
