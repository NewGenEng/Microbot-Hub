package net.runelite.client.plugins.microbot.autofishing;

import net.runelite.client.config.*;
import net.runelite.client.plugins.microbot.autofishing.enums.Fish;
import net.runelite.client.plugins.microbot.autofishing.enums.HarpoonType;
import net.runelite.client.plugins.microbot.autofishing.enums.PreferredSpotDirection;
import net.runelite.client.plugins.microbot.autofishing.enums.PreferredSpotOrigin;

@ConfigGroup("AutoFishing")
public interface AutoFishingConfig extends Config {
    
    @ConfigSection(
            name = "General",
            description = "General settings",
            position = 0
    )
    String GENERAL_SECTION = "general";

    @ConfigSection(
            name = "Spot preference",
            description = "Prefer certain fishing spots based on direction or coordinates",
            position = 1
    )
    String SPOT_PREFERENCE_SECTION = "spotPreference";

    // GENERAL SECTION
    @ConfigItem(
            keyName = "fishToCatch",
            name = "Fish to catch",
            description = "Choose the fish type to catch",
            position = 0,
            section = GENERAL_SECTION
    )
    default Fish fishToCatch() {
        return Fish.SHRIMP_AND_ANCHOVIES;
    }

    @ConfigItem(
            keyName = "useBank",
            name = "Use bank",
            description = "Use bank and walk back to fishing location",
            position = 1,
            section = GENERAL_SECTION
    )
    default boolean useBank() {
        return false;
    }

    @ConfigItem(
            keyName = "cookFish",
            name = "Cook fish",
            description = "Cook fish after fishing if a fire/range is nearby",
            position = 2,
            section = GENERAL_SECTION
    )
    default boolean cookFish() {
        return false;
    }

    @ConfigItem(
            keyName = "harpoonSpec",
            name = "Harpoon spec",
            description = "Choose the harpoon type for special attacks",
            position = 3,
            section = GENERAL_SECTION
    )
    default HarpoonType harpoonSpec() {
        return HarpoonType.NONE;
    }

    @ConfigItem(
            keyName = "toggleBankLocksOnceOnStart",
            name = "Toggle bank locks once on start",
            description = "If enabled, the script will toggle bank locks one time (the first time it uses the bank) and will not toggle them back after depositing.",
            position = 4,
            section = GENERAL_SECTION
    )
    default boolean toggleBankLocksOnceOnStart() {
        return false;
    }

    // SPOT PREFERENCE SECTION
    @ConfigItem(
            keyName = "enableSpotPreference",
            name = "Enable spot preference",
            description = "When enabled, the script will prefer fishing spots matching the rules below (falls back to nearest if none match)",
            position = 0,
            section = SPOT_PREFERENCE_SECTION
    )
    default boolean enableSpotPreference() {
        return false;
    }

    @ConfigItem(
            keyName = "preferredSpotOrigin",
            name = "Preference origin",
            description = "Choose the origin used for the direction preference",
            position = 1,
            section = SPOT_PREFERENCE_SECTION
    )
    default PreferredSpotOrigin preferredSpotOrigin() {
        return PreferredSpotOrigin.PLAYER;
    }

    @ConfigItem(
            keyName = "preferredSpotDirection",
            name = "Preferred direction",
            description = "Prefer spots in a direction relative to the chosen origin (example: SOUTH for Shilo Village south river spots)",
            position = 2,
            section = SPOT_PREFERENCE_SECTION
    )
    default PreferredSpotDirection preferredSpotDirection() {
        return PreferredSpotDirection.ANY;
    }

    @Range(min = 0, max = 10)
    @ConfigItem(
            keyName = "preferredSpotDirectionTolerance",
            name = "Direction tolerance (tiles)",
            description = "How many tiles of leeway to allow when determining if a spot is in the chosen direction",
            position = 3,
            section = SPOT_PREFERENCE_SECTION
    )
    default int preferredSpotDirectionTolerance() {
        return 0;
    }

    @ConfigItem(
            keyName = "enableSpotCoordinateBounds",
            name = "Enable coordinate bounds",
            description = "If enabled, spots inside the coordinate bounds will be preferred",
            position = 4,
            section = SPOT_PREFERENCE_SECTION
    )
    default boolean enableSpotCoordinateBounds() {
        return false;
    }

    @ConfigItem(
            keyName = "preferredSpotMinX",
            name = "Min X",
            description = "Minimum world X for preferred spots",
            position = 5,
            section = SPOT_PREFERENCE_SECTION
    )
    default int preferredSpotMinX() {
        return 0;
    }

    @ConfigItem(
            keyName = "preferredSpotMaxX",
            name = "Max X",
            description = "Maximum world X for preferred spots",
            position = 6,
            section = SPOT_PREFERENCE_SECTION
    )
    default int preferredSpotMaxX() {
        return 0;
    }

    @ConfigItem(
            keyName = "preferredSpotMinY",
            name = "Min Y",
            description = "Minimum world Y for preferred spots",
            position = 7,
            section = SPOT_PREFERENCE_SECTION
    )
    default int preferredSpotMinY() {
        return 0;
    }

    @ConfigItem(
            keyName = "preferredSpotMaxY",
            name = "Max Y",
            description = "Maximum world Y for preferred spots",
            position = 8,
            section = SPOT_PREFERENCE_SECTION
    )
    default int preferredSpotMaxY() {
        return 0;
    }

    @Range(min = -1, max = 3)
    @ConfigItem(
            keyName = "preferredSpotPlane",
            name = "Plane (-1 = any)",
            description = "Plane required for the coordinate bounds (-1 = any)",
            position = 9,
            section = SPOT_PREFERENCE_SECTION
    )
    default int preferredSpotPlane() {
        return -1;
    }
}