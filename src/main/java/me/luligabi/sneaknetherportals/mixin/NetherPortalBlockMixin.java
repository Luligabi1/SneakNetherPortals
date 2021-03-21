package me.luligabi.sneaknetherportals.mixin;

import me.luligabi.sneaknetherportals.hook.NetherPortalBlockHook;
import net.minecraft.block.NetherPortalBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherPortalBlock.class)
public class NetherPortalBlockMixin {

    @Inject(method = "onEntityCollision", at = @At("HEAD"), cancellable = true)
    private void injectOnEntityCollision(CallbackInfo info) {
        NetherPortalBlock netherPortalBlock = ((NetherPortalBlock) (Object) this);
        NetherPortalBlockHook.onEntityCollision(netherPortalBlock.getBlo, world, pos, entity, info);
    }
}
