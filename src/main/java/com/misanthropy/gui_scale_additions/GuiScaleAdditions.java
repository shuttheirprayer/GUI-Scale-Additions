package com.misanthropy.gui_scale_additions;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod("gui_scale_additions")
public class GuiScaleAdditions {
    public GuiScaleAdditions() {
        if (FMLEnvironment.dist.isClient()) Client.init();
    }
}
