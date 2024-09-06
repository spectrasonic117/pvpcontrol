package com.spectrasonic.pvpcontrol;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private final String divider = "===============================";
	private final String prefix = ChatColor.RED + "[" + ChatColor.GOLD + "PVPControl" + ChatColor.RED + "] " + ChatColor.RESET;
	
    private PVPControl pvpControl;

    @Override
    public void onEnable() {
        pvpControl = new PVPControl(this);

        getCommand("pvpcontrol").setExecutor(pvpControl);

        getServer().getConsoleSender().sendMessage(divider);
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Spectrasonic Plugins");
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.GREEN + "Plugin Activado");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(divider);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(divider);
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.RED + "Plugin Desactivado");
        getServer().getConsoleSender().sendMessage(" ");
		getServer().getConsoleSender().sendMessage(divider);
    }
}
