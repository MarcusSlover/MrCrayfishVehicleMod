package com.mrcrayfish.vehicle.entity.vehicle;

import com.mrcrayfish.vehicle.entity.EngineTier;
import com.mrcrayfish.vehicle.entity.IEngineTier;
import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Optional;

/**
 * Author: MrCrayfish
 */
public class OffRoaderEntity extends LandVehicleEntity
{
    public OffRoaderEntity(EntityType<? extends OffRoaderEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.setMaxSpeed(18F);
        this.setFuelCapacity(25000F);
    }

    @Override
    public SoundEvent getEngineSound()
    {
        return ModSounds.ENTITY_SPEED_BOAT_ENGINE.get();
    }

    @Override
    public float getMinEnginePitch()
    {
        return 0.8F;
    }

    @Override
    public float getMaxEnginePitch()
    {
        return 1.6F;
    }

    @Override
    public boolean canBeColored()
    {
        return true;
    }

    @Override
    public boolean canMountTrailer()
    {
        return false;
    }


    @Override
    public float getActualMaxSpeed()
    {
        float maxSpeed = this.entityData.get(MAX_SPEED);
        Optional<IEngineTier> engineTier = this.getEngineTier();
        if(engineTier.isPresent()) {

            IEngineTier iEngineTier = engineTier.get();
            if (iEngineTier instanceof EngineTier) {
                EngineTier tier = (EngineTier) iEngineTier;
                if (tier == EngineTier.DIAMOND || tier == EngineTier.NETHERITE) {
                    return 15F;
                }
                if (tier == EngineTier.GOLD) {
                    return 13F;
                }
                if (tier == EngineTier.IRON) {
                    return 11F;
                }
            }
            maxSpeed += engineTier.get().getAdditionalMaxSpeed();
        }
        return maxSpeed;
    }
}
