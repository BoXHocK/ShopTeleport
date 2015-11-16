package no.nytt1.shopteleport.commands;

import no.nytt1.shopteleport.Messages;
import no.nytt1.shopteleport.ShopTeleport;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Setshop implements CommandExecutor {


	private final ShopTeleport plugin; // The global variable.
	
	public Setshop(ShopTeleport plugin) // A method without a return type and the classes name is a constructor
    {
        this.plugin = plugin; //Save the given reference in our global variable.
    }

	public boolean isSafe(Location loc){
		Location loc2 = loc;
		Location loc3 = loc;
		loc2.setY(loc.getY()+1);	
		loc3.setY(loc.getY()-1);
		if (!loc.getBlock().isEmpty() && !loc2.getBlock().isEmpty() && loc3.getBlock().isLiquid()){
			return false;																		
		}
	    return true;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player){
			Player player = (Player) sender;
			if (player.hasPermission("shopteleport.setshop")){
				String playername1 = player.getName().toLowerCase();
		        Location loc = player.getLocation();
		        double x = loc.getX();
		        double y = loc.getY();
		        double z = loc.getZ();
		        double yaw = loc.getYaw();
		        double pitch = loc.getPitch();
		        World world = loc.getWorld();
		        
				if (isSafe(loc) == true){
					plugin.getConfig().set("shops." + playername1 + ".x", Double.valueOf(x));
					plugin.getConfig().set("shops." + playername1 + ".y", Double.valueOf(y));
					plugin.getConfig().set("shops." + playername1 + ".z", Double.valueOf(z));
					plugin.getConfig().set("shops." + playername1 + ".yaw", Double.valueOf(yaw));
		            plugin.getConfig().set("shops." + playername1 + ".pitch", Double.valueOf(pitch));
		            plugin.getConfig().set("shops." + playername1 + ".world", world.getName());
		            
		            plugin.saveConfig();
		            player.sendMessage(Messages.colours(plugin.getConfig().getString("messages.shop-set")));
		            return true;
		        } else {
		        	player.sendMessage(Messages.colours(plugin.getConfig().getString("messages.location-not-safe")));
		        	return true;
		        }
		    } else {
		    	player.sendMessage(Messages.colours(plugin.getConfig().getString("messages.no-permission")));
			    return true;
		    }
		}		
		sender.sendMessage(Messages.colours(plugin.getConfig().getString("messages.no-permission")));
	    return true;
	}

}
