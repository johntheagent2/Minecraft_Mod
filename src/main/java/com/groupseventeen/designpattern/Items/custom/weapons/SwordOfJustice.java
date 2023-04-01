package com.groupseventeen.designpattern.Items.custom.weapons;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class SwordOfJustice extends Item {
    public SwordOfJustice(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            useLightning(level, player);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemStack);
        }
        return new InteractionResultHolder<>(InteractionResult.FAIL, itemStack);

    }

    public void isItemEquipped( ItemStack itemStack, Player player){
        if((player.getMainHandItem().getItem()).equals(itemStack.getItem())){
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60));
        }

    }

    public void useLightning(Level level, Player player){
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40000));
        player.getCooldowns().addCooldown(this, 100);
    }
}
