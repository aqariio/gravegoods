package aqario.headstones.mixin;

import aqario.headstones.common.Headstones;
import aqario.headstones.common.config.HeadstonesConfig;
import aqario.headstones.common.entity.GraveEntity;
import aqario.headstones.common.integration.TrinketsIntegration;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    @Shadow
    @Final
    Inventory inventory;

    @Shadow
    protected abstract void destroyVanishingCursedItems();

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "dropEquipment", at = @At("HEAD"), cancellable = true)
    private void headstones$dropInventory(CallbackInfo ci) {
        if(!HeadstonesConfig.enableGraves) {
            return;
        }
        if(this.level() instanceof ServerLevel level && !level.getGameRules().get(GameRules.KEEP_INVENTORY)) {
            this.destroyVanishingCursedItems();
            if(!this.inventory.isEmpty()
                || this.hasTrinkets()
            ) {
                GraveEntity grave = GraveEntity.create(Player.class.cast(this));
                this.level().addFreshEntity(grave);
                ci.cancel();
            }
        }
    }

    @Unique
    private boolean hasTrinkets() {
        if(Headstones.isTrinketsLoaded()) {
            return TrinketsIntegration.hasTrinkets(this);
        }
        return false;
    }
}
