package com.example.demogra.grpcclientimpl;
import com.example.demogra.entity.Client;
import com.example.demogra.service.ClientServiceImpl;
import com.master.grpc.DemograService;
import com.master.grpc.clientServiceExampleGrpc.clientServiceExampleImplBase;
import io.grpc.stub.StreamObserver;
//import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;



//@GrpcService
public class ClientGrpcService extends clientServiceExampleImplBase {
    @Autowired
//    @Qualifier("clientServiceImpl")
    private ClientServiceImpl clientService;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void getClientById(DemograService.clientId request, StreamObserver<DemograService.Client> responseObserver) {
        Client clientToReturn = clientService.getOne((long) request.getId());
        DemograService.Client cliente1 = modelMapper.map(clientToReturn,DemograService.Client.class);
        responseObserver.onNext(cliente1);
        responseObserver.onCompleted();
    }
}

