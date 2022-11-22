package com.mrcrayfish.vehicle.entity.vehicle;

import com.mrcrayfish.vehicle.entity.EngineTier;
import com.mrcrayfish.vehicle.entity.IEngineTier;
import com.mrcrayfish.vehicle.entity.MotorcycleEntity;
import com.mrcrayfish.vehicle.init.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Optional;

/**
 * Author: MrCrayfish
 */
public class DirtBikeEntity extends MotorcycleEntity
{
    public DirtBikeEntity(EntityType<? extends DirtBikeEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.setMaxSpeed(18F);
        this.setMaxTurnAngle(35);
        this.setFuelCapacity(20000F);
        this.setFuelConsumption(0.35F);
    }

    @Override
    public SoundEvent getEngineSound()
    {
        return ModSounds.ENTITY_DIRT_BIKE_ENGINE.get();
    }

    @Override
    public float getMinEnginePitch()
    {
        return 0.85F;
    }

    @Override
    public float getMaxEnginePitch()
    {
        return 1.5F;
    }

    @Override
    public boolean shouldShowEngineSmoke()
    {
        return true;
    }

    @Override
    public Vector3d getEngineSmokePosition()
    {
        return new Vector3d(-0.0625, 1.25, -1);
    }

    @Override
    public boolean canBeColored()
    {
        return true;
    }

    @Override
    public boolean shouldRenderEngine()
    {
        return true;
    }

    @Override
    public FuelPortType getFuelPortType()
    {
        return FuelPortType.SMALL;
    }

    @Override
    public boolean isLockable()
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
                    return 10F;
                }
                if (tier == EngineTier.GOLD) {
                    return 8F;
                }
                if (tier == EngineTier.IRON) {
                    return 6F;
                }
            }
            maxSpeed += engineTier.get().getAdditionalMaxSpeed();
        }
        return maxSpeed;
    }
}
