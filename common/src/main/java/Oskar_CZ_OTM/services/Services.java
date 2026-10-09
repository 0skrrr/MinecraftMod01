package Oskar_CZ_OTM.services;

import Oskar_CZ_OTM.Constants;
import Oskar_CZ_OTM.services.types.IPlatformHelper;
import Oskar_CZ_OTM.services.types.IRegistryHelper;

import java.util.ServiceLoader;

// Service loaders are a built-in Java feature that allow us to locate implementations of an interface that vary from one
// environment to another. In the context of MultiLoader we use this feature to access a mock API in the common code that
// is swapped out for the types specific implementation at runtime.
public class Services {

    // In this example we provide a types helper which provides information about what types the mod is running on.
    // For example this can be used to check if the code is running on NeoForge vs Fabric, or to ask the modloader if another
    // mod is loaded.
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static final IRegistryHelper REGISTRY = load(IRegistryHelper.class);

    // This code is used to load a service for the current environment. Your implementation of the service must be defined
    // manually by including a text file in META-INF/types named with the fully qualified class name of the service.
    // Inside the file you should write the fully qualified class name of the implementation to load for the types. For
    // example our file on Forge points to ForgePlatformHelper while Fabric points to FabricPlatformHelper.
    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz, Services.class.getClassLoader())
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        Constants.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}