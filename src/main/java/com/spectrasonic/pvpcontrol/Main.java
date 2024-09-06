package com.spectrasonic.pvpcontrol;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private PVPControl pvpControl;

    @Override
    public void onEnable() {
        // Crear una instancia de la clase PVPControl
        pvpControl = new PVPControl(this);

        // Registrar el comando /pvp
        getCommand("pvpcontrol").setExecutor(pvpControl);

        // Mensaje en color verde cuando el plugin se activa
        getServer().getConsoleSender().sendMessage("===============================");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "Spectrasonic Plugins");
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "[ PVPControl ] " + ChatColor.GREEN + "Plugin Activado");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage("===============================");
    }

    @Override
    public void onDisable() {
        // Mensaje en color rojo cuando el plugin se desactiva
        getServer().getConsoleSender().sendMessage("===============================");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "[ PVPControl ] " + ChatColor.RED + "Plugin Desactivado");
        getServer().getConsoleSender().sendMessage(" ");
        getServer().getConsoleSender().sendMessage("===============================");
    }
}
