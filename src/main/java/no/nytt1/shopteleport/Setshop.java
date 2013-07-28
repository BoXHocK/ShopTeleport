package no.nytt1.shopteleport;

import org.bukkit.entity.Player;

public class Setshop {
	
	/*public static boolean isSafe(Location loc){
	    World world = loc.getWorld();
	    double y = loc.getY();
	    //Check for suffocation
	    loc.setY(y+1);
	    Block block1 = world.getBlockAt(loc);
	    loc.setY(y+2);
	    Block block2 = world.getBlockAt(loc);
	    if(!(block1.getTypeId()==0||block2.getTypeId()==0)){
	        return false;//not safe, suffocated
	    }
	    //Check for lava/void
	    for(double i=128;i>-1;i--){
	        loc.setY(i);
	        Block block = world.getBlockAt(loc);
	        if(block.getTypeId()!=0){
	            if(block.getType()==Material.LAVA){
	                return false;//not safe, lava above or below you
	            }else{
	                if(!(block.getType()==Material.TORCH||block.getType()==Material.REDSTONE_TORCH_ON||block.getType()==Material.REDSTONE_TORCH_OFF||block.getType()==Material.PAINTING)){
	                    if(i<y){
	                        loc.setY(-1);//set y to negitive 1 to end loop, we hit solid ground.
	                    }
	                    //Check for painful fall
	                    if((y-i)>10){
	                        return false;//would fall down at least 11 blocks = painful landing...
	                }else{
	                	return true;
	                }
	            }
	            }
	        }else{
	            if(i==0){
	                if(block.getTypeId()==0){
	                    return false;//not safe, void
	                }else{
	                	return true;
	                }
	            }
	        }
	    }
		return false;
	}
*/
	public boolean setshop(Player player, String[] args) {
		ShopTeleport.plugin.logger.info("In Setshop class");
		/*if (player.hasPermission("shopteleport.setshop")){
			String playername1 = player.getName().toLowerCase();
            Location loc = player.getLocation();
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();
            double yaw = loc.getYaw();
            double pitch = loc.getPitch();
            World world = loc.getWorld();
            
			if (isSafe(loc)==true){
				ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".x", Double.valueOf(x));
				ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".y", Double.valueOf(y));
				ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".z", Double.valueOf(z));
				ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".yaw", Double.valueOf(yaw));
                ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".pitch", Double.valueOf(pitch));
                ShopTeleport.plugin.getConfig().set("shops." + playername1 + ".world", world.getName());
                
                ShopTeleport.plugin.saveConfig();
player.sendMessage(ChatColor.GREEN + "Shop has been set");
            }else if (isSafe(loc)==false){
            	player.sendMessage(Messages.colours(ShopTeleport.plugin.getConfig().getString("messages.location-not-safe")));
            }
            
		}else{
			player.sendMessage(Messages.colours(ShopTeleport.plugin.getConfig().getString("messages.no-permission")));
		}*/
		return true;
	}
	
	
}
