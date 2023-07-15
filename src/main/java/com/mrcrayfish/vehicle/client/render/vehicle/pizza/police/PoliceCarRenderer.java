package com.mrcrayfish.vehicle.client.render.vehicle.pizza.police;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.pizza.PizzaBrewCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.police.PoliceCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class PoliceCarRenderer extends PizzaCarRenderer<PoliceCarEntity> {
    public PoliceCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<PoliceCarEntity>> getEntity() {
        return ModEntities.POLICE_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.POLICE_CAR_BODY;
    }
}
