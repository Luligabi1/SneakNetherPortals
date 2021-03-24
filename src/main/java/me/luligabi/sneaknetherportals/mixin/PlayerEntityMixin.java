package me.luligabi.sneaknetherportals.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "getMaxNetherPortalTime", at = @At("HEAD"), cancellable = true)
    public void getMaxNetherPortalTime(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(1);
    }
}
