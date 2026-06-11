package com.autoenchant;

import org.bukkit.plugin.java.JavaPlugin;

public class AutoEnchant extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EnchantListener(), this);
        getLogger().info("AutoEnchant enabled! Pickaxes and axes will get Efficiency 3 + Fortune 1.");
    }

    @Override
    public void onDisable() {
        getLogger().info("AutoEnchant disabled.");
    }
}
