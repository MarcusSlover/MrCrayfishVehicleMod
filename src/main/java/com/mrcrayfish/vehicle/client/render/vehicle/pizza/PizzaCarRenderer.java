package com.mrcrayfish.vehicle.client.render.vehicle.pizza;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mrcrayfish.vehicle.client.EntityRayTracer;
import com.mrcrayfish.vehicle.client.model.SpecialModels;
import com.mrcrayfish.vehicle.client.render.AbstractLandVehicleRenderer;
import com.mrcrayfish.vehicle.client.render.Axis;
import com.mrcrayfish.vehicle.entity.LandVehicleEntity;
import com.mrcrayfish.vehicle.entity.VehicleProperties;
import com.mrcrayfish.vehicle.util.RenderUtil;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;

public abstract class PizzaCarRenderer<T extends LandVehicleEntity & EntityRayTracer.IEntityRayTraceable> extends AbstractLandVehicleRenderer<T> {
    public PizzaCarRenderer(VehicleProperties defaultProperties) {
        super(defaultProperties);
    }

    public abstract RegistryObject<EntityType<T>> getEntity();

    public abstract SpecialModels getModel();

    public boolean isTransporter() {
        return false;
    }

    @Override
    protected void render(@Nullable T vehicle, MatrixStack matrixStack, IRenderTypeBuffer renderTypeBuffer, float partialTicks, int light) {
        this.renderDamagedPart(vehicle, this.getModel().getModel(), matrixStack, renderTypeBuffer, light);

        //Render the handles bars
        matrixStack.pushPose();
        // Positions the steering wheel in the correct position
        matrixStack.translate(-0.3125, 0.35, 0.2);
        matrixStack.mulPose(Axis.POSITIVE_X.rotationDegrees(-45F));
        matrixStack.translate(0, -0.02, 0);
        matrixStack.scale(0.75F, 0.75F, 0.75F);

        if (vehicle != null) {
            // Rotates the steering wheel based on the wheel angle
            float wheelAngle = vehicle.prevWheelAngle + (vehicle.wheelAngle - vehicle.prevWheelAngle) * partialTicks;
            float wheelAngleNormal = wheelAngle / 45F;
            float turnRotation = wheelAngleNormal * 25F;
            matrixStack.mulPose(Axis.POSITIVE_Y.rotationDegrees(turnRotation));
        }

        RenderUtil.renderColoredModel(SpecialModels.GO_KART_STEERING_WHEEL.getModel(), ItemCameraTransforms.TransformType.NONE, false, matrixStack, renderTypeBuffer, -1, light, OverlayTexture.NO_OVERLAY);

        matrixStack.popPose();
    }

    @Override
    public void applyPlayerModel(T entity, PlayerEntity player, PlayerModel<AbstractClientPlayerEntity> model, float partialTicks) {
        int index = entity.getSeatTracker().getSeatIndex(player.getUUID());
        if (index < 2) { // sitting in the front
            model.rightLeg.xRot = (float) Math.toRadians(-80F);
            model.rightLeg.yRot = (float) Math.toRadians(15F);
            model.leftLeg.xRot = (float) Math.toRadians(-80F);
            model.leftLeg.yRot = (float) Math.toRadians(-15F);
            if (index == 1) {
                model.leftArm.xRot = (float) Math.toRadians(-75F);
                model.leftArm.yRot = (float) Math.toRadians(-25F);
                model.leftArm.zRot = 0F;
            }
        } else {
            if (this.isTransporter()) {
                model.leftLeg.xRot = (float) Math.toRadians(-80F);
                model.leftLeg.yRot = (float) Math.toRadians(-15F);
            } else {
                if (index == 3) {
                    model.rightLeg.xRot = (float) Math.toRadians(-90F);
                    model.rightLeg.yRot = (float) Math.toRadians(15F);
                    model.leftLeg.xRot = (float) Math.toRadians(-90F);
                    model.leftLeg.yRot = (float) Math.toRadians(-15F);
                    model.rightArm.xRot = (float) Math.toRadians(-75F);
                    model.rightArm.yRot = (float) Math.toRadians(110F);
                    model.rightArm.zRot = (float) Math.toRadians(0F);
                    model.leftArm.xRot = (float) Math.toRadians(-105F);
                    model.leftArm.yRot = (float) Math.toRadians(-20F);
                    model.leftArm.zRot = 0F;
                } else {
                    model.rightLeg.xRot = (float) Math.toRadians(0F);
                    model.rightLeg.yRot = (float) Math.toRadians(0F);
                    model.leftLeg.xRot = (float) Math.toRadians(0F);
                    model.leftLeg.yRot = (float) Math.toRadians(0F);
                    model.rightArm.xRot = (float) Math.toRadians(-10F);
                    model.rightArm.zRot = (float) Math.toRadians(25F);
                    model.leftArm.xRot = (float) Math.toRadians(-80F);
                    model.leftArm.zRot = 0F;
                    model.leftLeg.xRot = (float) Math.toRadians(-20F);
                    model.rightLeg.xRot = (float) Math.toRadians(20F);
                }
            }
        }

        if (entity.getControllingPassenger() == player) {
            float wheelAngle = entity.prevRenderWheelAngle + (entity.renderWheelAngle - entity.prevRenderWheelAngle) * partialTicks;
            float wheelAngleNormal = wheelAngle / 45F;
            float turnRotation = wheelAngleNormal * 6F;
            model.rightArm.xRot = (float) Math.toRadians(-65F - turnRotation);
            model.rightArm.yRot = (float) Math.toRadians(-7F);
            model.leftArm.xRot = (float) Math.toRadians(-65F + turnRotation);
            model.leftArm.yRot = (float) Math.toRadians(7F);
        }
    }

    @Nullable
    @Override
    public EntityRayTracer.IRayTraceTransforms getRayTraceTransforms() {
        return (tracer, transforms, parts) ->
        {
            EntityRayTracer.createTransformListForPart(this.getModel(), parts, transforms);
            EntityRayTracer.createTransformListForPart(SpecialModels.GO_KART_STEERING_WHEEL, parts, transforms,
                    EntityRayTracer.MatrixTransformation.createTranslation(-0.3125F, 0.35F, 0.2F),
                    EntityRayTracer.MatrixTransformation.createRotation(Axis.POSITIVE_X, -45F),
                    EntityRayTracer.MatrixTransformation.createTranslation(0.0F, -0.02F, 0.0F),
                    EntityRayTracer.MatrixTransformation.createScale(0.75F));
            EntityRayTracer.createFuelPartTransforms(this.getEntity().get(), SpecialModels.FUEL_DOOR_CLOSED, parts, transforms);
            EntityRayTracer.createKeyPortTransforms(this.getEntity().get(), parts, transforms);
        };
    }
}
