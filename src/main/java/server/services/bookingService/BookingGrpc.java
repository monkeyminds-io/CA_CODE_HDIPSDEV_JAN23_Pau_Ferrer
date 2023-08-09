package server.services.bookingService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * This is the service declaration
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: booking.proto")
public final class BookingGrpc {

  private BookingGrpc() {}

  public static final String SERVICE_NAME = "bookingService.Booking";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.bookingService.CreateRequest,
      server.services.bookingService.Appointment> METHOD_CREATE = getCreateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.bookingService.CreateRequest,
      server.services.bookingService.Appointment> getCreateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.bookingService.CreateRequest,
      server.services.bookingService.Appointment> getCreateMethod() {
    return getCreateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.bookingService.CreateRequest,
      server.services.bookingService.Appointment> getCreateMethodHelper() {
    io.grpc.MethodDescriptor<server.services.bookingService.CreateRequest, server.services.bookingService.Appointment> getCreateMethod;
    if ((getCreateMethod = BookingGrpc.getCreateMethod) == null) {
      synchronized (BookingGrpc.class) {
        if ((getCreateMethod = BookingGrpc.getCreateMethod) == null) {
          BookingGrpc.getCreateMethod = getCreateMethod = 
              io.grpc.MethodDescriptor.<server.services.bookingService.CreateRequest, server.services.bookingService.Appointment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bookingService.Booking", "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.CreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.Appointment.getDefaultInstance()))
                  .setSchemaDescriptor(new BookingMethodDescriptorSupplier("Create"))
                  .build();
          }
        }
     }
     return getCreateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.bookingService.GetRequest,
      server.services.bookingService.Appointment> METHOD_GET = getGetMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.bookingService.GetRequest,
      server.services.bookingService.Appointment> getGetMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.bookingService.GetRequest,
      server.services.bookingService.Appointment> getGetMethod() {
    return getGetMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.bookingService.GetRequest,
      server.services.bookingService.Appointment> getGetMethodHelper() {
    io.grpc.MethodDescriptor<server.services.bookingService.GetRequest, server.services.bookingService.Appointment> getGetMethod;
    if ((getGetMethod = BookingGrpc.getGetMethod) == null) {
      synchronized (BookingGrpc.class) {
        if ((getGetMethod = BookingGrpc.getGetMethod) == null) {
          BookingGrpc.getGetMethod = getGetMethod = 
              io.grpc.MethodDescriptor.<server.services.bookingService.GetRequest, server.services.bookingService.Appointment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bookingService.Booking", "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.Appointment.getDefaultInstance()))
                  .setSchemaDescriptor(new BookingMethodDescriptorSupplier("Get"))
                  .build();
          }
        }
     }
     return getGetMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.bookingService.UpdateRequest,
      server.services.bookingService.Appointment> METHOD_UPDATE = getUpdateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.bookingService.UpdateRequest,
      server.services.bookingService.Appointment> getUpdateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.bookingService.UpdateRequest,
      server.services.bookingService.Appointment> getUpdateMethod() {
    return getUpdateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.bookingService.UpdateRequest,
      server.services.bookingService.Appointment> getUpdateMethodHelper() {
    io.grpc.MethodDescriptor<server.services.bookingService.UpdateRequest, server.services.bookingService.Appointment> getUpdateMethod;
    if ((getUpdateMethod = BookingGrpc.getUpdateMethod) == null) {
      synchronized (BookingGrpc.class) {
        if ((getUpdateMethod = BookingGrpc.getUpdateMethod) == null) {
          BookingGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<server.services.bookingService.UpdateRequest, server.services.bookingService.Appointment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bookingService.Booking", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.Appointment.getDefaultInstance()))
                  .setSchemaDescriptor(new BookingMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCancelMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.bookingService.CancelRequest,
      server.services.bookingService.Appointment> METHOD_CANCEL = getCancelMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.bookingService.CancelRequest,
      server.services.bookingService.Appointment> getCancelMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.bookingService.CancelRequest,
      server.services.bookingService.Appointment> getCancelMethod() {
    return getCancelMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.bookingService.CancelRequest,
      server.services.bookingService.Appointment> getCancelMethodHelper() {
    io.grpc.MethodDescriptor<server.services.bookingService.CancelRequest, server.services.bookingService.Appointment> getCancelMethod;
    if ((getCancelMethod = BookingGrpc.getCancelMethod) == null) {
      synchronized (BookingGrpc.class) {
        if ((getCancelMethod = BookingGrpc.getCancelMethod) == null) {
          BookingGrpc.getCancelMethod = getCancelMethod = 
              io.grpc.MethodDescriptor.<server.services.bookingService.CancelRequest, server.services.bookingService.Appointment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bookingService.Booking", "Cancel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.CancelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.Appointment.getDefaultInstance()))
                  .setSchemaDescriptor(new BookingMethodDescriptorSupplier("Cancel"))
                  .build();
          }
        }
     }
     return getCancelMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getShiftListMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.bookingService.ShiftListRequest,
      server.services.bookingService.Appointment> METHOD_SHIFT_LIST = getShiftListMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.bookingService.ShiftListRequest,
      server.services.bookingService.Appointment> getShiftListMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.bookingService.ShiftListRequest,
      server.services.bookingService.Appointment> getShiftListMethod() {
    return getShiftListMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.bookingService.ShiftListRequest,
      server.services.bookingService.Appointment> getShiftListMethodHelper() {
    io.grpc.MethodDescriptor<server.services.bookingService.ShiftListRequest, server.services.bookingService.Appointment> getShiftListMethod;
    if ((getShiftListMethod = BookingGrpc.getShiftListMethod) == null) {
      synchronized (BookingGrpc.class) {
        if ((getShiftListMethod = BookingGrpc.getShiftListMethod) == null) {
          BookingGrpc.getShiftListMethod = getShiftListMethod = 
              io.grpc.MethodDescriptor.<server.services.bookingService.ShiftListRequest, server.services.bookingService.Appointment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "bookingService.Booking", "ShiftList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.ShiftListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.bookingService.Appointment.getDefaultInstance()))
                  .setSchemaDescriptor(new BookingMethodDescriptorSupplier("ShiftList"))
                  .build();
          }
        }
     }
     return getShiftListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BookingStub newStub(io.grpc.Channel channel) {
    return new BookingStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BookingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BookingBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BookingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BookingFutureStub(channel);
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static abstract class BookingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public void create(server.services.bookingService.CreateRequest request,
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMethodHelper(), responseObserver);
    }

    /**
     */
    public void get(server.services.bookingService.GetRequest request,
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMethodHelper(), responseObserver);
    }

    /**
     */
    public void update(server.services.bookingService.UpdateRequest request,
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethodHelper(), responseObserver);
    }

    /**
     */
    public void cancel(server.services.bookingService.CancelRequest request,
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelMethodHelper(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<server.services.bookingService.ShiftListRequest> shiftList(
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      return asyncUnimplementedStreamingCall(getShiftListMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                server.services.bookingService.CreateRequest,
                server.services.bookingService.Appointment>(
                  this, METHODID_CREATE)))
          .addMethod(
            getGetMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                server.services.bookingService.GetRequest,
                server.services.bookingService.Appointment>(
                  this, METHODID_GET)))
          .addMethod(
            getUpdateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                server.services.bookingService.UpdateRequest,
                server.services.bookingService.Appointment>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getCancelMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                server.services.bookingService.CancelRequest,
                server.services.bookingService.Appointment>(
                  this, METHODID_CANCEL)))
          .addMethod(
            getShiftListMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                server.services.bookingService.ShiftListRequest,
                server.services.bookingService.Appointment>(
                  this, METHODID_SHIFT_LIST)))
          .build();
    }
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static final class BookingStub extends io.grpc.stub.AbstractStub<BookingStub> {
    private BookingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingStub(channel, callOptions);
    }

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public void create(server.services.bookingService.CreateRequest request,
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(server.services.bookingService.GetRequest request,
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(server.services.bookingService.UpdateRequest request,
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancel(server.services.bookingService.CancelRequest request,
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<server.services.bookingService.ShiftListRequest> shiftList(
        io.grpc.stub.StreamObserver<server.services.bookingService.Appointment> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getShiftListMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static final class BookingBlockingStub extends io.grpc.stub.AbstractStub<BookingBlockingStub> {
    private BookingBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public server.services.bookingService.Appointment create(server.services.bookingService.CreateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public server.services.bookingService.Appointment get(server.services.bookingService.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public server.services.bookingService.Appointment update(server.services.bookingService.UpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public server.services.bookingService.Appointment cancel(server.services.bookingService.CancelRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static final class BookingFutureStub extends io.grpc.stub.AbstractStub<BookingFutureStub> {
    private BookingFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BookingFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BookingFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BookingFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<server.services.bookingService.Appointment> create(
        server.services.bookingService.CreateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<server.services.bookingService.Appointment> get(
        server.services.bookingService.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<server.services.bookingService.Appointment> update(
        server.services.bookingService.UpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<server.services.bookingService.Appointment> cancel(
        server.services.bookingService.CancelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_GET = 1;
  private static final int METHODID_UPDATE = 2;
  private static final int METHODID_CANCEL = 3;
  private static final int METHODID_SHIFT_LIST = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BookingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BookingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((server.services.bookingService.CreateRequest) request,
              (io.grpc.stub.StreamObserver<server.services.bookingService.Appointment>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((server.services.bookingService.GetRequest) request,
              (io.grpc.stub.StreamObserver<server.services.bookingService.Appointment>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((server.services.bookingService.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<server.services.bookingService.Appointment>) responseObserver);
          break;
        case METHODID_CANCEL:
          serviceImpl.cancel((server.services.bookingService.CancelRequest) request,
              (io.grpc.stub.StreamObserver<server.services.bookingService.Appointment>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SHIFT_LIST:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.shiftList(
              (io.grpc.stub.StreamObserver<server.services.bookingService.Appointment>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BookingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BookingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return server.services.bookingService.BookingServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Booking");
    }
  }

  private static final class BookingFileDescriptorSupplier
      extends BookingBaseDescriptorSupplier {
    BookingFileDescriptorSupplier() {}
  }

  private static final class BookingMethodDescriptorSupplier
      extends BookingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BookingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BookingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BookingFileDescriptorSupplier())
              .addMethod(getCreateMethodHelper())
              .addMethod(getGetMethodHelper())
              .addMethod(getUpdateMethodHelper())
              .addMethod(getCancelMethodHelper())
              .addMethod(getShiftListMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
