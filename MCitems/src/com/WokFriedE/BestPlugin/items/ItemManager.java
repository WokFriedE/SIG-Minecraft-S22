package com.WokFriedE.BestPlugin.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager { //first make a item manager to handle all items

    public static ItemStack funnystick;

    public static void init() { //to do any initialization
        createFunnyStick(); //lastly tell the code to init the item
    }

    public static void createFunnyStick(){ //to form the item
        ItemStack item = new ItemStack(Material.STICK, 1); //sets stack amount
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6The Small Stick"); //sets name of the item

        List<String> lore = new ArrayList<>(); //create information for the item
        lore.add("Funny noises");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.LUCK, 1, false); //effect (luck for shiney), level, false to ignore vanilla restricts
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS); //hide the luck effect, so embedded essentially
        item.setItemMeta(meta); //to set meta to the object
        funnystick = item;

        //after creating an item crafting item
        //Shaped recipe --> requires a specific shape
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("funnystick"), item); //namespace (reference key), new ItemStack(Material.DIAMOND, 1 | for normal items
        sr.shape(" B ",
                 " S ",
                 " S "); //set the crafting recipe, each key will act as items
        sr.setIngredient('B', Material.BAMBOO); //sets the keys for the materials
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);//registers the recipe

        //Shapeless recipe
        ShapelessRecipe slr = new ShapelessRecipe(NamespacedKey.minecraft("shapelessstick"), item);
        slr.addIngredient(2, Material.BAMBOO); //add ingredients instead
        slr.addIngredient(1, Material.ARROW);
        Bukkit.getServer().addRecipe(slr);

        //furnace recipe
        FurnaceRecipe smelt = new FurnaceRecipe(NamespacedKey.minecraft("smeltedstick"), item, Material.EMERALD, 1.0f, 20);
        Bukkit.getServer().addRecipe(smelt);
        //1 s = 20 ticks
        //namespace, item making, item needed, experience, time

    }

}
