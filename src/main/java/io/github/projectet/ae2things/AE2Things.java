package io.github.projectet.ae2things;

import appeng.api.IAEAddonEntrypoint;
import appeng.api.config.RedstoneMode;
import appeng.api.config.Setting;
import appeng.api.config.Settings;
import appeng.api.storage.StorageCells;
import io.github.projectet.ae2things.command.Command;
import io.github.projectet.ae2things.gui.cell.DISKItemCellGuiHandler;
import io.github.projectet.ae2things.item.AETItems;
import io.github.projectet.ae2things.storage.DISKCellHandler;
import io.github.projectet.ae2things.util.StorageManager;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AE2Things implements IAEAddonEntrypoint {

    public static final String MOD_ID = "ae2things";

    public static final CreativeModeTab ITEM_GROUP = FabricItemGroup
            .builder()
            .icon(() -> new ItemStack(AETItems.DISK_HOUSING))
            .title(Component.translatable("itemGroup.ae2things.item_group"))
            .build();

    public static StorageManager STORAGE_INSTANCE = new StorageManager();

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID , path);
    }

    @Override
    public void onAe2Initialized() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, id("item_group"), ITEM_GROUP);

        AETItems.init();
        Command.init();

        ItemGroupEvents.modifyEntriesEvent(BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(ITEM_GROUP).get()).register(content -> {
            for(Tuple<ResourceLocation, ? extends Item> i : AETItems.ITEMS) {
                content.accept(i.getB());
            }
        });

        StorageCells.addCellHandler(DISKCellHandler.INSTANCE);
        StorageCells.addCellGuiHandler(new DISKItemCellGuiHandler());


        ServerTickEvents.START_WORLD_TICK.register((world -> {
            STORAGE_INSTANCE = StorageManager.getInstance(world.getServer());
        }));
    }
}
