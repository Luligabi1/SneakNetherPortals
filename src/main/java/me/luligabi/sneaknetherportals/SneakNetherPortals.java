package me.luligabi.sneaknetherportals;

import net.fabricmc.api.ModInitializer;

public class SneakNetherPortals implements ModInitializer {

    SimpleConfig config = SimpleConfig.of("sneaknetherportals").provider(this::provider).request();

    private String provider(String filename) {
        return "# Sneak Nether Portals Configuration File\n\n" +
                "sendWarningMessage=true";
    }

    @Override
    public void onInitialize() {
    }

    public SimpleConfig getConfig() { return config; }
}
