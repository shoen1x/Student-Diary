package io.grpc.stub;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class ClientCalls {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final CallOptions.Key<StubType> STUB_TYPE_OPTION = CallOptions.Key.create("internal-stub-type");
    private static final Logger logger = Logger.getLogger(ClientCalls.class.getName());

    enum StubType {
        BLOCKING,
        FUTURE,
        ASYNC
    }

    private ClientCalls() {
    }

    public static <ReqT, RespT> void asyncUnaryCall(ClientCall<ReqT, RespT> call, ReqT req, StreamObserver<RespT> responseObserver) {
        asyncUnaryRequestCall(call, req, responseObserver, false);
    }

    public static <ReqT, RespT> void asyncServerStreamingCall(ClientCall<ReqT, RespT> call, ReqT req, StreamObserver<RespT> responseObserver) {
        asyncUnaryRequestCall(call, req, responseObserver, true);
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncClientStreamingCall(ClientCall<ReqT, RespT> call, StreamObserver<RespT> responseObserver) {
        return asyncStreamingRequestCall(call, responseObserver, false);
    }

    public static <ReqT, RespT> StreamObserver<ReqT> asyncBidiStreamingCall(ClientCall<ReqT, RespT> call, StreamObserver<RespT> responseObserver) {
        return asyncStreamingRequestCall(call, responseObserver, true);
    }

    public static <ReqT, RespT> RespT blockingUnaryCall(ClientCall<ReqT, RespT> call, ReqT req) {
        try {
            return getUnchecked(futureUnaryCall(call, req));
        } catch (RuntimeException e) {
            throw cancelThrow(call, e);
        } catch (Error e2) {
            throw cancelThrow(call, e2);
        }
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [io.grpc.MethodDescriptor, io.grpc.MethodDescriptor<ReqT, RespT>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <ReqT, RespT> RespT blockingUnaryCall(io.grpc.Channel r6, io.grpc.MethodDescriptor<ReqT, RespT> r7, io.grpc.CallOptions r8, ReqT r9) {
        /*
            io.grpc.stub.ClientCalls$ThreadlessExecutor r0 = new io.grpc.stub.ClientCalls$ThreadlessExecutor
            r0.<init>()
            r1 = 0
            io.grpc.CallOptions r2 = r8.withExecutor(r0)
            io.grpc.ClientCall r2 = r6.newCall(r7, r2)
            com.google.common.util.concurrent.ListenableFuture r3 = futureUnaryCall(r2, r9)     // Catch:{ RuntimeException -> 0x003a, Error -> 0x0034 }
        L_0x0012:
            boolean r4 = r3.isDone()     // Catch:{ RuntimeException -> 0x003a, Error -> 0x0034 }
            if (r4 != 0) goto L_0x0024
            r0.waitAndDrain()     // Catch:{ InterruptedException -> 0x001c }
        L_0x001b:
            goto L_0x0012
        L_0x001c:
            r4 = move-exception
            r1 = 1
            java.lang.String r5 = "Thread interrupted"
            r2.cancel(r5, r4)     // Catch:{ RuntimeException -> 0x003a, Error -> 0x0034 }
            goto L_0x001b
        L_0x0024:
            java.lang.Object r4 = getUnchecked(r3)     // Catch:{ RuntimeException -> 0x003a, Error -> 0x0034 }
            if (r1 == 0) goto L_0x0031
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            r5.interrupt()
        L_0x0031:
            return r4
        L_0x0032:
            r3 = move-exception
            goto L_0x0040
        L_0x0034:
            r3 = move-exception
            java.lang.RuntimeException r4 = cancelThrow(r2, r3)     // Catch:{ all -> 0x0032 }
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x003a:
            r3 = move-exception
            java.lang.RuntimeException r4 = cancelThrow(r2, r3)     // Catch:{ all -> 0x0032 }
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0040:
            if (r1 == 0) goto L_0x0049
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r4.interrupt()
        L_0x0049:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.stub.ClientCalls.blockingUnaryCall(io.grpc.Channel, io.grpc.MethodDescriptor, io.grpc.CallOptions, java.lang.Object):java.lang.Object");
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(ClientCall<ReqT, RespT> call, ReqT req) {
        BlockingResponseStream<RespT> result = new BlockingResponseStream<>(call);
        asyncUnaryRequestCall(call, req, result.listener(), true);
        return result;
    }

    public static <ReqT, RespT> Iterator<RespT> blockingServerStreamingCall(Channel channel, MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, ReqT req) {
        ThreadlessExecutor executor = new ThreadlessExecutor();
        ClientCall<ReqT, RespT> call = channel.newCall(method, callOptions.withExecutor(executor));
        BlockingResponseStream<RespT> result = new BlockingResponseStream<>(call, executor);
        asyncUnaryRequestCall(call, req, result.listener(), true);
        return result;
    }

    public static <ReqT, RespT> ListenableFuture<RespT> futureUnaryCall(ClientCall<ReqT, RespT> call, ReqT req) {
        GrpcFuture<RespT> responseFuture = new GrpcFuture<>(call);
        asyncUnaryRequestCall(call, req, new UnaryStreamToFuture(responseFuture), false);
        return responseFuture;
    }

    private static <V> V getUnchecked(Future<V> future) {
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw Status.CANCELLED.withDescription("Thread interrupted").withCause(e).asRuntimeException();
        } catch (ExecutionException e2) {
            throw toStatusRuntimeException(e2.getCause());
        }
    }

    private static StatusRuntimeException toStatusRuntimeException(Throwable t) {
        Throwable cause = (Throwable) Preconditions.checkNotNull(t, "t");
        while (cause != null) {
            if (cause instanceof StatusException) {
                StatusException se = (StatusException) cause;
                return new StatusRuntimeException(se.getStatus(), se.getTrailers());
            } else if (cause instanceof StatusRuntimeException) {
                StatusRuntimeException se2 = (StatusRuntimeException) cause;
                return new StatusRuntimeException(se2.getStatus(), se2.getTrailers());
            } else {
                cause = cause.getCause();
            }
        }
        return Status.UNKNOWN.withDescription("unexpected exception").withCause(t).asRuntimeException();
    }

    private static RuntimeException cancelThrow(ClientCall<?, ?> call, Throwable t) {
        try {
            call.cancel((String) null, t);
        } catch (Throwable e) {
            logger.log(Level.SEVERE, "RuntimeException encountered while closing call", e);
        }
        if (t instanceof RuntimeException) {
            throw ((RuntimeException) t);
        } else if (t instanceof Error) {
            throw ((Error) t);
        } else {
            throw new AssertionError(t);
        }
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> call, ReqT req, StreamObserver<RespT> responseObserver, boolean streamingResponse) {
        asyncUnaryRequestCall(call, req, new StreamObserverToCallListenerAdapter(responseObserver, new CallToStreamObserverAdapter(call), streamingResponse), streamingResponse);
    }

    private static <ReqT, RespT> void asyncUnaryRequestCall(ClientCall<ReqT, RespT> call, ReqT req, ClientCall.Listener<RespT> responseListener, boolean streamingResponse) {
        startCall(call, responseListener, streamingResponse);
        try {
            call.sendMessage(req);
            call.halfClose();
        } catch (RuntimeException e) {
            throw cancelThrow(call, e);
        } catch (Error e2) {
            throw cancelThrow(call, e2);
        }
    }

    private static <ReqT, RespT> StreamObserver<ReqT> asyncStreamingRequestCall(ClientCall<ReqT, RespT> call, StreamObserver<RespT> responseObserver, boolean streamingResponse) {
        CallToStreamObserverAdapter<ReqT> adapter = new CallToStreamObserverAdapter<>(call);
        startCall(call, new StreamObserverToCallListenerAdapter(responseObserver, adapter, streamingResponse), streamingResponse);
        return adapter;
    }

    private static <ReqT, RespT> void startCall(ClientCall<ReqT, RespT> call, ClientCall.Listener<RespT> responseListener, boolean streamingResponse) {
        call.start(responseListener, new Metadata());
        if (streamingResponse) {
            call.request(1);
        } else {
            call.request(2);
        }
    }

    private static final class CallToStreamObserverAdapter<T> extends ClientCallStreamObserver<T> {
        private boolean aborted = false;
        /* access modifiers changed from: private */
        public boolean autoFlowControlEnabled = true;
        private final ClientCall<T, ?> call;
        private boolean completed = false;
        private boolean frozen;
        /* access modifiers changed from: private */
        public Runnable onReadyHandler;

        CallToStreamObserverAdapter(ClientCall<T, ?> call2) {
            this.call = call2;
        }

        /* access modifiers changed from: private */
        public void freeze() {
            this.frozen = true;
        }

        public void onNext(T value) {
            Preconditions.checkState(!this.aborted, "Stream was terminated by error, no further calls are allowed");
            Preconditions.checkState(!this.completed, "Stream is already completed, no further calls are allowed");
            this.call.sendMessage(value);
        }

        public void onError(Throwable t) {
            this.call.cancel("Cancelled by client with StreamObserver.onError()", t);
            this.aborted = true;
        }

        public void onCompleted() {
            this.call.halfClose();
            this.completed = true;
        }

        public boolean isReady() {
            return this.call.isReady();
        }

        public void setOnReadyHandler(Runnable onReadyHandler2) {
            if (!this.frozen) {
                this.onReadyHandler = onReadyHandler2;
                return;
            }
            throw new IllegalStateException("Cannot alter onReadyHandler after call started. Use ClientResponseObserver");
        }

        public void disableAutoInboundFlowControl() {
            if (!this.frozen) {
                this.autoFlowControlEnabled = false;
                return;
            }
            throw new IllegalStateException("Cannot disable auto flow control after call started. Use ClientResponseObserver");
        }

        public void request(int count) {
            this.call.request(count);
        }

        public void setMessageCompression(boolean enable) {
            this.call.setMessageCompression(enable);
        }

        public void cancel(@Nullable String message, @Nullable Throwable cause) {
            this.call.cancel(message, cause);
        }
    }

    private static final class StreamObserverToCallListenerAdapter<ReqT, RespT> extends ClientCall.Listener<RespT> {
        private final CallToStreamObserverAdapter<ReqT> adapter;
        private boolean firstResponseReceived;
        private final StreamObserver<RespT> observer;
        private final boolean streamingResponse;

        StreamObserverToCallListenerAdapter(StreamObserver<RespT> observer2, CallToStreamObserverAdapter<ReqT> adapter2, boolean streamingResponse2) {
            this.observer = observer2;
            this.streamingResponse = streamingResponse2;
            this.adapter = adapter2;
            if (observer2 instanceof ClientResponseObserver) {
                ((ClientResponseObserver) observer2).beforeStart(adapter2);
            }
            adapter2.freeze();
        }

        public void onHeaders(Metadata headers) {
        }

        public void onMessage(RespT message) {
            if (!this.firstResponseReceived || this.streamingResponse) {
                this.firstResponseReceived = true;
                this.observer.onNext(message);
                if (this.streamingResponse && this.adapter.autoFlowControlEnabled) {
                    this.adapter.request(1);
                    return;
                }
                return;
            }
            throw Status.INTERNAL.withDescription("More than one responses received for unary or client-streaming call").asRuntimeException();
        }

        public void onClose(Status status, Metadata trailers) {
            if (status.isOk()) {
                this.observer.onCompleted();
            } else {
                this.observer.onError(status.asRuntimeException(trailers));
            }
        }

        public void onReady() {
            if (this.adapter.onReadyHandler != null) {
                this.adapter.onReadyHandler.run();
            }
        }
    }

    private static final class UnaryStreamToFuture<RespT> extends ClientCall.Listener<RespT> {
        private final GrpcFuture<RespT> responseFuture;
        private RespT value;

        UnaryStreamToFuture(GrpcFuture<RespT> responseFuture2) {
            this.responseFuture = responseFuture2;
        }

        public void onHeaders(Metadata headers) {
        }

        public void onMessage(RespT value2) {
            if (this.value == null) {
                this.value = value2;
                return;
            }
            throw Status.INTERNAL.withDescription("More than one value received for unary call").asRuntimeException();
        }

        public void onClose(Status status, Metadata trailers) {
            if (status.isOk()) {
                if (this.value == null) {
                    this.responseFuture.setException(Status.INTERNAL.withDescription("No value received for unary call").asRuntimeException(trailers));
                }
                this.responseFuture.set(this.value);
                return;
            }
            this.responseFuture.setException(status.asRuntimeException(trailers));
        }
    }

    private static final class GrpcFuture<RespT> extends AbstractFuture<RespT> {
        private final ClientCall<?, RespT> call;

        GrpcFuture(ClientCall<?, RespT> call2) {
            this.call = call2;
        }

        /* access modifiers changed from: protected */
        public void interruptTask() {
            this.call.cancel("GrpcFuture was cancelled", (Throwable) null);
        }

        /* access modifiers changed from: protected */
        public boolean set(@Nullable RespT resp) {
            return super.set(resp);
        }

        /* access modifiers changed from: protected */
        public boolean setException(Throwable throwable) {
            return super.setException(throwable);
        }

        /* access modifiers changed from: protected */
        public String pendingToString() {
            return MoreObjects.toStringHelper((Object) this).add("clientCall", (Object) this.call).toString();
        }
    }

    private static final class BlockingResponseStream<T> implements Iterator<T> {
        /* access modifiers changed from: private */
        public final BlockingQueue<Object> buffer;
        private final ClientCall<?, T> call;
        private Object last;
        private final ClientCall.Listener<T> listener;
        private final ThreadlessExecutor threadless;

        BlockingResponseStream(ClientCall<?, T> call2) {
            this(call2, (ThreadlessExecutor) null);
        }

        BlockingResponseStream(ClientCall<?, T> call2, ThreadlessExecutor threadless2) {
            this.buffer = new ArrayBlockingQueue(2);
            this.listener = new QueuingListener();
            this.call = call2;
            this.threadless = threadless2;
        }

        /* access modifiers changed from: package-private */
        public ClientCall.Listener<T> listener() {
            return this.listener;
        }

        private Object waitForNext() {
            Object next;
            Object take;
            boolean interrupt = false;
            try {
                if (this.threadless == null) {
                    while (true) {
                        take = this.buffer.take();
                        break;
                    }
                    if (interrupt) {
                        Thread.currentThread().interrupt();
                    }
                    return take;
                }
                while (true) {
                    Object poll = this.buffer.poll();
                    next = poll;
                    if (poll != null) {
                        break;
                    }
                    try {
                        this.threadless.waitAndDrain();
                    } catch (InterruptedException ie) {
                        interrupt = true;
                        this.call.cancel("Thread interrupted", ie);
                    }
                }
                if (interrupt) {
                    Thread.currentThread().interrupt();
                }
                return next;
            } catch (InterruptedException ie2) {
                interrupt = true;
                this.call.cancel("Thread interrupted", ie2);
            } catch (Throwable th) {
                if (interrupt) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }

        public boolean hasNext() {
            Object obj;
            while (true) {
                obj = this.last;
                if (obj != null) {
                    break;
                }
                this.last = waitForNext();
            }
            if (!(obj instanceof StatusRuntimeException)) {
                return obj != this;
            }
            StatusRuntimeException e = (StatusRuntimeException) obj;
            throw e.getStatus().asRuntimeException(e.getTrailers());
        }

        public T next() {
            if (hasNext()) {
                try {
                    this.call.request(1);
                    return this.last;
                } finally {
                    this.last = null;
                }
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private final class QueuingListener extends ClientCall.Listener<T> {
            private boolean done = false;

            QueuingListener() {
            }

            public void onHeaders(Metadata headers) {
            }

            public void onMessage(T value) {
                Preconditions.checkState(!this.done, "ClientCall already closed");
                BlockingResponseStream.this.buffer.add(value);
            }

            public void onClose(Status status, Metadata trailers) {
                Preconditions.checkState(!this.done, "ClientCall already closed");
                if (status.isOk()) {
                    BlockingResponseStream.this.buffer.add(BlockingResponseStream.this);
                } else {
                    BlockingResponseStream.this.buffer.add(status.asRuntimeException(trailers));
                }
                this.done = true;
            }
        }
    }

    private static final class ThreadlessExecutor extends ConcurrentLinkedQueue<Runnable> implements Executor {
        private static final Logger log = Logger.getLogger(ThreadlessExecutor.class.getName());
        private volatile Thread waiter;

        ThreadlessExecutor() {
        }

        public void waitAndDrain() throws InterruptedException {
            Runnable runnable;
            throwIfInterrupted();
            Runnable runnable2 = (Runnable) poll();
            if (runnable2 == null) {
                this.waiter = Thread.currentThread();
                while (true) {
                    try {
                        Runnable runnable3 = (Runnable) poll();
                        runnable2 = runnable3;
                        if (runnable3 != null) {
                            break;
                        }
                        LockSupport.park(this);
                        throwIfInterrupted();
                    } finally {
                        this.waiter = null;
                    }
                }
            }
            do {
                try {
                    runnable2.run();
                } catch (Throwable t) {
                    log.log(Level.WARNING, "Runnable threw exception", t);
                }
                runnable = (Runnable) poll();
                runnable2 = runnable;
            } while (runnable != null);
        }

        private static void throwIfInterrupted() throws InterruptedException {
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }

        public void execute(Runnable runnable) {
            add(runnable);
            LockSupport.unpark(this.waiter);
        }
    }
}
