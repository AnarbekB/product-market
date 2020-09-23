package ru.balmukanov.productmarket.config;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.balmukanov.productmarket.transport.http.ThriftService;
import ru.balmukanov.productmarketinterface.thrift.ProductMarketThriftService;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ThriftConfig {

    ExecutorService executor = Executors.newSingleThreadExecutor();

    private final ThriftService thriftService;

    @Value("${product.market.thrift.port}")
    private int productMarketThriftPort;

    public ThriftConfig(ThriftService thriftService) {
        this.thriftService = thriftService;
    }

    @Bean
    public TServerTransport tServerTransport() {
        try {
            return new TServerSocket(this.productMarketThriftPort);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public TServer tServer() {
        return new TSimpleServer(
                new TServer.Args(this.tServerTransport())
                .processor(new ProductMarketThriftService.Processor<>(this.thriftService))
        );
    }

    @PostConstruct
    public void init(){
        executor.execute(() -> tServer().serve());
    }

}
