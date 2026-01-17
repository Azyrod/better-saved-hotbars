package cz.lukynka.bettersavedhotbars.protocol;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

public record ModInstalledPacket(String version) implements CustomPacketPayload {

    public static final Identifier RESOURCE_LOCATION = Identifier.fromNamespaceAndPath("better_saved_hotbars", "mod_installed");
    public static final CustomPacketPayload.Type<ModInstalledPacket> TYPE = new CustomPacketPayload.Type<>(RESOURCE_LOCATION);

    public static StreamCodec<ByteBuf, ModInstalledPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, ModInstalledPacket::version, ModInstalledPacket::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
