package com.groupseventeen.designpattern.Items.custom.books;

import com.groupseventeen.designpattern.Items.ItemCreator;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LightBookItem extends Item implements BookInterface{


    public LightBookItem(Properties properties) {
        super(properties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        getItems(level, player, hand);
        return super.use(level, player, hand);
    }
    public void getItems(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            ArrayList<Item> b = new ArrayList<>();
            b.add((Items.IRON_BOOTS));
            b.add(Items.IRON_LEGGINGS);
            b.add(Items.IRON_CHESTPLATE);
            b.add(Items.IRON_HELMET);
            b.add(ItemCreator.SWORD_OF_JUSTICE.get());

            int positionArmor = 36;
            player.getInventory().removeItem(player.getItemInHand(hand));
            for (Item a : b) {
                player.getInventory().add(positionArmor, new ItemStack(a));
                if (positionArmor == 39) {
                    positionArmor = 0;
                }
                positionArmor++;
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.literal("Press RIGHT CLICK to get Dark Wizard Set").withStyle(ChatFormatting.DARK_PURPLE));
        super.appendHoverText(itemStack, level, components, flag);
    }
}
