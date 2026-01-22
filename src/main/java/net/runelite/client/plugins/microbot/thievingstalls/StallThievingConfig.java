package net.runelite.client.plugins.microbot.thievingstalls;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.plugins.microbot.thievingstalls.constants.ThievingSpot;

@ConfigGroup("stallthieving")
public interface StallThievingConfig extends Config {
    @ConfigItem(
            keyName = "instructions",
            name = "Instructions",
            description = "How to use plugin",
            position = 0
    )
    default String INSTRUCTIONS() {
        return "Go to desired thieving location, start script.\n " +
                "Ardy Silk thieving does not lure the guards, use at your own risk.\n " +
                "Add item ids that you do not care to bank to always drop item ids list";
    }

    @ConfigItem(
            keyName = "thievingSpot",
            name = "Thieving Spot",
            description = "Stall to thieve from",
            position = 1
    )
    default ThievingSpot THIEVING_SPOT() {
        return ThievingSpot.ARDY_BAKER;
    }

    @ConfigItem(
            keyName = "shouldBank",
            name = "Bank When Possible",
            description = "Banks items thieved if possible for thieving location",
            position = 2
    )
    default boolean shouldBankWhenPossible() {
        return false;
    }

    @ConfigItem(
            keyName = "alwaysDrop",
            name = "Always Drop Item ids",
            description = "Item ids to always drop even when banking",
            position = 3
    )
    default String alwaysDrop() {
        return "2309,1901";
    }

    @ConfigSection(
            name = "Hosidius Fruit Stall Items to Drop",
            description = "Select which fruits to drop when thieving the Hosidius fruit stall",
            position = 4,
            closedByDefault = true
    )
    String fruitDropSection = "fruitDrop";

    @ConfigItem(
            keyName = "dropCookingApple",
            name = "Cooking apple",
            description = "Drop cooking apples (ID: 1955)",
            section = fruitDropSection,
            position = 0
    )
    default boolean dropCookingApple() {
        return false;
    }

    @ConfigItem(
            keyName = "dropBanana",
            name = "Banana",
            description = "Drop bananas (ID: 1963)",
            section = fruitDropSection,
            position = 1
    )
    default boolean dropBanana() {
        return false;
    }

    @ConfigItem(
            keyName = "dropStrawberry",
            name = "Strawberry",
            description = "Drop strawberries (ID: 5504)",
            section = fruitDropSection,
            position = 2
    )
    default boolean dropStrawberry() {
        return false;
    }

    @ConfigItem(
            keyName = "dropJangerberries",
            name = "Jangerberries",
            description = "Drop jangerberries (ID: 247)",
            section = fruitDropSection,
            position = 3
    )
    default boolean dropJangerberries() {
        return false;
    }

    @ConfigItem(
            keyName = "dropLemon",
            name = "Lemon",
            description = "Drop lemons (ID: 2102)",
            section = fruitDropSection,
            position = 4
    )
    default boolean dropLemon() {
        return false;
    }

    @ConfigItem(
            keyName = "dropRedberries",
            name = "Redberries",
            description = "Drop redberries (ID: 1951)",
            section = fruitDropSection,
            position = 5
    )
    default boolean dropRedberries() {
        return false;
    }

    @ConfigItem(
            keyName = "dropPineapple",
            name = "Pineapple",
            description = "Drop pineapples (ID: 2114)",
            section = fruitDropSection,
            position = 6
    )
    default boolean dropPineapple() {
        return false;
    }

    @ConfigItem(
            keyName = "dropLime",
            name = "Lime",
            description = "Drop limes (ID: 2120)",
            section = fruitDropSection,
            position = 7
    )
    default boolean dropLime() {
        return false;
    }

    @ConfigItem(
            keyName = "dropGolovanvaFruit",
            name = "Golovanova fruit top",
            description = "Drop golovanova fruit tops (ID: 19653)",
            section = fruitDropSection,
            position = 8
    )
    default boolean dropGolovanvaFruit() {
        return false;
    }

    @ConfigItem(
            keyName = "dropPapayaFruit",
            name = "Papaya fruit",
            description = "Drop papaya fruits (ID: 5972)",
            section = fruitDropSection,
            position = 9
    )
    default boolean dropPapayaFruit() {
        return false;
    }

    @ConfigItem(
            keyName = "dropStrangeFruit",
            name = "Strange fruit",
            description = "Drop strange fruit (ID: 464)",
            section = fruitDropSection,
            position = 10
    )
    default boolean dropStrangeFruit() {
        return false;
    }
}
