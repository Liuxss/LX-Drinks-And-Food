package com.liuxss.lxdf.items.base;

import com.liuxss.lxdf.init.ModItems;
import com.liuxss.lxdf.init.ModTabs;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public abstract class DrinkItem extends Item {

    public DrinkItem(int nutrition, float saturation, int e_duration, int e_intensity) {
        super(new Item.Properties()
                .tab(ModTabs.LX_DRINKS_TAB)
                .stacksTo(16)
                .food(new Food.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .effect(() -> new EffectInstance(Effects.CONFUSION, e_duration, e_intensity), 1.0f)
                        .alwaysEat()
                        .build()
                )
        );
    }

    public DrinkItem(int nutrition, float saturation) {
        super(new Item.Properties()
                .tab(ModTabs.LX_DRINKS_TAB)
                .stacksTo(16)
                .food(new Food.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .alwaysEat()
                        .build()
                )
        );
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemStack = super.finishUsingItem(stack, worldIn, entityLiving);

        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entityLiving;
            if (!player.abilities.instabuild) {
                ItemStack emptyBottle = new ItemStack(ModItems.EMPTY_BOTTLE.get());
                if (itemStack.isEmpty()) {
                    return emptyBottle;
                }
                if (!player.inventory.add(emptyBottle)) {
                    player.drop(emptyBottle, false);
                }
            }
        }
        return itemStack;
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
}