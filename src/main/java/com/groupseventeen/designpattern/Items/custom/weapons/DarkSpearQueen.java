package com.groupseventeen.designpattern.Items.custom.weapons;

import com.groupseventeen.designpattern.Items.ItemCreator;
import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
//        isItemEquipped(itemStack, player);
        if (!level.isClientSide) {
            useFireBall(level, player);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemStack);
        }
        return new InteractionResultHolder<>(InteractionResult.FAIL, itemStack);

    }

    public void isItemEquipped( ItemStack itemStack, Player player){
        if((player.getMainHandItem().getItem()).equals(itemStack.getItem())){
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60));
        }

    }

    public void useFireBall(Level level, Player player){
        Vec3 vec3 = player.getViewVector(1.0f);

        Random random = new Random();

        LargeFireball largeFireball = new LargeFireball(level, player, vec3.x(), vec3.y(), vec3.z(), 3);
        largeFireball.shootFromRotation(player, player.getXRot() - 3, player.getYRot(), 0.0F, 3.0F, 0.0F);

        level.addFreshEntity(largeFireball);
        level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.GHAST_SHOOT, SoundSource.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

        player.getCooldowns().addCooldown(this, 20);
    }
}
