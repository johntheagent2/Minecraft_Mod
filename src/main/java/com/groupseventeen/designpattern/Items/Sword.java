package com.groupseventeen.designpattern.Items;

import com.groupseventeen.designpattern.DesignPattern;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sword {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DesignPattern.MODID);
    public static final RegistryObject<Item> SWORD_OF_JUSTICE = ITEMS.register("sword_of_justice",
            () -> new Item(new Item.Properties().tab(CreativeModTab.TAB_HOLY_ITEMS)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
