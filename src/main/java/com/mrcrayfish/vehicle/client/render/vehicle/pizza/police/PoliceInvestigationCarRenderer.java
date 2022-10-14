package com.mrcrayfish.vehicle.client.render.vehicle.pizza.police;

import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.vehicle.pizza.PizzaCarRenderer;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.police.PoliceInvestigationCarEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.police.PoliceTransportCarEntity;
import com.mrcrayfish.vehicle.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class PoliceInvestigationCarRenderer extends PizzaCarRenderer<PoliceInvestigationCarEntity> {
    public PoliceInvestigationCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    @Override
    public RegistryObject<EntityType<PoliceInvestigationCarEntity>> getEntity() {
        return ModEntities.POLICE_INVESTIGATION_CAR;
    }

    @Override
    public SpecialModels getModel() {
        return SpecialModels.POLICE_INVESTIGATION_CAR_BODY;
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
