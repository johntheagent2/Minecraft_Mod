package com.groupseventeen.designpattern.Items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreativeModTab {
    public static final CreativeModeTab TAB_HOLY_ITEMS = new CreativeModeTab("holytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Sword.SWORD_OF_JUSTICE.get());
        }
    };
}
