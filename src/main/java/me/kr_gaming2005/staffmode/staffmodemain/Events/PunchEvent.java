package me.kr_gaming2005.staffmode.staffmodemain.Events;

import me.kr_gaming2005.staffmode.staffmodemain.ChatUtill;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PunchEvent implements Listener {
    @EventHandler
    public void onPunch(EntityDamageByEntityEvent e){

         if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
          Player whoWasHit = (Player) e.getEntity();
          Player whoHit = (Player) e.getDamager();

          if(whoHit.getInventory().getItemInMainHand().equals(Material.DIAMOND_AXE) && whoHit.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtill.format("&4&lBan Hammer"))){
              Bukkit.dispatchCommand(whoHit, "punish " + whoWasHit.getName());
          }
         }
    }



}
