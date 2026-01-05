package com.liuxss.lxdf.events;

/*import com.liuxss.lxdf.init.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;*/

//@Mod.EventBusSubscriber(modid = "lxdf", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
      /*@SubscribeEvent
        public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        PlayerEntity player = event.getPlayer();
        ItemStack stack = event.getItemStack();

        if (stack.getItem() == ModItems.EMPTY_BOTTLE.get()) {
            if (world.getFluidState(pos).is(FluidTags.WATER)) {
                event.setCanceled(true);
                if (!world.isClientSide) {
                    world.playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.BOTTLE_FILL,
                            SoundCategory.NEUTRAL, 1.0f, 1.0f
                    );
                    ItemStack fillBottle = new ItemStack(ModItems.WATER_BOTTLE.get());
                    player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                    if (!player.abilities.instabuild) {
                        stack.shrink(1);
                    }
                    if (stack.isEmpty()) {
                        player.setItemInHand(event.getHand(), fillBottle);
                    } else {
                        if (!player.inventory.add(fillBottle)) {
                            player.drop(fillBottle, false);
                        }
                    }
                }
            }
        }
    }*/
}
