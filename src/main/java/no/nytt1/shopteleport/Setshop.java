package no.nytt1.shopteleport;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Setshop {
	

	public boolean setShop(Player player, String[] args) {
		if (player.hasPermission("shopteleport.setshop")){
			String playername1 = player.getName().toLowerCase();
            Location loc = player.getLocation();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            double yaw = loc.getYaw();
            double pitch = loc.getPitch();
            World world = loc.getWorld();

            IsSafe issafe = new IsSafe();
            
			if (issafe.isSafe(loc)==true){
				ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".x", Double.valueOf(x));
				ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".y", Double.valueOf(y));
				ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".z", Double.valueOf(z));
				ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".yaw", Double.valueOf(yaw));
                ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".pitch", Double.valueOf(pitch));
                ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".world", world.getName());
                
                ShopTeleport.plugin.saveConfig();
player.sendMessage(ChatColor.GREEN + "Shop has been set");
            }else if (issafe.isSafe(loc)==false){
            	player.sendMessage(Messages.colours(ShopTeleport.plugin.getConfig().getString("messages.location-not-safe")));
            }
            
		}else{
			player.sendMessage(Messages.colours(ShopTeleport.plugin.getConfig().getString("messages.no-permission")));
		}
		return true;
	}
	
	
}
