package com.mrcrayfish.vehicle.entity.vehicle.pizza.police;

import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.PizzaCarEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish & MarcusSlover
 */
public class PoliceInvestigationCarEntity extends PizzaCarEntity<PoliceInvestigationCarEntity>
{
    public PoliceInvestigationCarEntity(EntityType<PoliceInvestigationCarEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    @Override
    public boolean isTransporter() {
        return true;
    }
}
