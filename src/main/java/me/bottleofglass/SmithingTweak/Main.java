package me.bottleofglass.SmithingTweak;

import me.bottleofglass.SmithingTweak.listeners.SmithingTableListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new SmithingTableListener(), this);
    }
    public static Main getInstance() {return instance;}
}
