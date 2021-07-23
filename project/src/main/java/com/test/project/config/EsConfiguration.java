package com.test.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration

public class EsConfiguration {
    @Value("${es.ip}")
    String ip;
    @Value("${es.port}")
    int port;

//    //indexRequest
//    final static Map<String, IndexRequestBuilder> REQUEST_MAP= new HashMap<>();
////客户端
//    TransportClient client = null;
//    @Bean
//    public TransportClient getClient() {
//        Settings build = Settings.builder().put("client.transport.sniff", true).build();
//        //创建传输客户端
//        //指定集群中一个节点
//        TransportClient client = null; //通过TransportClient来访问时要使用9300
//        {
//            try {
//                client = new PreBuiltTransportClient(build)
//                        .addTransportAddress(new
//                                InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
//        }
//        //System.out.println(client);
//        //关闭
//        //client.close();
//        return client;
//    }
//
////获取IndexRequestBuilder对象
//    public IndexRequestBuilder getIndexRequest(String index, String type){
//        String key = index+type;
//        IndexRequestBuilder indexRequest = null;
//        if(REQUEST_MAP.containsKey(key)){
//            indexRequest = REQUEST_MAP.get(key);
//        }else {
//            indexRequest = client.prepareIndex(index,type);
//            REQUEST_MAP.put(key,indexRequest);
//        }
//        return indexRequest;
//    }
}
