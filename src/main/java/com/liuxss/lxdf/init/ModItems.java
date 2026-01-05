package com.liuxss.lxdf.init;

import com.liuxss.lxdf.LXDF;
import com.liuxss.lxdf.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LXDF.MOD_ID);

    public static final RegistryObject<Item> EMPTY_BOTTLE =
            ITEMS.register("empty_bottle", EmptyBottleItem::new);
    public static final RegistryObject<Item> WATER_BOTTLE =
            ITEMS.register("water_bottle", WaterBottleItem::new);
    public static final RegistryObject<Item> RED_WINE =
            ITEMS.register("red_wine", RedWineItem::new);
    public static final RegistryObject<Item> APPLE_JUICE =
            ITEMS.register("apple_juice", AppleJuiceItem::new);
    public static final RegistryObject<Item> ORANGE_JUICE =
            ITEMS.register("orange_juice", OrangeJuiceItem::new);
    public static final RegistryObject<Item> GRAPE_JUICE =
            ITEMS.register("grape_juice", GrapeJuiceItem::new);
    public static final RegistryObject<Item> GRAPES =
            ITEMS.register("grapes", GrapesItem::new);
    public static final RegistryObject<Item> STRAWBERRY =
            ITEMS.register("strawberry", StrawberryItem::new);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}