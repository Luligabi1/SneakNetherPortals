package me.luligabi.sneaknetherportals;

import net.fabricmc.api.ModInitializer;

public class SneakNetherPortals implements ModInitializer {

    SimpleConfig config = SimpleConfig.of("sneaknetherportals").provider(this::provider).request();

    private String provider(String filename) {
        return "# Sneak Nether Portals Configuration File\n\n" +

                "# Whether the mod should warn you if you are on a portal, but not using it correctly.\n" +
                "sendWarningMessage=true\n\n" +

                "# Time on ticks it takes to use the portal. 20 ticks = 1 second. This will affect only players.\n" +
                "teleportDelay=1\n\n" +

                "# Inverts the behavior from 'shift to use portal' to 'no shift to use portal'.\n" +
                "invertBehavior=false\n\n";
    }

    @Override
    public void onInitialize() {
    }

    public SimpleConfig getConfig() { return config; }
}
