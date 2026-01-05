package com.liuxss.lxdf;

import com.liuxss.lxdf.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(LXDF.MOD_ID)
public class LXDF {

    public static final String MOD_ID = "lxdf";
    private static final Logger LOGGER = LogManager.getLogger();

    public LXDF() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::setup);
        modBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);

        ModItems.register(modBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Código común (cliente + servidor)
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // Código solo del cliente (GUIs, renderers, etc.)
    }
}