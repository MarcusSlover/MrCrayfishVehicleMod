package com.mrcrayfish.vehicle.client.render.vehicle.pizza.service;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.AmazonCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.PostCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class AmazonCarRenderer extends PizzaCarRenderer<AmazonCarEntity> {
    public AmazonCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<AmazonCarEntity>> getEntity() {
        return ModEntities.AMAZON_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.AMAZON_CAR_BODY;
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
