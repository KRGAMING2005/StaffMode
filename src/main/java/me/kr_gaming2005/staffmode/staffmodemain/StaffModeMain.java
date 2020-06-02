package me.kr_gaming2005.staffmode.staffmodemain;

import me.kr_gaming2005.staffmode.staffmodemain.CustomFiles.MessagesFile;
import me.kr_gaming2005.staffmode.staffmodemain.Events.InventoryClick;
import me.kr_gaming2005.staffmode.staffmodemain.Events.ItemClick;
import me.kr_gaming2005.staffmode.staffmodemain.Events.LeaveEvent;
import me.kr_gaming2005.staffmode.staffmodemain.commands.StaffModeCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;

public final class StaffModeMain extends JavaPlugin {

    public static Connection connection;
    public static String host, database, username, password;
    public static int port;

    @Override
    public void onEnable() {
        //Config
        this.getConfig().options().copyDefaults(true);
        this.getConfig().createSection("InStaffMode");

        this.saveDefaultConfig();

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
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(), this);
    }

    @Override
    public void onDisable() {

        //Message
        ChatUtill.format(MessagesFile.get().getString("prefix") + "&cDisabled!");
    }
}
