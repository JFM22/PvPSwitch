package com.JFM.pvp_switch.PVPswitch_Commands;

import com.JFM.pvp_switch.Events.PvPswitchEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class PvPswitchCommands implements CommandExecutor {
    public void playSound(){
        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 0);
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {return true;}
        Player player = (Player) sender; //cast

        if (cmd.getName().equalsIgnoreCase("pvp") && player.isOp()) {
            if (args.length == 1) {
                try {
                    if (args[0].equals("ON")) {
                        PvPswitchEvents.enablePVP();
                        playSound();
                        getServer().dispatchCommand(getServer().getConsoleSender(), "tellraw @a [\"\",{\"text\":\"\\u2620 \"},{\"text\":\"PvP\",\"color\":\"dark_red\"},{\"text\":\" has been \"},{\"text\":\"enabled\",\"color\":\"red\"}]\n");
                        return true;
                    } else if (args[0].equals("OFF")) {
                        PvPswitchEvents.disablePVP();
                        playSound();
                        getServer().dispatchCommand(getServer().getConsoleSender(), "tellraw @a [\"\",{\"text\":\"\\u2620 \"},{\"text\":\"PvP\",\"color\":\"dark_red\"},{\"text\":\" has been \"},{\"text\":\"disabled\",\"color\":\"dark_green\"}]\n");
                        return true;
                    }
                } catch (IllegalArgumentException e) {
                    player.sendMessage(ChatColor.RED + "Illegal Argument Exception");
                }
            }
            player.sendMessage(ChatColor.RED + "No valid arguments, try /pvp ON or /pvp OFF");

        }
        return true;
    }
}
