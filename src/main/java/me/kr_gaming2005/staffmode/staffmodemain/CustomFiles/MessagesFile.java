package me.kr_gaming2005.staffmode.staffmodemain.CustomFiles;

import me.kr_gaming2005.staffmode.staffmodemain.StaffModeMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessagesFile {

       private static StaffModeMain plugin = StaffModeMain.getPlugin(StaffModeMain.class);

    private static File file;
    private static FileConfiguration Messages;

    //Finds or generates file
    public static void setup(){
        if(!plugin.getDataFolder().exists()){
            plugin.getDataFolder().mkdir();
        }
        file = new File(plugin.getDataFolder(), "Messages.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){}
        }
        Messages = YamlConfiguration.loadConfiguration(file);
    }
    public static FileConfiguration get(){
        return Messages;
    }

    public static void save(){
        try {
            Messages.save(file);
        }catch (IOException e){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "--------------COULD NOT SAVE FILE--------------");}
    }
    public static void reload(){
        Messages = YamlConfiguration.loadConfiguration(file);
    }
}
