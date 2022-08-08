package me.luligabi.sneaknetherportals.mixin;

import me.luligabi.sneaknetherportals.SneakNetherPortals;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "getMaxNetherPortalTime", at = @At("HEAD"), cancellable = true)
    public void getMaxNetherPortalTime(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(SneakNetherPortals.getInstance().getConfig().getOrDefault("teleportDelay", 1));
    }
}
