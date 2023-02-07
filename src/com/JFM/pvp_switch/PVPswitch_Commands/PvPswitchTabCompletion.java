package com.JFM.pvp_switch.PVPswitch_Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.ArrayList;
import java.util.List;

public class PvPswitchTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args){
        List<String> list = new ArrayList<>();
        list.add("ON");
        list.add("OFF");
        if (args.length == 1){
            return list;
        }
        return null;
    }
}
