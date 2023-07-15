package com.mrcrayfish.vehicle.client.render.vehicle.pizza.pizza;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.pizza.PizzaTokensCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class PizzaTokensCarRenderer extends PizzaCarRenderer<PizzaTokensCarEntity> {
    public PizzaTokensCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<PizzaTokensCarEntity>> getEntity() {
        return ModEntities.PIZZA_TOKENS_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.PIZZA_TOKENS_BODY;
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
