package io.github.projectet.ae2things.item;

import appeng.api.client.StorageCellModels;
import appeng.api.upgrades.Upgrades;
import appeng.api.stacks.AEKeyType;
import appeng.core.definitions.AEItems;
import appeng.items.materials.StorageComponentItem;
import appeng.items.storage.BasicStorageCell;
import appeng.items.storage.StorageTier;
import appeng.items.tools.powered.PortableCellItem;
import appeng.menu.me.common.MEStorageMenu;
import io.github.projectet.ae2things.AE2Things;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AETItems {

    public static final StorageTier SIZE_1024K = new StorageTier(9, "1024k", 524288, 8192,
            () -> AETItems.CELL_COMPONENT_1024K);
    public static final StorageTier SIZE_4096K = new StorageTier(10, "4096k", 2097152, 32768,
            () -> AETItems.CELL_COMPONENT_4096K);

    public static final ResourceLocation MODEL_DISK_DRIVE_1K = AE2Things.id("model/drive/cells/disk_1k");
    public static final ResourceLocation MODEL_DISK_DRIVE_4K = AE2Things.id("model/drive/cells/disk_4k");
    public static final ResourceLocation MODEL_DISK_DRIVE_16K = AE2Things.id("model/drive/cells/disk_16k");
    public static final ResourceLocation MODEL_DISK_DRIVE_64K = AE2Things.id("model/drive/cells/disk_64k");
    public static final ResourceLocation MODEL_DISK_DRIVE_256K = AE2Things.id("model/drive/cells/disk_256k");

    public static final FabricItemSettings DEFAULT_SETTINGS = new FabricItemSettings();

    public static final List<Tuple<ResourceLocation, ? extends Item>> ITEMS = new ArrayList<>();

    public static final Item DISK_HOUSING = item(new Item(DEFAULT_SETTINGS.stacksTo(64).fireResistant()),"disk_housing");
    public static final DISKDrive DISK_DRIVE_1K = registerCell(AETItems.MODEL_DISK_DRIVE_1K, new DISKDrive(AEItems.CELL_COMPONENT_1K, 1, 0.5f), "disk_drive_1k");
    public static final DISKDrive DISK_DRIVE_4K = registerCell(AETItems.MODEL_DISK_DRIVE_4K, new DISKDrive(AEItems.CELL_COMPONENT_4K, 4, 1.0f), "disk_drive_4k");
    public static final DISKDrive DISK_DRIVE_16K = registerCell(AETItems.MODEL_DISK_DRIVE_16K, new DISKDrive(AEItems.CELL_COMPONENT_16K, 16, 1.5f), "disk_drive_16k");
    public static final DISKDrive DISK_DRIVE_64K = registerCell(AETItems.MODEL_DISK_DRIVE_64K, new DISKDrive(AEItems.CELL_COMPONENT_64K, 64, 2.0f), "disk_drive_64k");
    public static final DISKDrive DISK_DRIVE_256K = registerCell(AETItems.MODEL_DISK_DRIVE_256K, new DISKDrive(AEItems.CELL_COMPONENT_256K, 256, 2.5f), "disk_drive_256k");

    public static final StorageComponentItem CELL_COMPONENT_1024K = item(new StorageComponentItem(DEFAULT_SETTINGS.stacksTo(64), 1024),"cell_component_1024k");
    public static final StorageComponentItem CELL_COMPONENT_4096K = item(new StorageComponentItem(DEFAULT_SETTINGS.stacksTo(64), 4096),"cell_component_4096k");

    public static final BasicStorageCell ITEM_CELL_1024K = registerCell(new ResourceLocation("ae2:block/drive/cells/64k_item_cell"), new BasicStorageCell(DEFAULT_SETTINGS.stacksTo(1), CELL_COMPONENT_1024K, AEItems.ITEM_CELL_HOUSING, 3.0f, 1024, 8192,63, AEKeyType.items()), "item_storage_cell_1024k");
    public static final BasicStorageCell ITEM_CELL_4096K = registerCell(new ResourceLocation("ae2:block/drive/cells/64k_item_cell"), new BasicStorageCell(DEFAULT_SETTINGS.stacksTo(1), CELL_COMPONENT_4096K, AEItems.ITEM_CELL_HOUSING, 3.5f, 4096, 32768,63, AEKeyType.items()), "item_storage_cell_4096k");

    public static final BasicStorageCell FLUID_CELL_1024K = registerCell(new ResourceLocation("ae2:block/drive/cells/64k_fluid_cell"), new BasicStorageCell(DEFAULT_SETTINGS.stacksTo(1), CELL_COMPONENT_1024K, AEItems.FLUID_CELL_HOUSING, 3.0f, 1024, 8192,5, AEKeyType.fluids()),"fluid_storage_cell_1024k");
    public static final BasicStorageCell FLUID_CELL_4096K = registerCell(new ResourceLocation("ae2:block/drive/cells/64k_fluid_cell"), new BasicStorageCell(DEFAULT_SETTINGS.stacksTo(1), CELL_COMPONENT_4096K, AEItems.FLUID_CELL_HOUSING, 3.5f, 4096, 32768,5, AEKeyType.fluids()),"fluid_storage_cell_4096k");

    public static final Item PORTABLE_DISK_1K = registerPortableDISK(AETItems.MODEL_DISK_DRIVE_1K, "portable_disk_1k", AEItems.CELL_COMPONENT_1K.asItem());
    public static final Item PORTABLE_DISK_4K = registerPortableDISK(AETItems.MODEL_DISK_DRIVE_4K, "portable_disk_4k", AEItems.CELL_COMPONENT_4K.asItem());
    public static final Item PORTABLE_DISK_16K = registerPortableDISK(AETItems.MODEL_DISK_DRIVE_16K, "portable_disk_16k", AEItems.CELL_COMPONENT_16K.asItem());
    public static final Item PORTABLE_DISK_64K = registerPortableDISK(AETItems.MODEL_DISK_DRIVE_64K, "portable_disk_64k", AEItems.CELL_COMPONENT_64K.asItem());
    public static final Item PORTABLE_DISK_256K = registerPortableDISK(AETItems.MODEL_DISK_DRIVE_256K, "portable_disk_256k", AEItems.CELL_COMPONENT_256K.asItem());

    public static final Item PORTABLE_ITEM_1024K = registerPortableItemCell("portable_item_cell_1024k", SIZE_1024K);
    public static final Item PORTABLE_ITEM_4096K = registerPortableItemCell("portable_item_cell_4096k", SIZE_4096K);

    public static final Item PORTABLE_FLUID_1024K = registerPortableFluidCell("portable_fluid_cell_1024k", SIZE_1024K);
    public static final Item PORTABLE_FLUID_4096K = registerPortableFluidCell("portable_fluid_cell_4096k", SIZE_4096K);

    public static void init() {
        for(Tuple<ResourceLocation, ? extends Item> pair : ITEMS) {
            Registry.register(BuiltInRegistries.ITEM, pair.getA(), pair.getB());
        }
    }

    private static <T extends Item> T item(T item, String id) {
        ITEMS.add(new Tuple<>(AE2Things.id(id), item));

        return item;
    }

    private static <T extends Item> T registerCell(ResourceLocation model, T item, String id) {
        Upgrades.add(AEItems.FUZZY_CARD, item, 1, "gui.ae2things.upgrade.disk");
        Upgrades.add(AEItems.VOID_CARD, item, 1, "gui.ae2things.upgrade.disk");
        Upgrades.add(AEItems.INVERTER_CARD, item, 1, "gui.ae2things.upgrade.disk");
        Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, item, 1, "gui.ae2things.upgrade.disk");
        StorageCellModels.registerModel(item, model);

        return item(item, id);
    }

    private static Item registerPortableDISK(ResourceLocation model, String id, StorageComponentItem sizeComponent) {
        var diskItem = item(new PortableDISKItem(sizeComponent, DEFAULT_SETTINGS.stacksTo(1).fireResistant()), id);
        Upgrades.add(AEItems.FUZZY_CARD, diskItem, 1, "gui.ae2things.upgrade.portabledisk");
        Upgrades.add(AEItems.VOID_CARD, diskItem, 1, "gui.ae2things.upgrade.portabledisk");
        Upgrades.add(AEItems.INVERTER_CARD, diskItem, 1, "gui.ae2things.upgrade.portabledisk");
        Upgrades.add(AEItems.EQUAL_DISTRIBUTION_CARD, diskItem, 1, "gui.ae2things.upgrade.portabledisk");
        Upgrades.add(AEItems.ENERGY_CARD, diskItem, 2, "gui.ae2things.upgrade.portabledisk");
        StorageCellModels.registerModel(diskItem, model);

        return diskItem;
    }

    private static Item registerPortableItemCell(String id, StorageTier tier) {
        return item(new PortableCellItem(AEKeyType.items(), 8192, MEStorageMenu.PORTABLE_ITEM_CELL_TYPE, tier, DEFAULT_SETTINGS.stacksTo(1), 1), id);
    }

    private static Item registerPortableFluidCell(String id, StorageTier tier) {
        return item(new PortableCellItem(AEKeyType.fluids(), 8192, MEStorageMenu.PORTABLE_FLUID_CELL_TYPE, tier, DEFAULT_SETTINGS.stacksTo(1), 1), id);
    }
}
