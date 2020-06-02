package me.kr_gaming2005.staffmode.staffmodemain.Data;

import me.kr_gaming2005.staffmode.staffmodemain.ChatUtill;
import me.kr_gaming2005.staffmode.staffmodemain.CustomFiles.MessagesFile;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaveInv {

    public static void Save(Player p){

        File file = new File("plugins//StaffMode//Players//");
        if(!file.exists()){
            file.mkdir();
        }
        ArrayList<ItemStack> list = new ArrayList<>();
        File file1 = new File("plugins//StaffMode//Players//" + p.getUniqueId().toString() + ".yml");
        if(!file1.exists()){
            try{
                file1.createNewFile();
            }catch (IOException e){
                Bukkit.broadcast(ChatUtill.format(MessagesFile.get().getString("prefix") + "&4&lCould not save inventory of " + p.getName()), "staffmode.admin");
                p.sendMessage(ChatUtill.format("&4&lCould not save inventory"));
            }
                YamlConfiguration inv = YamlConfiguration.loadConfiguration(file1);
                ItemStack[] contents = p.getInventory().getContents();

                for (int i = 0; i < contents.length; i++){
                    ItemStack item = contents[i];
                        list.add(item);
                    inv.set("inventory", list);
                    try{
                        inv.save(file1);
                    }catch (IOException e){
                        Bukkit.broadcast(ChatUtill.format(MessagesFile.get().getString("prefix") + "&4&lFailed to save " + p.getName() + "'s inventory file!"), "staffmode.admin");
                        p.sendMessage(ChatUtill.format("&4&lFailed to save your inventory contact Admin for support!"));
                    }


                }

        }






    }


}
