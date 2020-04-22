package me.kr_gaming2005.staffmode.staffmodemain.Events;

import de.myzelyam.api.vanish.VanishAPI;
import me.kr_gaming2005.staffmode.staffmodemain.ChatUtill;
import me.kr_gaming2005.staffmode.staffmodemain.commands.StaffModeCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getServer;

public class ItemClick implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action action = e.getAction();
        if (action.equals(Action.RIGHT_CLICK_AIR)) {
            if (StaffModeCommand.Staffmode.contains(p.getUniqueId().toString())) {
                //Vanish Toggle
                if (p.getInventory().getItemInMainHand().getType() == Material.LIME_DYE && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatUtill.format("&aVanish Toggle"))) {
                    VanishAPI.showPlayer(p);

                    //VanishToggle2
                    ItemStack VanishToggle2 = new ItemStack(Material.GRAY_DYE);
                    ItemMeta VTM = VanishToggle2.getItemMeta();
                    VTM.setDisplayName(ChatUtill.format("&7Vanish Toggle"));
                    ArrayList<String> VTL = new ArrayList<>();
                    VTL.add(ChatUtill.format("&aToggle Vanish!"));
                    VTM.setLore(VTL);
                    VanishToggle2.setItemMeta(VTM);
                    p.getInventory().setItem(8, VanishToggle2);

                } else {
                    if (StaffModeCommand.Staffmode.contains(p.getUniqueId().toString())) {
                        //Vanish Toggle
                        if (p.getInventory().getItemInMainHand().getType() == Material.GRAY_DYE && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatUtill.format("&7Vanish Toggle"))) {
                            VanishAPI.hidePlayer(p);

                            //VanishToggle1
                            ItemStack VanishToggle1 = new ItemStack(Material.LIME_DYE);
                            ItemMeta VTM = VanishToggle1.getItemMeta();
                            VTM.setDisplayName(ChatUtill.format("&a&lVanish Toggle"));
                            ArrayList<String> VTL = new ArrayList<>();
                            VTL.add(ChatUtill.format("&aToggle Vanish!"));
                            VTM.setLore(VTL);
                            VanishToggle1.setItemMeta(VTM);
                            p.getInventory().setItem(8, VanishToggle1);


                        }
                    } else {
                        if (action.equals(Action.RIGHT_CLICK_AIR)) {
                            if (p.getInventory().getItemInMainHand().getType() == Material.ENDER_EYE &&
                                    p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("&d&lRandom TP")) {
                                getServer().dispatchCommand(getServer().getConsoleSender(), "minecraft:tp " + p.getName() + " @r");

                            }
                        }

                    }
                }
            }
        }


    }

    public void onProjectile(ProjectileLaunchEvent e){
        if(e.getEntity().getType().equals(Material.ENDER_EYE)){
            e.setCancelled(true);
        }
    }
}

