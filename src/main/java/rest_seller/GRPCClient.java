package rest_seller;

import com.example.DistributedAssignment.services.CredentialsGrpc;
import com.example.DistributedAssignment.services.GetSellerRatingGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import static rest_seller.Utils.CUSTOMER_DB_PORT;
import static rest_seller.Utils.PRODUCT_DB_PORT;

public interface GRPCClient {
    ManagedChannel customerDBChannel = ManagedChannelBuilder.forAddress("localhost", CUSTOMER_DB_PORT).usePlaintext().build();;
    ManagedChannel productDBChannel = ManagedChannelBuilder.forAddress("localhost", PRODUCT_DB_PORT).usePlaintext().build();
    CredentialsGrpc.CredentialsBlockingStub credentialsStub = CredentialsGrpc.newBlockingStub(customerDBChannel);
    GetSellerRatingGrpc.GetSellerRatingBlockingStub getSellerRatingStub = GetSellerRatingGrpc.newBlockingStub(customerDBChannel);
}
