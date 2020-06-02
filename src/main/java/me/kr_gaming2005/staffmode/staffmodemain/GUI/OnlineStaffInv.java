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

public class OnlineStaffInv {

    public static void OpenStaffList(Player p){

        Inventory OnlineStaff = Bukkit.createInventory(null, InventoryType.CHEST, ChatUtill.format("&e&lHidden Staff"));

        for (int i = 0;i < StaffModeCommand.Staffmode.size(); i++){
            ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta Skull = (SkullMeta) playerhead.getItemMeta();
            Skull.setOwningPlayer(StaffModeCommand.Staffmode.get(i));
            Skull.setDisplayName(ChatUtill.format("&3&l" + StaffModeCommand.Staffmode.get(i).getDisplayName()));
            playerhead.setItemMeta(Skull);
            OnlineStaff.addItem(playerhead);
        }
        p.openInventory(OnlineStaff);
    }


}
