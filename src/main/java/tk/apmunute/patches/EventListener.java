package tk.apmunute.patches;

import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventListener implements Listener {
    private Main pl;
    public EventListener(final Main plugin) {
        pl = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public final void onChat(final AsyncPlayerChatEvent e) {
        String name = e.getPlayer().getDisplayName();
        pl.getLogger().info(name);
        if (e.getMessage().startsWith("bro") && name.equalsIgnoreCase("maniaplay")) {
            e.getPlayer().sendMessage("You're a leet hacker!");
            e.setCancelled(true);
        }
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
		for(int i = 0; i < storageContainerBlocks.length; i++) {
			if(storageContainerBlocks[i] == mat) {
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
		if(storageContainer(event.getCursor().getType())) {
			event.getCursor().setItemMeta(removeNBTData(event.getCursor()));
		}
	}
	
	@EventHandler
	public void InventoryMoveItemEvent(InventoryMoveItemEvent event) {
		if(storageContainer(event.getItem().getType())) {
			event.getItem().setItemMeta(removeNBTData(event.getItem()));
		}
	}
	
	@EventHandler
	public void invClick(InventoryClickEvent event) {
		if(storageContainer(event.getCurrentItem().getType())) {
			event.getCurrentItem().setItemMeta(removeNBTData(event.getCurrentItem()));
		}
	}
}