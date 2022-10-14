package com.mrcrayfish.vehicle.client.render.vehicle.pizza.service;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.AngelCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.service.FireCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class AngelCarRenderer extends PizzaCarRenderer<AngelCarEntity> {
    public AngelCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<AngelCarEntity>> getEntity() {
        return ModEntities.ANGEL_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.ANGEL_BODY;
    }


}
