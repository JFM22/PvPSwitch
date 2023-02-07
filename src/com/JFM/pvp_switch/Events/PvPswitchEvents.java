package com.JFM.pvp_switch.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class PvPswitchEvents implements Listener {
    static boolean PvPEnabled = false;
    static Objective objective;
    public static void enablePVP(){

        PvPEnabled = true;
        updateScore();}

    public static void disablePVP(){

        PvPEnabled = false;
        updateScore();}
    public static void updateScore(){
        if (PvPEnabled){objective.setDisplayName(ChatColor.RED + "PvP: " + ChatColor.DARK_RED + "ON");}
        else{objective.setDisplayName(ChatColor.RED + "PvP: "+ ChatColor.GREEN +"OFF");}
    }
    public static void createScoreboard(Player player){
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        objective = board.registerNewObjective("PVP","dummy");
        updateScore();
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score score = objective.getScore(" ");
        score.setScore(1);
        player.setScoreboard(board);
    }

    @EventHandler
    public static void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event){
        if (!PvPEnabled && event.getEntity() instanceof Player && event.getDamager() instanceof Player){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent p){
        createScoreboard(p.getPlayer());
    }
}
