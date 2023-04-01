package com.groupseventeen.designpattern.Items.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class DarkSpearQueen extends Item {

    public DarkSpearQueen(Item.Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        ItemStack itemStack = player.getItemInHand(hand);

        Vec3 vec3 = player.getViewVector(1.0f);

        Random random = new Random();

        if (!level.isClientSide) {
            LargeFireball largeFireball = new LargeFireball(level, player, vec3.x(), vec3.y(), vec3.z(), 5);
            largeFireball.shootFromRotation(player, player.getXRot() - 3, player.getYRot(), 0.0F, 3.0F, 0.0F);

            level.addFreshEntity(largeFireball);
            level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.GHAST_SHOOT, SoundSource.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

            player.getCooldowns().addCooldown(this, 20);

            if (!player.isCreative()) {
                itemStack.setDamageValue(itemStack.getDamageValue() + 1);
            }
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemStack);
        }
        return new InteractionResultHolder<>(InteractionResult.FAIL, itemStack);

    }
}
