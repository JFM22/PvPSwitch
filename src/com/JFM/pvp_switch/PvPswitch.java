package com.JFM.pvp_switch;
import com.JFM.pvp_switch.Events.PvPswitchEvents;
import com.JFM.pvp_switch.PVPswitch_Commands.PvPswitchCommands;
import com.JFM.pvp_switch.PVPswitch_Commands.PvPswitchTabCompletion;
import org.bukkit.plugin.java.JavaPlugin;
public class PvPswitch extends JavaPlugin {

    @Override
    public void onEnable(){
        PvPswitchCommands commands = new PvPswitchCommands();
        getServer().getPluginManager().registerEvents(new PvPswitchEvents(), this);
        getCommand("pvp").setExecutor(commands);
        getCommand("pvp").setTabCompleter(new PvPswitchTabCompletion());
        getServer().getConsoleSender().sendMessage("[pvp_switch]: Plugin is enabled!");
    }

    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage("[pvp_switch]: Plugin is disabled!");
    }
}
