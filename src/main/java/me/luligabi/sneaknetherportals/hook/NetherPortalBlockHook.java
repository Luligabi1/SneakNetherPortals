package me.luligabi.sneaknetherportals.hook;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class NetherPortalBlockHook {

    public static void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo info) {

    }
}
