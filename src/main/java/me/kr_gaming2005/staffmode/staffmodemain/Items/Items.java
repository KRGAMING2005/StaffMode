package me.kr_gaming2005.staffmode.staffmodemain.Items;

import me.kr_gaming2005.staffmode.staffmodemain.ChatUtill;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Items {

    public static void giveItems(Player p){

        //PlayerList
        ItemStack PlayerList = new ItemStack(Material.CHEST);
        ItemMeta plm = PlayerList.getItemMeta();
        plm.setDisplayName(ChatUtill.format("&e&lPlayer List"));
        ArrayList<String> pll = new ArrayList<>();
        pll.add(ChatUtill.format("&eShows Online Players"));
        plm.setLore(pll);
        PlayerList.setItemMeta(plm);
        p.getInventory().setItem(0, PlayerList);

        //RandomTP
        ItemStack RandomTP = new ItemStack(Material.ENDER_EYE);
        ItemMeta rtpm = RandomTP.getItemMeta();
        rtpm.setDisplayName(ChatUtill.format("&d&lRandom TP"));
        ArrayList<String> rtpl = new ArrayList<>();
        rtpl.add(ChatUtill.format("&dRandomly teleports you to a none staffmember"));
        rtpm.setLore(rtpl);
        RandomTP.setItemMeta(rtpm);
        p.getInventory().setItem(3, RandomTP);

        //HiddenStaff
        ItemStack HiddenStaff = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta OSM = (SkullMeta) HiddenStaff.getItemMeta();
        OSM.setOwningPlayer(p);
        OSM.setDisplayName(ChatUtill.format("&e&lHiddenStaff"));
        HiddenStaff.setItemMeta(OSM);
        p.getInventory().setItem(4, HiddenStaff);

        //Banhammer
        ItemStack BanHammer = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta BHM = BanHammer.getItemMeta();
        BHM.setDisplayName(ChatUtill.format("&4&lBan Hammer"));
        ArrayList<String> BHL = new ArrayList<>();
        BHL.add(ChatUtill.format("&4Opens a ban Gui for the player you punch"));
        BanHammer.setItemMeta(BHM);
        p.getInventory().setItem(5, BanHammer);

        //VanishToggle
        ItemStack VanishToggle = new ItemStack(Material.LIME_DYE);
        ItemMeta VTM = VanishToggle.getItemMeta();
        VTM.setDisplayName(ChatUtill.format("&a&lVanish Toggle"));
        ArrayList<String> VTL = new ArrayList<>();
        VTL.add(ChatUtill.format("&aToggle Vanish!"));
        VanishToggle.setItemMeta(VTM);
        p.getInventory().setItem(8, VanishToggle);
    }

}
