package com.WokFriedE.BestPlugin.commands;

import com.WokFriedE.BestPlugin.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MoreCommands implements CommandExecutor { //need to implement commandExecutor
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)) { //cehcks player
            sender.sendMessage("Only players can use that");
            return true;
        }

        Player player = (Player) sender; //gets the sender and converts it to a player object

        if (cmd.getName().equalsIgnoreCase("givewand")){
            player.getInventory().addItem(ItemManager.funnystick);//command to add the custom item
        }

        return true;
    }
}
