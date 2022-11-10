package io.grpc.internal;

import com.google.common.base.Preconditions;
import io.grpc.ChannelLogger;
import io.grpc.InternalChannelz;
import io.grpc.InternalLogId;
import java.text.MessageFormat;
import java.util.logging.Level;

final class ChannelLoggerImpl extends ChannelLogger {
    private final TimeProvider time;
    private final ChannelTracer tracer;

    ChannelLoggerImpl(ChannelTracer tracer2, TimeProvider time2) {
        this.tracer = (ChannelTracer) Preconditions.checkNotNull(tracer2, "tracer");
        this.time = (TimeProvider) Preconditions.checkNotNull(time2, "time");
    }

    public void log(ChannelLogger.ChannelLogLevel level, String msg) {
        logOnly(this.tracer.getLogId(), level, msg);
        if (isTraceable(level)) {
            trace(level, msg);
        }
    }

    public void log(ChannelLogger.ChannelLogLevel level, String messageFormat, Object... args) {
        String msg = null;
        Level javaLogLevel = toJavaLogLevel(level);
        if (isTraceable(level) || ChannelTracer.logger.isLoggable(javaLogLevel)) {
            msg = MessageFormat.format(messageFormat, args);
        }
        log(level, msg);
    }

    static void logOnly(InternalLogId logId, ChannelLogger.ChannelLogLevel level, String msg) {
        Level javaLogLevel = toJavaLogLevel(level);
        if (ChannelTracer.logger.isLoggable(javaLogLevel)) {
            ChannelTracer.logOnly(logId, javaLogLevel, msg);
        }
    }

    static void logOnly(InternalLogId logId, ChannelLogger.ChannelLogLevel level, String messageFormat, Object... args) {
        Level javaLogLevel = toJavaLogLevel(level);
        if (ChannelTracer.logger.isLoggable(javaLogLevel)) {
            ChannelTracer.logOnly(logId, javaLogLevel, MessageFormat.format(messageFormat, args));
        }
    }

    private boolean isTraceable(ChannelLogger.ChannelLogLevel level) {
        return level != ChannelLogger.ChannelLogLevel.DEBUG && this.tracer.isTraceEnabled();
    }

    private void trace(ChannelLogger.ChannelLogLevel level, String msg) {
        if (level != ChannelLogger.ChannelLogLevel.DEBUG) {
            this.tracer.traceOnly(new InternalChannelz.ChannelTrace.Event.Builder().setDescription(msg).setSeverity(toTracerSeverity(level)).setTimestampNanos(this.time.currentTimeNanos()).build());
        }
    }

    /* renamed from: io.grpc.internal.ChannelLoggerImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel;

        static {
            int[] iArr = new int[ChannelLogger.ChannelLogLevel.values().length];
            $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel = iArr;
            try {
                iArr[ChannelLogger.ChannelLogLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel[ChannelLogger.ChannelLogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static InternalChannelz.ChannelTrace.Event.Severity toTracerSeverity(ChannelLogger.ChannelLogLevel level) {
        int i = AnonymousClass1.$SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel[level.ordinal()];
        if (i == 1) {
            return InternalChannelz.ChannelTrace.Event.Severity.CT_ERROR;
        }
        if (i != 2) {
            return InternalChannelz.ChannelTrace.Event.Severity.CT_INFO;
        }
        return InternalChannelz.ChannelTrace.Event.Severity.CT_WARNING;
    }

    private static Level toJavaLogLevel(ChannelLogger.ChannelLogLevel level) {
        int i = AnonymousClass1.$SwitchMap$io$grpc$ChannelLogger$ChannelLogLevel[level.ordinal()];
        if (i == 1) {
            return Level.FINE;
        }
        if (i != 2) {
            return Level.FINEST;
        }
        return Level.FINER;
    }
}
