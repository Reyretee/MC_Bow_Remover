package me.reyretee.bowsilici;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public final class BowSilici extends JavaPlugin {

    private int silmesuresi = 600;
    @Override
    public void onEnable() {
        SilmeIslemi();
        System.out.println("Eklenti etkinleştirildi.");

    }

    @Override
    public void onDisable() {
        System.out.println("Eklenti kapatıldı.");
    }

    private void SilmeIslemi() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : getServer().getOnlinePlayers()) {
                    ItemStack[] inventoryContents = player.getInventory().getContents();
                    for (int i = 0; i < inventoryContents.length; i++) {
                        ItemStack item = inventoryContents[i];
                        if (item != null && (item.getType() == Material.ARROW || item.getType() == Material.BOW)) {
                            player.getInventory().setItem(i, null);
                        }
                    }
                }
            }
        }.runTaskTimer(this, silmesuresi, silmesuresi);
    }
}
