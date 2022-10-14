package com.mrcrayfish.vehicle.client.render.vehicle.pizza.pizza;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.pizza.PizzaBrewCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.pizza.PizzaTeamCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class PizzaTeamCarRenderer extends PizzaCarRenderer<PizzaTeamCarEntity> {
    public PizzaTeamCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<PizzaTeamCarEntity>> getEntity() {
        return ModEntities.PIZZA_TEAM_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.PIZZA_TEAM_CAR_BODY;
    }
}
