package com.gmail.zorioux.ranksmanager;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class GiveTitleEvent implements Listener {
    private LuckPerms lp = LuckPermsProvider.get();
    @EventHandler
    public void onEvent(ServerConnectEvent e) {
        String name = e.getPlayer().getDisplayName();
        User user = lp.getUserManager().getUser(name);
        if (user != null) {
            String group = user.getPrimaryGroup();
            if (group.equalsIgnoreCase("vip") || group.equalsIgnoreCase("vip+")
                    || group.equalsIgnoreCase("vip++")) {
                Group groupX = lp.getGroupManager().getGroup(group);
                if (groupX != null) {
                    if (groupX.getWeight().isPresent()) {
                        int weight = groupX.getWeight().getAsInt();
                        if (weight == 30) {
                            RanksManager.getplugin().getProxy().getPluginManager().
                                    dispatchCommand(RanksManager.getplugin().getProxy().getConsole(), "/chatrank " + name + " vip");

                        } else if (weight == 60) {
                            RanksManager.getplugin().getProxy().getPluginManager().
                                    dispatchCommand(RanksManager.getplugin().getProxy().getConsole(), "/chatrank " + name + " vip+");

                        } else if (weight == 90) {
                            RanksManager.getplugin().getProxy().getPluginManager().
                                    dispatchCommand(RanksManager.getplugin().getProxy().getConsole(), "/chatrank " + name + " vip++");
                        }
                    }
                }
            }
        }
    }
}
