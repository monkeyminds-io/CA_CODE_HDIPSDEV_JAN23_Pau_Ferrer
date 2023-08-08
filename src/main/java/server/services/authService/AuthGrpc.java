package server.services.authService;

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
    comments = "Source: auth.proto")
public final class AuthGrpc {

  private AuthGrpc() {}

  public static final String SERVICE_NAME = "authService.Auth";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRegisterMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.authService.RegisterRequest,
      server.services.authService.User> METHOD_REGISTER = getRegisterMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.authService.RegisterRequest,
      server.services.authService.User> getRegisterMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.authService.RegisterRequest,
      server.services.authService.User> getRegisterMethod() {
    return getRegisterMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.authService.RegisterRequest,
      server.services.authService.User> getRegisterMethodHelper() {
    io.grpc.MethodDescriptor<server.services.authService.RegisterRequest, server.services.authService.User> getRegisterMethod;
    if ((getRegisterMethod = AuthGrpc.getRegisterMethod) == null) {
      synchronized (AuthGrpc.class) {
        if ((getRegisterMethod = AuthGrpc.getRegisterMethod) == null) {
          AuthGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<server.services.authService.RegisterRequest, server.services.authService.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "authService.Auth", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.authService.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.authService.User.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getLoginMethod()} instead. 
  public static final io.grpc.MethodDescriptor<server.services.authService.LoginRequest,
      server.services.authService.User> METHOD_LOGIN = getLoginMethodHelper();

  private static volatile io.grpc.MethodDescriptor<server.services.authService.LoginRequest,
      server.services.authService.User> getLoginMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<server.services.authService.LoginRequest,
      server.services.authService.User> getLoginMethod() {
    return getLoginMethodHelper();
  }

  private static io.grpc.MethodDescriptor<server.services.authService.LoginRequest,
      server.services.authService.User> getLoginMethodHelper() {
    io.grpc.MethodDescriptor<server.services.authService.LoginRequest, server.services.authService.User> getLoginMethod;
    if ((getLoginMethod = AuthGrpc.getLoginMethod) == null) {
      synchronized (AuthGrpc.class) {
        if ((getLoginMethod = AuthGrpc.getLoginMethod) == null) {
          AuthGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<server.services.authService.LoginRequest, server.services.authService.User>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "authService.Auth", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.authService.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  server.services.authService.User.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthStub newStub(io.grpc.Channel channel) {
    return new AuthStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthFutureStub(channel);
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static abstract class AuthImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public void register(server.services.authService.RegisterRequest request,
        io.grpc.stub.StreamObserver<server.services.authService.User> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethodHelper(), responseObserver);
    }

    /**
     */
    public void login(server.services.authService.LoginRequest request,
        io.grpc.stub.StreamObserver<server.services.authService.User> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                server.services.authService.RegisterRequest,
                server.services.authService.User>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getLoginMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                server.services.authService.LoginRequest,
                server.services.authService.User>(
                  this, METHODID_LOGIN)))
          .build();
    }
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static final class AuthStub extends io.grpc.stub.AbstractStub<AuthStub> {
    private AuthStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthStub(channel, callOptions);
    }

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public void register(server.services.authService.RegisterRequest request,
        io.grpc.stub.StreamObserver<server.services.authService.User> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void login(server.services.authService.LoginRequest request,
        io.grpc.stub.StreamObserver<server.services.authService.User> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static final class AuthBlockingStub extends io.grpc.stub.AbstractStub<AuthBlockingStub> {
    private AuthBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public server.services.authService.User register(server.services.authService.RegisterRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethodHelper(), getCallOptions(), request);
    }

    /**
     */
    public server.services.authService.User login(server.services.authService.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * This is the service declaration
   * </pre>
   */
  public static final class AuthFutureStub extends io.grpc.stub.AbstractStub<AuthFutureStub> {
    private AuthFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * These are the method declarations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<server.services.authService.User> register(
        server.services.authService.RegisterRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethodHelper(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<server.services.authService.User> login(
        server.services.authService.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_LOGIN = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((server.services.authService.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<server.services.authService.User>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((server.services.authService.LoginRequest) request,
              (io.grpc.stub.StreamObserver<server.services.authService.User>) responseObserver);
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

  private static abstract class AuthBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return server.services.authService.AuthServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Auth");
    }
  }

  private static final class AuthFileDescriptorSupplier
      extends AuthBaseDescriptorSupplier {
    AuthFileDescriptorSupplier() {}
  }

  private static final class AuthMethodDescriptorSupplier
      extends AuthBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthFileDescriptorSupplier())
              .addMethod(getRegisterMethodHelper())
              .addMethod(getLoginMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
