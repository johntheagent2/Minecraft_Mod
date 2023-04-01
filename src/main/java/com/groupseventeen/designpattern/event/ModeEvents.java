package com.groupseventeen.designpattern.event;

import com.groupseventeen.designpattern.DesignPattern;
import net.minecraftforge.fml.common.Mod;

public class ModeEvents {
    @Mod.EventBusSubscriber(modid = DesignPattern.MODID)
    public static class ForgeEvents{

    }

    @Mod.EventBusSubscriber(modid = DesignPattern.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents{

    }
}
