package me.luligabi.sneaknetherportals.hook;

import me.luligabi.sneaknetherportals.SimpleConfig;
import me.luligabi.sneaknetherportals.SneakNetherPortals;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class NetherPortalBlockHook {


    public static void onEntityCollision(BlockPos pos, Entity entity, CallbackInfo info) {
        if (!entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals()) {
            if(entity.getType() == EntityType.PLAYER) {
                if(!new SneakNetherPortals().getConfig().getOrDefault("invertBehavior", false)) {
                    if(entity.isSneaking()) {
                        entity.setInNetherPortal(pos);
                    } else {
                        sendWarningMessage((PlayerEntity) entity);
                    }
                } else {
                    if(!entity.isSneaking()) {
                        entity.setInNetherPortal(pos);
                    } else {
                        sendWarningMessage((PlayerEntity) entity);
                    }
                }
            } else {
                entity.setInNetherPortal(pos);
            }
        }
        info.cancel();
    }
    private static void sendWarningMessage(PlayerEntity playerEntity) {
        if(new SneakNetherPortals().getConfig().getOrDefault("sendWarningMessage", true)) {
            if(new SneakNetherPortals().getConfig().getOrDefault("invertBehavior", false)) {
                playerEntity.sendMessage(Text.translatable("message.sneaknetherportals.warning.inverted").setStyle(Style.EMPTY.withColor(Formatting.RED)), true);
            } else {
                playerEntity.sendMessage(Text.translatable("message.sneaknetherportals.warning").setStyle(Style.EMPTY.withColor(Formatting.RED)), true);
            }
        }
    }
}