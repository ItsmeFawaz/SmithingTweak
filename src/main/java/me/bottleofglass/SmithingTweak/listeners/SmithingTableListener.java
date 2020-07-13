package me.bottleofglass.SmithingTweak.listeners;

import me.bottleofglass.SmithingTweak.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.SmithingInventory;
import org.bukkit.scheduler.BukkitRunnable;

public class SmithingTableListener implements Listener {
    @EventHandler
    public void onSmith(InventoryClickEvent evt) {
        if(evt.getWhoClicked().getOpenInventory().getTopInventory() instanceof SmithingInventory) {
            final Inventory smithingInventory = evt.getWhoClicked().getOpenInventory().getTopInventory();
            if((smithingInventory.getItem(0) != null && smithingInventory.getItem(0).getType().toString().startsWith("DIAMOND") && smithingInventory.getItem(0).getEnchantments().keySet().size() > 0) || (smithingInventory.getItem(1) != null &&smithingInventory.getItem(1).getType() == Material.NETHERITE_INGOT)) {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if(smithingInventory.getItem(2) != null) {
                            smithingInventory.setItem(2,removeEnchants(smithingInventory.getItem(2)));
                        }
                    }
                }.runTaskLater(Main.getInstance(),1);
            }
        }
    }
    private ItemStack removeEnchants(ItemStack stack) {
        if(stack.getEnchantments().keySet().size() > 0) {
            for(Enchantment ench: stack.getEnchantments().keySet()) {
                stack.removeEnchantment(ench);
            }
        }
        return stack;
    }
}
