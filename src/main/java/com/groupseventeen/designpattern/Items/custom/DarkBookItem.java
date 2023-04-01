package com.groupseventeen.designpattern.Items.custom;

import com.groupseventeen.designpattern.Items.ItemCreator;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DarkBookItem extends Item {
    public DarkBookItem(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){



        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            output(player);
            ArrayList<Item> b = new ArrayList<>();
            b.add(Items.DIAMOND_BOOTS);
            b.add(Items.DIAMOND_LEGGINGS);
            b.add(Items.DIAMOND_CHESTPLATE);
            b.add(Items.DIAMOND_HELMET);
            b.add(ItemCreator.SWORD_OF_JUSTICE.get());

            int positionArmor = 36;
            for(Item a : b){
                player.getInventory().add(positionArmor, new ItemStack(a));
                if(positionArmor == 39){
                    positionArmor = 0;
                }
                positionArmor++;
            }
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
