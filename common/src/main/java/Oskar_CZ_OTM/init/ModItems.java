package Oskar_CZ_OTM.init;

import Oskar_CZ_OTM.services.Services;
import Oskar_CZ_OTM.services.types.RegistryHandle;
import net.minecraft.world.item.Item;

public final class ModItems {
    private ModItems() {
    }

    public static void init() {}

    public static final RegistryHandle<Item> EXAMPLE_ITEM = Services.REGISTRY.registerItem("example_item",
            Item::new);
    public static final RegistryHandle<Item> EXAMPLE_ITEM2 = Services.REGISTRY.registerItem("example_item2",
            Item::new);

}
