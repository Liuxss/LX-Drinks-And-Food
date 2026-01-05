package com.liuxss.lxdf.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModTabs {
    public static final ItemGroup LX_DRINKS_TAB = new ItemGroup("lxdf_drinks_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RED_WINE.get());
        }
    };

    public static final ItemGroup LX_FOOD_TAB = new ItemGroup("lxdf_food_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GRAPES.get());
        }
    };
}
