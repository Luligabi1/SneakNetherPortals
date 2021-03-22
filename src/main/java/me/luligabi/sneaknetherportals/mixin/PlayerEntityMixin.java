package me.luligabi.sneaknetherportals.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    /**
     * @author Luligabi
     * @reason Instant portal traveling
     */
    @Overwrite
    public int getMaxNetherPortalTime() {
        return 1;
    }
}
