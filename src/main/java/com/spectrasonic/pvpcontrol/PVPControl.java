package com.spectrasonic.pvpcontrol;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PVPControl implements CommandExecutor {

	private final String prefix = ChatColor.RED + "[" + ChatColor.GOLD + "PVPControl" + ChatColor.RED + "] " + ChatColor.RESET;
    private boolean pvpEnabled;
	private final Main plugin;
	private final String version = "1.7";

    public PVPControl(Main plugin) {
        this.plugin = plugin;
    }
    @Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player && !sender.isOp()) {
			sender.sendMessage(prefix + ChatColor.RED + "No tienes permisos para ejecutar este comando");
			return true;
		}

        if (command.getName().equalsIgnoreCase("pvpcontrol")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    pvpEnabled = true;
                    Bukkit.getWorlds().forEach(world -> world.setPVP(true));
                    sender.sendMessage(prefix + "PvP " + ChatColor.GREEN + "Activado");
                } else if (args[0].equalsIgnoreCase("off")) {
                    pvpEnabled = false;
                    Bukkit.getWorlds().forEach(world -> world.setPVP(false));
                    sender.sendMessage(prefix + "PvP " + ChatColor.RED + "Desactivado");
                } else if (args[0].equalsIgnoreCase("version")) {
                    pvpEnabled = false;
                    sender.sendMessage(prefix + "Version: " + ChatColor.GOLD + version);
                    sender.sendMessage(prefix + "Developed by " + ChatColor.RED + "Spectrasonic");
                } else {
                    sender.sendMessage(prefix + ChatColor.YELLOW + "Uso: /pvp <on|off>");
                }
                return true;
            } else {
                sender.sendMessage(prefix + ChatColor.YELLOW + "Uso: /pvp <on|off>");
            }
        }
        return false;
    }
}
