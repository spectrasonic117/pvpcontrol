package com.spectrasonic.pvpcontrol;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PVPControl implements CommandExecutor {

    private boolean pvpEnabled = true;
    private final Main plugin;

    // Constructor que recibe la instancia del plugin principal
    public PVPControl(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("pvpcontrol")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    pvpEnabled = true;
                    Bukkit.getWorlds().forEach(world -> world.setPVP(true));
                    sender.sendMessage(ChatColor.GOLD + "[PVPControl] " + ChatColor.GREEN + "PvP " + ChatColor.GREEN + "Activado");
                } else if (args[0].equalsIgnoreCase("off")) {
                    pvpEnabled = false;
                    Bukkit.getWorlds().forEach(world -> world.setPVP(false));
                    sender.sendMessage(ChatColor.GOLD + "[PVPControl] " + ChatColor.RESET + "PvP " + ChatColor.RED + "Desactivado");
                } else if (args[0].equalsIgnoreCase("version")) {
                    pvpEnabled = false;
                    Bukkit.getWorlds().forEach(world -> world.setPVP(false));
                    sender.sendMessage(ChatColor.GOLD + "[PVPControl] " + ChatColor.RESET + "Version: " + ChatColor.GOLD + "1.5");
                    sender.sendMessage(ChatColor.GOLD + "[PVPControl] " + ChatColor.RESET + "Developed by " + ChatColor.RED + "Spectrasonic");
                } else {
                    sender.sendMessage(ChatColor.YELLOW + "Uso: /pvp <on|off>");
                }
                return true;
            } else {
                sender.sendMessage(ChatColor.YELLOW + "Uso: /pvp <on|off>");
            }
        }
        return false;
    }
}
