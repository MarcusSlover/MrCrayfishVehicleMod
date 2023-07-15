package com.mrcrayfish.vehicle.client.render.vehicle.pizza.service;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.PizzaCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.PostCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.TaxiCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class PostCarRenderer extends PizzaCarRenderer<PostCarEntity> {
    public PostCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<PostCarEntity>> getEntity() {
        return ModEntities.POST_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.POST_CAR_BODY;
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
