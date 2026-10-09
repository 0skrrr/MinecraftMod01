package Oskar_CZ_OTM.services.types;

import net.minecraft.resources.Identifier;

import java.util.function.Supplier;

public interface RegistryHandle<T> extends Supplier {
    Identifier id();
}
