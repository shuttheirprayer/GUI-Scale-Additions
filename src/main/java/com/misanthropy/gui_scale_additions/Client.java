package com.misanthropy.gui_scale_additions;

import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;

public final class Client {
    public static final OptionInstance<Integer> FINE = new OptionInstance<>("options.guiScale", OptionInstance.noTooltip(),
            (c, v) -> Options.genericValueLabel(c, label(v)), new OptionInstance.IntRange(0, 80), 0, v -> {});
    private static int applied;

    public static Component label(int v) {
        return v == 0 ? Component.translatable("options.guiScale.auto") : Component.literal(Math.max(v, 5) / 10.0 + "x");
    }

    public static double scale(Minecraft mc, double vanilla) {
        int v = mc.options.guiScale().get();
        if (vanilla != mc.getWindow().calculateScale(v, mc.isEnforceUnicode())) return vanilla;
        applied = FINE.get();
        return applied == 0 ? mc.getWindow().calculateScale(0, mc.isEnforceUnicode()) : Math.max(applied, 5) / 10.0;
    }

    static void init() {
        MinecraftForge.EVENT_BUS.addListener((ScreenEvent.MouseButtonReleased.Post e) -> {
            if (FINE.get() != applied) Minecraft.getInstance().resizeDisplay();
        });
        if (ModList.get().isLoaded("embeddium")) EmbeddiumCompat.init();
    }
}
