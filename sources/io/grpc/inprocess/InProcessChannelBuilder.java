package io.grpc.inprocess;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.SharedResourceHolder;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class InProcessChannelBuilder extends AbstractManagedChannelImplBuilder<InProcessChannelBuilder> {
    private int maxInboundMetadataSize = Integer.MAX_VALUE;
    private final String name;
    private ScheduledExecutorService scheduledExecutorService;

    public static InProcessChannelBuilder forName(String name2) {
        return new InProcessChannelBuilder(name2);
    }

    public static InProcessChannelBuilder forTarget(String target) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    public static InProcessChannelBuilder forAddress(String name2, int port) {
        throw new UnsupportedOperationException("call forName() instead");
    }

    private InProcessChannelBuilder(String name2) {
        super(new InProcessSocketAddress(name2), "localhost");
        this.name = (String) Preconditions.checkNotNull(name2, AppMeasurementSdk.ConditionalUserProperty.NAME);
        setStatsRecordStartedRpcs(false);
        setStatsRecordFinishedRpcs(false);
    }

    public final InProcessChannelBuilder maxInboundMessageSize(int max) {
        return (InProcessChannelBuilder) super.maxInboundMessageSize(max);
    }

    public InProcessChannelBuilder useTransportSecurity() {
        return this;
    }

    public InProcessChannelBuilder usePlaintext() {
        return this;
    }

    public InProcessChannelBuilder keepAliveTime(long keepAliveTime, TimeUnit timeUnit) {
        return this;
    }

    public InProcessChannelBuilder keepAliveTimeout(long keepAliveTimeout, TimeUnit timeUnit) {
        return this;
    }

    public InProcessChannelBuilder keepAliveWithoutCalls(boolean enable) {
        return this;
    }

    public InProcessChannelBuilder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService2) {
        this.scheduledExecutorService = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService2, "scheduledExecutorService");
        return this;
    }

    public InProcessChannelBuilder maxInboundMetadataSize(int bytes) {
        Preconditions.checkArgument(bytes > 0, "maxInboundMetadataSize must be > 0");
        this.maxInboundMetadataSize = bytes;
        return this;
    }

    /* access modifiers changed from: protected */
    public ClientTransportFactory buildTransportFactory() {
        return new InProcessClientTransportFactory(this.name, this.scheduledExecutorService, this.maxInboundMetadataSize);
    }

    static final class InProcessClientTransportFactory implements ClientTransportFactory {
        private boolean closed;
        private final int maxInboundMetadataSize;
        private final String name;
        private final ScheduledExecutorService timerService;
        private final boolean useSharedTimer;

        private InProcessClientTransportFactory(String name2, @Nullable ScheduledExecutorService scheduledExecutorService, int maxInboundMetadataSize2) {
            this.name = name2;
            boolean z = scheduledExecutorService == null;
            this.useSharedTimer = z;
            this.timerService = z ? (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE) : scheduledExecutorService;
            this.maxInboundMetadataSize = maxInboundMetadataSize2;
        }

        public ConnectionClientTransport newClientTransport(SocketAddress addr, ClientTransportFactory.ClientTransportOptions options, ChannelLogger channelLogger) {
            if (!this.closed) {
                return new InProcessTransport(this.name, this.maxInboundMetadataSize, options.getAuthority(), options.getUserAgent(), options.getEagAttributes());
            }
            throw new IllegalStateException("The transport factory is closed.");
        }

        public ScheduledExecutorService getScheduledExecutorService() {
            return this.timerService;
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                if (this.useSharedTimer) {
                    SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timerService);
                }
            }
        }
    }
}
