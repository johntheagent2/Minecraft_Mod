package com.groupseventeen.designpattern.Items.custom.books;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface BookInterface {
    public void getItems(Level level, Player player, InteractionHand hand);
}
