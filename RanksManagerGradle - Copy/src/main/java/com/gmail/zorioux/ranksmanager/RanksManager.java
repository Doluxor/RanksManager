package com.gmail.zorioux.ranksmanager;

import net.md_5.bungee.api.plugin.Plugin;

public final class RanksManager extends Plugin {

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this,new GiveTitleEvent());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getplugin() {
        Plugin plugin = new Plugin();
        return plugin;
    }
}
