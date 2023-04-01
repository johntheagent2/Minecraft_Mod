package com.groupseventeen.designpattern.Items.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DarkBookItem extends Item {
    public DarkBookItem(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){

        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            output(player);
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            components.add(Component.literal("Press RIGHT CLICK for a random number").withStyle(ChatFormatting.AQUA));
        }else{
            components.add(Component.literal("Press SHIFT for more INFO").withStyle(ChatFormatting.DARK_RED, ChatFormatting.BOLD));
        }
        super.appendHoverText(itemStack, level, components, flag);
    }

    private void output(Player player){
        player.sendSystemMessage(Component.literal("Your Number: " + getRandomNumber()));
    }

    private int getRandomNumber(){
        return (int) (Math.random() * 10);
    }
}
