package me.luligabi.sneaknetherportals;

import net.fabricmc.api.ModInitializer;

public class SneakNetherPortals implements ModInitializer {

    @Override
    public void onInitialize() {
    }


    public static SneakNetherPortals getInstance() {
        return INSTANCE;
    }

    public SimpleConfig getConfig() { return config; }

    SimpleConfig config = SimpleConfig.of("sneaknetherportals").provider(this::provider).request();

    private String provider(String filename) {
        return """
                # Sneak Nether Portals Configuration File

                # Whether the mod should warn you if you are on a portal, but not using it correctly.
                sendWarningMessage=true

                # Time on ticks it takes to use the portal. 20 ticks = 1 second. This will affect only players.
                teleportDelay=1

                # Inverts the behavior from 'shift to use portal' to 'no shift to use portal'.
                invertBehavior=false

                """;
    }

    private static final SneakNetherPortals INSTANCE = new SneakNetherPortals();

}