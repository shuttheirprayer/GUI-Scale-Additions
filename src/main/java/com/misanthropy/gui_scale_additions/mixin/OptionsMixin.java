package com.misanthropy.gui_scale_additions.mixin;

import com.misanthropy.gui_scale_additions.Client;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Options.class)
abstract class OptionsMixin {
    @Inject(method = "processOptions", at = @At("HEAD"))
    private void gsa$process(Options.FieldAccess access, CallbackInfo ci) {
        access.process("guiScaleFine", Client.FINE);
    }
}
