package dev.thebjoredcraft.fightalert;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FightAlert extends JavaPlugin {
    public static FightAlert instance;

    public static FightAlert getInstance() {
        return instance;
    }
    @Override
    public void onLoad() {
        instance = this;

    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EventManager(), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
