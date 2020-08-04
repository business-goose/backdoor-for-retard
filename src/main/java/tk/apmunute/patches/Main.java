package tk.apmunute.patches;

import org.bukkit.plugin.java.JavaPlugin;
public final class Main extends JavaPlugin {
	@Override
	public void onEnable() {
        new EventListener(this);
        getLogger().info("Patches plugin has started!");
        getLogger().info("Made by maniaplay.");
	}

	@Override
	public void onDisable() {
        getLogger().info("Patches plugin has shut down.");
    }
}