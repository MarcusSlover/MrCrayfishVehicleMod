package com.mrcrayfish.vehicle.entity.vehicle.pizza.police;

import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.entity.vehicle.pizza.PizzaCarEntity;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Author: MrCrayfish & MarcusSlover
 */
public class PoliceTransportCarEntity extends PizzaCarEntity<PoliceTransportCarEntity>
{
    public PoliceTransportCarEntity(EntityType<PoliceTransportCarEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    @Override
    public boolean isTransporter() {
        return true;
    }

    public SoundEvent getHornSound()
    {
        return ModSounds.ENTITY_POLICE_HORN.get();
    }
}
