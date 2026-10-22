package com.misanthropy.gui_scale_additions.mixin;

import com.misanthropy.gui_scale_additions.Client;
import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Window.class)
abstract class WindowMixin {
    @ModifyVariable(method = "setGuiScale", at = @At("HEAD"), argsOnly = true)
    private double gsa$scale(double scale) {
        Minecraft mc = Minecraft.getInstance();
        return mc == null || mc.options == null ? scale : Client.scale(mc, scale);
    }
}
