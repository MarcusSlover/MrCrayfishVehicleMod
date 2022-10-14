package com.mrcrayfish.vehicle.client.render.vehicle.pizza.service;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.AmbulanceCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.FireCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class FireCarRenderer extends PizzaCarRenderer<FireCarEntity> {
    public FireCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<FireCarEntity>> getEntity() {
        return ModEntities.FIRE_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.FIRE_BODY;
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
