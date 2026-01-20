package aqario.headstones.client.model;

import aqario.headstones.client.render.GraveRenderState;
import aqario.headstones.common.Headstones;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class GraveModel extends EntityModel<GraveRenderState> {
    public static final ModelLayerLocation DEFAULT_LAYER = new ModelLayerLocation(Headstones.id("grave_default"), "main");
    public static final ModelLayerLocation PLAYER_LAYER = new ModelLayerLocation(Headstones.id("grave_player"), "main");

    public GraveModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createDefaultLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();

        modelPartData
            .addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        return LayerDefinition.create(modelData, 64, 32);
    }

    public static LayerDefinition createPlayerLayer() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();

        modelPartData
            .addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F))
            .addOrReplaceChild("hat", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.ZERO);

        return LayerDefinition.create(modelData, 64, 64);
    }
}