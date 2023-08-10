package server.services.prescriptionsService;

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
    comments = "Source: prescriptions.proto")
public final class PrescriptionsGrpc {

  private PrescriptionsGrpc() {}

  public static final String SERVICE_NAME = "prescriptionsService.Prescriptions";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.prescriptionsService.CreateRequest,
      server.services.prescriptionsService.Prescription> METHOD_CREATE = getCreateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.prescriptionsService.CreateRequest,
      server.services.prescriptionsService.Prescription> getCreateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.prescriptionsService.CreateRequest,
      server.services.prescriptionsService.Prescription> getCreateMethod() {
    return getCreateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.prescriptionsService.CreateRequest,
      server.services.prescriptionsService.Prescription> getCreateMethodHelper() {
    io.grpc.MethodDescriptor<server.services.prescriptionsService.CreateRequest, server.services.prescriptionsService.Prescription> getCreateMethod;
    if ((getCreateMethod = PrescriptionsGrpc.getCreateMethod) == null) {
      synchronized (PrescriptionsGrpc.class) {
        if ((getCreateMethod = PrescriptionsGrpc.getCreateMethod) == null) {
          PrescriptionsGrpc.getCreateMethod = getCreateMethod = 
              io.grpc.MethodDescriptor.<server.services.prescriptionsService.CreateRequest, server.services.prescriptionsService.Prescription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "prescriptionsService.Prescriptions", "create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.prescriptionsService.CreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.prescriptionsService.Prescription.getDefaultInstance()))
                  .setSchemaDescriptor(new PrescriptionsMethodDescriptorSupplier("create"))
                  .build();
          }
        }
     }
     return getCreateMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddDrugMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.prescriptionsService.AddDrugRequest,
      server.services.prescriptionsService.Drug> METHOD_ADD_DRUG = getAddDrugMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.prescriptionsService.AddDrugRequest,
      server.services.prescriptionsService.Drug> getAddDrugMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.prescriptionsService.AddDrugRequest,
      server.services.prescriptionsService.Drug> getAddDrugMethod() {
    return getAddDrugMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.prescriptionsService.AddDrugRequest,
      server.services.prescriptionsService.Drug> getAddDrugMethodHelper() {
    io.grpc.MethodDescriptor<server.services.prescriptionsService.AddDrugRequest, server.services.prescriptionsService.Drug> getAddDrugMethod;
    if ((getAddDrugMethod = PrescriptionsGrpc.getAddDrugMethod) == null) {
      synchronized (PrescriptionsGrpc.class) {
        if ((getAddDrugMethod = PrescriptionsGrpc.getAddDrugMethod) == null) {
          PrescriptionsGrpc.getAddDrugMethod = getAddDrugMethod = 
              io.grpc.MethodDescriptor.<server.services.prescriptionsService.AddDrugRequest, server.services.prescriptionsService.Drug>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "prescriptionsService.Prescriptions", "addDrug"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.prescriptionsService.AddDrugRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.prescriptionsService.Drug.getDefaultInstance()))
                  .setSchemaDescriptor(new PrescriptionsMethodDescriptorSupplier("addDrug"))
                  .build();
          }
        }
     }
     return getAddDrugMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAllMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.prescriptionsService.Empty,
      server.services.prescriptionsService.Prescription> METHOD_GET_ALL = getGetAllMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.prescriptionsService.Empty,
      server.services.prescriptionsService.Prescription> getGetAllMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.prescriptionsService.Empty,
      server.services.prescriptionsService.Prescription> getGetAllMethod() {
    return getGetAllMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.prescriptionsService.Empty,
      server.services.prescriptionsService.Prescription> getGetAllMethodHelper() {
    io.grpc.MethodDescriptor<server.services.prescriptionsService.Empty, server.services.prescriptionsService.Prescription> getGetAllMethod;
    if ((getGetAllMethod = PrescriptionsGrpc.getGetAllMethod) == null) {
      synchronized (PrescriptionsGrpc.class) {
        if ((getGetAllMethod = PrescriptionsGrpc.getGetAllMethod) == null) {
          PrescriptionsGrpc.getGetAllMethod = getGetAllMethod = 
              io.grpc.MethodDescriptor.<server.services.prescriptionsService.Empty, server.services.prescriptionsService.Prescription>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "prescriptionsService.Prescriptions", "getAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.prescriptionsService.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.prescriptionsService.Prescription.getDefaultInstance()))
                  .setSchemaDescriptor(new PrescriptionsMethodDescriptorSupplier("getAll"))
                  .build();
          }
        }
     }
     return getGetAllMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrescriptionsStub newStub(io.grpc.Channel channel) {
    return new PrescriptionsStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrescriptionsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PrescriptionsBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrescriptionsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PrescriptionsFutureStub(channel);
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static abstract class PrescriptionsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public void create(server.services.prescriptionsService.CreateRequest request,
        io.grpc.stub.StreamObserver<server.services.prescriptionsService.Prescription> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMethodHelper(), responseObserver);
    }

    /**
     */
    public void addDrug(server.services.prescriptionsService.AddDrugRequest request,
        io.grpc.stub.StreamObserver<server.services.prescriptionsService.Drug> responseObserver) {
      asyncUnimplementedUnaryCall(getAddDrugMethodHelper(), responseObserver);
    }

    /**
     */
    public void getAll(server.services.prescriptionsService.Empty request,
        io.grpc.stub.StreamObserver<server.services.prescriptionsService.Prescription> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                server.services.prescriptionsService.CreateRequest,
                server.services.prescriptionsService.Prescription>(
                  this, METHODID_CREATE)))
          .addMethod(
            getAddDrugMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                server.services.prescriptionsService.AddDrugRequest,
                server.services.prescriptionsService.Drug>(
                  this, METHODID_ADD_DRUG)))
          .addMethod(
            getGetAllMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                server.services.prescriptionsService.Empty,
                server.services.prescriptionsService.Prescription>(
                  this, METHODID_GET_ALL)))
          .build();
    }
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static final class PrescriptionsStub extends io.grpc.stub.AbstractStub<PrescriptionsStub> {
    private PrescriptionsStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrescriptionsStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrescriptionsStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrescriptionsStub(channel, callOptions);
    }

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public void create(server.services.prescriptionsService.CreateRequest request,
        io.grpc.stub.StreamObserver<server.services.prescriptionsService.Prescription> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addDrug(server.services.prescriptionsService.AddDrugRequest request,
        io.grpc.stub.StreamObserver<server.services.prescriptionsService.Drug> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddDrugMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAll(server.services.prescriptionsService.Empty request,
        io.grpc.stub.StreamObserver<server.services.prescriptionsService.Prescription> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static final class PrescriptionsBlockingStub extends io.grpc.stub.AbstractStub<PrescriptionsBlockingStub> {
    private PrescriptionsBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrescriptionsBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrescriptionsBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrescriptionsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public server.services.prescriptionsService.Prescription create(server.services.prescriptionsService.CreateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public server.services.prescriptionsService.Drug addDrug(server.services.prescriptionsService.AddDrugRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddDrugMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<server.services.prescriptionsService.Prescription> getAll(
        server.services.prescriptionsService.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static final class PrescriptionsFutureStub extends io.grpc.stub.AbstractStub<PrescriptionsFutureStub> {
    private PrescriptionsFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PrescriptionsFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrescriptionsFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PrescriptionsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<server.services.prescriptionsService.Prescription> create(
        server.services.prescriptionsService.CreateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<server.services.prescriptionsService.Drug> addDrug(
        server.services.prescriptionsService.AddDrugRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddDrugMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_ADD_DRUG = 1;
  private static final int METHODID_GET_ALL = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrescriptionsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrescriptionsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((server.services.prescriptionsService.CreateRequest) request,
              (io.grpc.stub.StreamObserver<server.services.prescriptionsService.Prescription>) responseObserver);
          break;
        case METHODID_ADD_DRUG:
          serviceImpl.addDrug((server.services.prescriptionsService.AddDrugRequest) request,
              (io.grpc.stub.StreamObserver<server.services.prescriptionsService.Drug>) responseObserver);
          break;
        case METHODID_GET_ALL:
          serviceImpl.getAll((server.services.prescriptionsService.Empty) request,
              (io.grpc.stub.StreamObserver<server.services.prescriptionsService.Prescription>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrescriptionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrescriptionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return server.services.prescriptionsService.PrescriptionsServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Prescriptions");
    }
  }

  private static final class PrescriptionsFileDescriptorSupplier
      extends PrescriptionsBaseDescriptorSupplier {
    PrescriptionsFileDescriptorSupplier() {}
  }

  private static final class PrescriptionsMethodDescriptorSupplier
      extends PrescriptionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrescriptionsMethodDescriptorSupplier(String methodName) {
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
      synchronized (PrescriptionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrescriptionsFileDescriptorSupplier())
              .addMethod(getCreateMethodHelper())
              .addMethod(getAddDrugMethodHelper())
              .addMethod(getGetAllMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
