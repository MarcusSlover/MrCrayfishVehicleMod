package com.mrcrayfish.vehicle.client.render.vehicle.pizza.police;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.police.PoliceCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.police.PoliceTransportCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class PoliceTransportCarRenderer extends PizzaCarRenderer<PoliceTransportCarEntity> {
    public PoliceTransportCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<PoliceTransportCarEntity>> getEntity() {
        return ModEntities.POLICE_TRANSPORT_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.POLICE_TRANSPORT_CAR_BODY;
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
