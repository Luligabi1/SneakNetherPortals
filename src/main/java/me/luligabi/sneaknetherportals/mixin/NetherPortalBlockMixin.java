package me.luligabi.sneaknetherportals.mixin;

import me.luligabi.sneaknetherportals.hook.NetherPortalBlockHook;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherPortalBlock.class)
public class NetherPortalBlockMixin {

    @Inject(method = "onEntityCollision", at = @At("HEAD"), cancellable = true)
    private void injectOnEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo info) {
        NetherPortalBlockHook.onEntityCollision(pos, entity, info);
        info.cancel();
    }
}
