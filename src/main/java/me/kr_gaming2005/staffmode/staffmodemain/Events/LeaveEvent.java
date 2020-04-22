package me.kr_gaming2005.staffmode.staffmodemain.Events;

import me.kr_gaming2005.staffmode.staffmodemain.commands.StaffModeCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if(StaffModeCommand.Staffmode.contains(p.getUniqueId().toString())){
           p.performCommand("staffmode");

        }

    }


}
