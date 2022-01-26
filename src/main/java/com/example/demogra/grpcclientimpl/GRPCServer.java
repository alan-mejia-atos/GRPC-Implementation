package com.example.demogra.grpcclientimpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GRPCServer {

    public static void main(String[] args)throws IOException, InterruptedException {
        Server grpcServer = ServerBuilder.forPort(9095).addService(new ClientGrpcService()).build();
        grpcServer.start();
        System.out.println("Server started at " + grpcServer.getPort());
        grpcServer.awaitTermination();
    }

}
