package me.kr_gaming2005.staffmode.staffmodemain.Events;

import de.myzelyam.api.vanish.VanishAPI;
import me.kr_gaming2005.staffmode.staffmodemain.ChatUtill;
import me.kr_gaming2005.staffmode.staffmodemain.CustomFiles.MessagesFile;
import me.kr_gaming2005.staffmode.staffmodemain.GUI.OnlinePlayers;
import me.kr_gaming2005.staffmode.staffmodemain.GUI.OnlineStaffInv;
import me.kr_gaming2005.staffmode.staffmodemain.commands.StaffModeCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemClick implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action action = e.getAction();
        if (action.equals(Action.RIGHT_CLICK_AIR)) {
            if (StaffModeCommand.Staffmode.contains(p)) {
                //Vanish Toggle
                if (p.getInventory().getItemInMainHand().getType() == Material.LIME_DYE && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatUtill.format("&a&lVanish Toggle"))) {
                    VanishAPI.showPlayer(p);

                    //VanishToggle2
                    ItemStack VanishToggle2 = new ItemStack(Material.GRAY_DYE);
                    ItemMeta VTM = VanishToggle2.getItemMeta();
                    VTM.setDisplayName(ChatUtill.format("&7&lVanish Toggle"));
                    ArrayList<String> VTL = new ArrayList<>();
                    VTL.add(ChatUtill.format("&aToggle Vanish!"));
                    VTM.setLore(VTL);
                    VanishToggle2.setItemMeta(VTM);
                    p.getInventory().setItem(8, VanishToggle2);

                } else {
                    if (StaffModeCommand.Staffmode.contains(p)) {
                        //Vanish Toggle
                        if (p.getInventory().getItemInMainHand().getType() == Material.GRAY_DYE && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatUtill.format("&7&lVanish Toggle"))) {
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
                            if (p.getInventory().getItemInMainHand().getType() == Material.ENDER_EYE && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtill.format("&d&lRandom TP"))) {
                                Random r = new Random();
                                int rpn = r.nextInt(Bukkit.getServer().getOnlinePlayers().size());
                                Object players = new ArrayList();
                                ((List)players).addAll(Bukkit.getServer().getOnlinePlayers());
                                ((List)players).remove(e.getPlayer());
                                if(rpn < 2){
                                    p.sendMessage(ChatUtill.format(MessagesFile.get().getString("prefix") + "&cNot enough players online!"));
                                }else {
                                    e.getPlayer().teleport((Entity) ((List) players).get(rpn));
                                    e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You have been teleported to &c" + ((Player) ((List) players).get(rpn)).getName() + "&7."));
                                }

                                }else {
                                if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtill.format("&e&lHiddenStaff"))){
                                    OnlineStaffInv.OpenStaffList(p);
                            }else {
                                    if(p.getInventory().getItemInMainHand().getType().equals(Material.CHEST) && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtill.format("&e&lOnline Players"))){
                                        OnlinePlayers.OpenPlayerList(p);
                                    }

                                }

                            }

                            }
                    }
                }
            }
        }
    }


}

