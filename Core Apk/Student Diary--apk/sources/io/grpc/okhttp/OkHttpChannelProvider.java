package io.grpc.okhttp;

import io.grpc.InternalServiceProviders;
import io.grpc.ManagedChannelProvider;

public final class OkHttpChannelProvider extends ManagedChannelProvider {
    public boolean isAvailable() {
        return true;
    }

    public int priority() {
        return InternalServiceProviders.isAndroid(getClass().getClassLoader()) ? 8 : 3;
    }

    public OkHttpChannelBuilder builderForAddress(String name, int port) {
        return OkHttpChannelBuilder.forAddress(name, port);
    }

    public OkHttpChannelBuilder builderForTarget(String target) {
        return OkHttpChannelBuilder.forTarget(target);
    }
}
