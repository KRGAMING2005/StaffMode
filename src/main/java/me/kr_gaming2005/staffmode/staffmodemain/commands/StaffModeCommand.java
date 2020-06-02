package me.kr_gaming2005.staffmode.staffmodemain.commands;

import me.kr_gaming2005.staffmode.staffmodemain.ChatUtill;
import me.kr_gaming2005.staffmode.staffmodemain.CustomFiles.MessagesFile;
import me.kr_gaming2005.staffmode.staffmodemain.Data.LoadInv;
import me.kr_gaming2005.staffmode.staffmodemain.Data.SaveInv;
import me.kr_gaming2005.staffmode.staffmodemain.Items.Items;
import me.kr_gaming2005.staffmode.staffmodemain.StaffModeMain;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.myzelyam.api.vanish.VanishAPI;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class StaffModeCommand implements CommandExecutor {

    public static HashMap<String, ItemStack[]> armourContents = new HashMap<String, ItemStack[]>();
    public static HashMap<String, ItemStack[]> inventoryContents = new HashMap<String, ItemStack[]>();
    public static HashMap<String, Location> locations = new HashMap<String, Location>();

    private static StaffModeMain plugin = StaffModeMain.getPlugin(StaffModeMain.class);

    public static ArrayList<String> Staffmode = new ArrayList<>();

    public static void EnterStaffMode(Player p){
        p.sendMessage(ChatUtill.format(MessagesFile.get().getString("prefix") + "&2&lEnabled!"));
        Staffmode.add(p.getUniqueId().toString());
        VanishAPI.hidePlayer(p);
        SaveInv.Save(p);
        locations.put(p.getUniqueId().toString(), p.getLocation());

        p.getInventory().clear();
        Items.giveItems(p);


    }
    public static void ExitStaffMode(Player p){
        Staffmode.remove(p.getUniqueId().toString());
        VanishAPI.showPlayer(p);
        p.sendMessage(ChatUtill.format(MessagesFile.get().getString("prefix") + "&c&lDisabled!"));
        LoadInv.load(p);
        p.teleport(locations.get(p.getUniqueId().toString()));
       }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(command.getName().equalsIgnoreCase("staffmode")){
                if(sender.hasPermission("staffmode.use")) {

                    if(!(Staffmode.contains(p.getUniqueId().toString()))){
                        EnterStaffMode(p);
                }else{
                        ExitStaffMode(p);
                    }
                }
                }
            }
        return false;
    }

}


