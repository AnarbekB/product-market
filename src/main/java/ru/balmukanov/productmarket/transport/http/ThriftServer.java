package ru.balmukanov.productmarket.transport.http;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import ru.balmukanov.productmarketinterface.thrift.ProductMarketThriftService;

public class ThriftServer {

    private TServer server;

    private ThriftService thriftService;

    public ThriftServer(ThriftService thriftService) {
        this.thriftService = thriftService;
    }

    public void start() throws TTransportException {
        TServerTransport serverTransport = new TServerSocket(9090);
        server = new TSimpleServer(new TServer.Args(serverTransport)
                .processor(new ProductMarketThriftService.Processor<>(this.thriftService)));

        System.out.print("Starting the server... ");

        server.serve();

        System.out.println("done.");
    }

    public void stop() {
        if (server != null && server.isServing()) {
            System.out.print("Stopping the server... ");

            server.stop();

            System.out.println("done.");
        }
    }

}
