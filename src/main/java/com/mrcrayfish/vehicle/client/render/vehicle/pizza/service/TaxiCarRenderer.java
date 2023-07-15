package com.mrcrayfish.vehicle.client.render.vehicle.pizza.service;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.police.PoliceInvestigationCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.TaxiCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class TaxiCarRenderer extends PizzaCarRenderer<TaxiCarEntity> {
    public TaxiCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<TaxiCarEntity>> getEntity() {
        return ModEntities.TAXI_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.TAXI_CAR_BODY;
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
