package aqario.headstones.client.render;

import aqario.headstones.client.PlayerInfoCache;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import org.jspecify.annotations.Nullable;

public class GraveRenderState extends EntityRenderState {
    @Nullable
    public PlayerInfoCache owner;
    public float bobOffset;
}
