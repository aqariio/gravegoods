package aqario.headstones.client;

import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.world.entity.EntityReference;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

public record PlayerInfoCache(EntityReference<Player> playerReference, @Nullable PlayerInfo playerInfo) {
}
