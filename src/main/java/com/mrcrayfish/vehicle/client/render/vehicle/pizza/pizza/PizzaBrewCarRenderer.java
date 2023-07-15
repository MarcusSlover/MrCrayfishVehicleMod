package com.mrcrayfish.vehicle.client.render.vehicle.pizza.pizza;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.pizza.PizzaBrewCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class PizzaBrewCarRenderer extends PizzaCarRenderer<PizzaBrewCarEntity> {
    public PizzaBrewCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<PizzaBrewCarEntity>> getEntity() {
        return ModEntities.PIZZA_BREW_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.PIZZA_BREW_CAR_BODY;
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
