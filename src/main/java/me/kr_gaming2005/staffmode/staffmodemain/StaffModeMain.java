package me.kr_gaming2005.staffmode.staffmodemain;

import me.kr_gaming2005.staffmode.staffmodemain.CustomFiles.MessagesFile;
import me.kr_gaming2005.staffmode.staffmodemain.Events.ItemClick;
import me.kr_gaming2005.staffmode.staffmodemain.Events.LeaveEvent;
import me.kr_gaming2005.staffmode.staffmodemain.commands.StaffModeCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffModeMain extends JavaPlugin {

    @Override
    public void onEnable() {
        //Config
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
        this.saveConfig();

        //Messages
        MessagesFile.setup();
        MessagesFile.get().addDefault("prefix", "&3&lStaffMode ");
        MessagesFile.get().options().copyDefaults(true);


        //Message
        ChatUtill.format(MessagesFile.get().getString("prefix") + "&aEnabled!");


        //Commands
        getCommand("staffmode").setExecutor(new StaffModeCommand());

        //Listeners
        Bukkit.getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ItemClick(), this);
    }

    @Override
    public void onDisable() {

        //Message
        ChatUtill.format(MessagesFile.get().getString("prefix") + "&cDisabled!");
    }
}
