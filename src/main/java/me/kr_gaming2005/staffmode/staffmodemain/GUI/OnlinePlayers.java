package me.kr_gaming2005.staffmode.staffmodemain.GUI;

import me.kr_gaming2005.staffmode.staffmodemain.ChatUtill;
import me.kr_gaming2005.staffmode.staffmodemain.commands.StaffModeCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class OnlinePlayers {

    public static void OpenPlayerList(Player p){
        ArrayList<Player> player_list = new ArrayList<>(getServer().getOnlinePlayers());
        Inventory PlayerList = Bukkit.createInventory(null, InventoryType.CHEST, ChatUtill.format("&e&lOnline Players"));
        for (int i = 0; i < player_list.size(); i++){
            ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta Skull = (SkullMeta) playerhead.getItemMeta();
            Skull.setOwningPlayer(player_list.get(i));
            Skull.setDisplayName(ChatUtill.format("&3&l" + player_list.get(i).getDisplayName()));
            playerhead.setItemMeta(Skull);
            PlayerList.addItem(playerhead);

        }
            p.openInventory(PlayerList);


    }


}
