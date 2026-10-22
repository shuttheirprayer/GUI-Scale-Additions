package com.misanthropy.gui_scale_additions.mixin;

import com.misanthropy.gui_scale_additions.Client;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.screens.VideoSettingsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(VideoSettingsScreen.class)
abstract class VideoSettingsScreenMixin {
    @Inject(method = "options", at = @At("RETURN"))
    private static void gsa$options(Options options, CallbackInfoReturnable<OptionInstance<?>[]> cir) {
        OptionInstance<?>[] a = cir.getReturnValue();
        for (int i = 0; i < a.length; i++) if (a[i] == options.guiScale()) a[i] = Client.FINE;
    }
}
