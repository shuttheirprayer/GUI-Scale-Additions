package com.misanthropy.gui_scale_additions;

import me.jellysquid.mods.sodium.client.gui.SodiumGameOptionPages;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.control.SliderControl;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.embeddedt.embeddium.api.OptionGroupConstructionEvent;
import org.embeddedt.embeddium.client.gui.options.StandardOptions;

final class EmbeddiumCompat {
    static void init() {
        OptionGroupConstructionEvent.BUS.addListener(e -> {
            if (!e.getId().matches(StandardOptions.Group.WINDOW)) return;
            e.getOptions().removeIf(o -> o.getId().matches(StandardOptions.Option.GUI_SCALE));
            e.getOptions().add(0, OptionImpl.createBuilder(int.class, SodiumGameOptionPages.getVanillaOpts())
                    .setId(new ResourceLocation("gui_scale_additions", "gui_scale"))
                    .setName(Component.translatable("options.guiScale"))
                    .setTooltip(Component.translatable("sodium.options.gui_scale.tooltip"))
                    .setControl(o -> new SliderControl(o, 0, 80, 1, Client::label))
                    .setBinding((opts, v) -> Client.FINE.set(v), opts -> Client.FINE.get())
                    .build());
        });
    }
}
