package com.liuxss.lxdf.items;

import com.liuxss.lxdf.init.ModTabs;
import net.minecraft.item.*;

public class GrapesItem extends Item {

    public GrapesItem() {
        super(new Item.Properties()
                .tab(ModTabs.LX_FOOD_TAB)
                .stacksTo(64)
                .food(new Food.Builder()
                        .nutrition(6)
                        .saturationMod(6)
                        .build()
                )
        );
    }
}
