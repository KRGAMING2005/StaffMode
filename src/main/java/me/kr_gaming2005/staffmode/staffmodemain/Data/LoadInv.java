package me.kr_gaming2005.staffmode.staffmodemain.Data;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.List;

public class LoadInv {

    public static void load(Player p){
        File file = new File("plugins//StaffMode//Players//" + p.getUniqueId().toString() + ".yml");

        if(file.exists()){
            YamlConfiguration inv = YamlConfiguration.loadConfiguration(file);
            p.getInventory().clear();
            ItemStack[] contents = p.getInventory().getContents();
            List<?> list = inv.getList("inventory");

            for (int i = 0; i < list.size(); i++){
                contents[i] = (ItemStack) list.get(i);
            }

            p.getInventory().setContents(contents);
            file.delete();
        }


    }



}
