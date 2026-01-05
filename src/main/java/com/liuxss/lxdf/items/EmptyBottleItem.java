package com.liuxss.lxdf.items;

import com.liuxss.lxdf.init.ModItems;
import com.liuxss.lxdf.init.ModTabs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EmptyBottleItem extends Item {
    public EmptyBottleItem() {
        super(new Item.Properties()
                .tab(ModTabs.LX_DRINKS_TAB)
                .stacksTo(16)
        );
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        // 1. Tiramos el rayo para ver si hay agua
        RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.SOURCE_ONLY);

        if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
            return ActionResult.pass(itemstack);
        } else {
            if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
                BlockPos blockpos = ((BlockRayTraceResult)raytraceresult).getBlockPos();

                // 2. Comprobamos si el jugador puede interactuar con ese bloque
                if (!worldIn.mayInteract(playerIn, blockpos)) {
                    return ActionResult.pass(itemstack);
                }

                // 3. ¿Es agua?
                if (worldIn.getFluidState(blockpos).is(FluidTags.WATER)) {
                    // Sonido oficial
                    worldIn.playSound(playerIn, playerIn.getX(), playerIn.getY(), playerIn.getZ(),
                            SoundEvents.BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);

                    // 4. Transformación (Usamos la herramienta oficial de Minecraft: DrinkHelper)
                    return ActionResult.sidedSuccess(DrinkHelper.createFilledResult(itemstack, playerIn,
                            new ItemStack(ModItems.WATER_BOTTLE.get())), worldIn.isClientSide());
                }
            }
            return ActionResult.pass(itemstack);
        }
    }
}
