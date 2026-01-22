package net.runelite.client.plugins.microbot.thievingstalls.model;

import lombok.AllArgsConstructor;
import net.runelite.client.plugins.microbot.thievingstalls.StallThievingConfig;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor(onConstructor_ = @Inject)
public class BankInventoryStrategy implements IInventoryStrategy {
    private BotApi botApi;
    private DropInventoryStrategy dropInventoryStrategy;
    private StallThievingConfig config;

    @Override
    public void execute(IStallThievingSpot stallThievingSpot) {
        if (!botApi.isInventoryFull())
        {
            return;
        }

        botApi.dropAll(getItemIdsToAlwaysDrop());

        if (!botApi.isInventoryFull())
        {
            return;
        }

        try
        {
            stallThievingSpot.bank();
            return;
        }
        catch (final UnsupportedOperationException ex)
        {
            System.out.println("Banking not supported for this thieving spot. Dropping items");
        }

        dropInventoryStrategy.execute(stallThievingSpot);
    }

    private int[] getItemIdsToAlwaysDrop()
    {
        List<Integer> itemsToDrop = new ArrayList<>();

        // Add items from the alwaysDrop config string
        if (!config.alwaysDrop().isEmpty()) {
            Arrays.stream(config.alwaysDrop().split("\\s*,\\s*"))
                    .mapToInt(Integer::parseInt)
                    .forEach(itemsToDrop::add);
        }

        // Check each fruit checkbox and add to drop list if selected
        if (config.dropCookingApple()) {
            itemsToDrop.add(1955); // Cooking apple
        }
        if (config.dropBanana()) {
            itemsToDrop.add(1963); // Banana
        }
        if (config.dropStrawberry()) {
            itemsToDrop.add(5504); // Strawberry
        }
        if (config.dropJangerberries()) {
            itemsToDrop.add(247); // Jangerberries
        }
        if (config.dropLemon()) {
            itemsToDrop.add(2102); // Lemon
        }
        if (config.dropRedberries()) {
            itemsToDrop.add(1951); // Redberries
        }
        if (config.dropPineapple()) {
            itemsToDrop.add(2114); // Pineapple
        }
        if (config.dropLime()) {
            itemsToDrop.add(2120); // Lime
        }
        if (config.dropGolovanvaFruit()) {
            itemsToDrop.add(19653); // Golovanova fruit top
        }
        if (config.dropPapayaFruit()) {
            itemsToDrop.add(5972); // Papaya fruit
        }
        if (config.dropStrangeFruit()) {
            itemsToDrop.add(464); // Strange fruit
        }

        return itemsToDrop.stream().mapToInt(Integer::intValue).toArray();
    }
}
