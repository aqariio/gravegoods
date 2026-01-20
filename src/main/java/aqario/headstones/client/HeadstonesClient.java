package aqario.headstones.client;

import aqario.headstones.client.model.GraveModel;
import aqario.headstones.client.render.GraveRenderer;
import aqario.headstones.common.entity.HeadstonesEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class HeadstonesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRenderers.register(HeadstonesEntityTypes.GRAVE, GraveRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(GraveModel.DEFAULT_LAYER, GraveModel::createDefaultLayer);
        EntityModelLayerRegistry.registerModelLayer(GraveModel.PLAYER_LAYER, GraveModel::createPlayerLayer);
    }
}
