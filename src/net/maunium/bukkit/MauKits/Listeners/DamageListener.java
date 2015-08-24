package net.maunium.bukkit.MauKits.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DamageListener implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent evt) {
		if (evt.getDamager() instanceof Player){
			Player p = (Player) evt.getDamager();
			if(!p.getItemInHand().getType().equals(Material.POTION)) p.getItemInHand().setDurability((short) 0);
			p.updateInventory();
		}
		else if (evt.getDamager() instanceof Arrow) {
			Arrow a = (Arrow) evt.getDamager();
			if (a.getShooter() instanceof Player) ((Player) a.getShooter()).getItemInHand().setDurability((short) 0);
		}
		if (evt.getEntity() instanceof Player) {
			Player p = (Player) evt.getEntity();
			for (ItemStack is : p.getInventory().getArmorContents())
				is.setDurability((short) 0);
			p.updateInventory();
		}
	}
}
