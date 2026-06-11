package com.autoenchant;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Set;
import java.util.EnumSet;

public class EnchantListener implements Listener {

    private static final Set<Material> TOOLS = EnumSet.of(
        Material.WOODEN_PICKAXE,
        Material.STONE_PICKAXE,
        Material.IRON_PICKAXE,
        Material.GOLDEN_PICKAXE,
        Material.DIAMOND_PICKAXE,
        Material.NETHERITE_PICKAXE,
        Material.WOODEN_AXE,
        Material.STONE_AXE,
        Material.IRON_AXE,
        Material.GOLDEN_AXE,
        Material.DIAMOND_AXE,
        Material.NETHERITE_AXE
    );

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCraft(CraftItemEvent event) {
        ItemStack item = event.getCurrentItem();
        if (item == null) return;
        if (!TOOLS.contains(item.getType())) return;
        applyEnchants(item);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPickup(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        ItemStack item = event.getItem().getItemStack();
        if (!TOOLS.contains(item.getType())) return;
        if (item.containsEnchantment(Enchantment.EFFICIENCY) &&
            item.containsEnchantment(Enchantment.FORTUNE)) return;
        applyEnchants(item);
    }

    private void applyEnchants(ItemStack item) {
        item.addUnsafeEnchantment(Enchantment.EFFICIENCY, 3);
        item.addUnsafeEnchantment(Enchantment.FORTUNE, 1);
    }
}
