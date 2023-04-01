package com.groupseventeen.designpattern.Items;

import com.groupseventeen.designpattern.DesignPattern;
import com.groupseventeen.designpattern.Items.custom.books.DarkBookItem;
import com.groupseventeen.designpattern.Items.custom.books.LightBookItem;
import com.groupseventeen.designpattern.Items.custom.weapons.DarkSpearQueen;
import com.groupseventeen.designpattern.Items.custom.weapons.SwordOfJustice;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemCreator {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DesignPattern.MODID);

    public static final RegistryObject<Item> SWORD_OF_JUSTICE = ITEMS.register("sword_of_justice",
            () -> new SwordOfJustice(new Item.Properties().tab(CreativeModCustomItems.TAB_HOLY_ITEMS).stacksTo(1)));
    public static final RegistryObject<Item> RED_DIAMOND = ITEMS.register("red_diamond",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> DARK_BOOK = ITEMS.register("dark_book",
            () -> new DarkBookItem(new Item.Properties().tab(CreativeModCustomItems.TAB_HOLY_ITEMS).stacksTo(1)));

    public static final RegistryObject<Item> LIGHT_BOOK = ITEMS.register("light_book",
            () -> new LightBookItem(new Item.Properties().tab(CreativeModCustomItems.TAB_HOLY_ITEMS).stacksTo(1)));

    public static final RegistryObject<Item> SPEAR_DARK_QUEEN = ITEMS.register("spear_dark_queen",
            () -> new DarkSpearQueen(new Item.Properties().tab(CreativeModCustomItems.TAB_HOLY_ITEMS).stacksTo(1)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
