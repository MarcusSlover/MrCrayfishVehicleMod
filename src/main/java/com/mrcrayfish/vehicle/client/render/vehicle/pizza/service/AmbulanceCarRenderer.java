package com.mrcrayfish.vehicle.client.render.vehicle.pizza.service;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.AmazonCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.AmbulanceCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class AmbulanceCarRenderer extends PizzaCarRenderer<AmbulanceCarEntity> {
    public AmbulanceCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<AmbulanceCarEntity>> getEntity() {
        return ModEntities.AMBULANCE_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.AMBULANCE_CAR_BODY;
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
