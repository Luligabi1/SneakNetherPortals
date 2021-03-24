package me.luligabi.sneaknetherportals.hook;

import me.luligabi.sneaknetherportals.SneakNetherPortals;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class NetherPortalBlockHook {

    public static void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo info) {
        if (!entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals()) {
            if(entity.getType() == EntityType.PLAYER) {
                if(entity.isSneaking()) {
                    entity.setInNetherPortal(pos);
                } else if(new SneakNetherPortals().getConfig().getOrDefault("sendWarningMessage", true)) {
                    ((PlayerEntity) entity).sendMessage(new TranslatableText("message.sneaknetherportals.warning").setStyle(Style.EMPTY.withColor(Formatting.RED)), true);
                }
            } else if(entity.getType() != EntityType.PLAYER) {
                entity.setInNetherPortal(pos);
            }
        }
    }
}
