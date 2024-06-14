package io.github.projectet.ae2things.client;

import appeng.api.IAEAddonEntrypoint;
import io.github.projectet.ae2things.item.AETItems;
import io.github.projectet.ae2things.item.DISKDrive;
import io.github.projectet.ae2things.item.PortableDISKItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

@Environment(EnvType.CLIENT)
public class AE2ThingsClient implements IAEAddonEntrypoint {

    @SuppressWarnings("RedundantTypeArguments")
    @Override
    public void onAe2Initialized() {
        ColorProviderRegistry.ITEM.register(DISKDrive::getColor, AETItems.DISK_DRIVE_1K, AETItems.DISK_DRIVE_4K, AETItems.DISK_DRIVE_16K, AETItems.DISK_DRIVE_64K, AETItems.DISK_DRIVE_256K);
        ColorProviderRegistry.ITEM.register(PortableDISKItem::getColor, AETItems.PORTABLE_DISK_1K, AETItems.PORTABLE_DISK_4K, AETItems.PORTABLE_DISK_16K, AETItems.PORTABLE_DISK_64K, AETItems.PORTABLE_DISK_256K);
    }
}
