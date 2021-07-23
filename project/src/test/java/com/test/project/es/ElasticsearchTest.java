package com.test.project.es;


import javax.swing.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ElasticsearchTest {

//    String ip = "localhost";
//    int port = 9300;
//    String id= "AXhdr5F-PWETcJ6y75Ql";
//    public static void main(String[] args) throws UnknownHostException, ExecutionException, InterruptedException {
//        ElasticsearchTest test = new ElasticsearchTest();
//        test.addData("test","three");
//        //test.search("test","three","AXhdr5F-PWETcJ6y75Ql");
//        //test.update("test","three","1");
//        //test.delete("test","three",test.id);
//        //test.dslSearch("test","three");
//    }
//
//    public TransportClient getConnection(String id,int port) throws UnknownHostException {
//        Settings build = Settings.builder().put("client.transport.sniff", true).build();
//
//        //创建传输客户端
//        //指定集群中一个节点
//        TransportClient client = new PreBuiltTransportClient(build)
//                .addTransportAddress(new
//                        InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300)); //通过TransportClient来访问时要使用9300
//
//        //System.out.println(client);
//        //关闭
//        //client.close();
//        return client;
//    }
//
////添加数据
//    public void addData(String index,String type) throws UnknownHostException {
//        TransportClient client = getConnection(ip, port);
//        IndexRequestBuilder builder = client.prepareIndex(index, type);
//
//        Demo d1 = new Demo("111111", "demo111111111111");
//        Demo d2 = new Demo("222222", "demo222222222222");
//        builder.setSource(d1);
////添加指定id
////      builder.setId("10000");
//        IndexResponse indexResponse = builder.get();
//        System.out.println(indexResponse.status());
//        builder.setSource(d2);
//        IndexResponse response = builder.get();
//        System.out.println(response.status());
//        client.close();
//    }
////查询数据 普通查询
//    public void search(String index,String type,String id) throws UnknownHostException {
//        TransportClient client = getConnection(ip, port);
//        client.prepareGet(index, type, id).get().getSource().entrySet().forEach(e->{
//            System.out.println(e.getKey()+":"+e.getValue());
//        });
//        client.close();
//    }
////更新
//    public void update(String index,String type,String id) throws UnknownHostException, ExecutionException, InterruptedException {
//        TransportClient client = getConnection(id, port);
//        IndexRequest indexRequest = new IndexRequest(index, type, id);
//        HashMap<Object, Object> data = new HashMap<>();
//        data.put("id","999");
//        data.put("name","九九九");
//        UpdateRequest updateRequest = new UpdateRequest(index, type, id).doc(data).upsert(indexRequest);
//        client.update(updateRequest).get();
//    }
////删除 返回请求状态码
//    public void delete(String index,String type,String id) throws UnknownHostException {
//        TransportClient client = getConnection(ip, port);
//        DeleteResponse deleteResponse = client.prepareDelete(index, type, id).get();
//    }
////dsl 查询/过滤
//    public void dslSearch(String index,String type) throws UnknownHostException {
//        TransportClient connection = getConnection(id, port);
//        //查询请求
//        SearchRequestBuilder builder = connection.prepareSearch(index).setTypes(type);
//        //查询构建
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        List<QueryBuilder> must = boolQueryBuilder.must();
//        //可以添加多个
//        must.add(QueryBuilders.matchAllQuery());
//        //filter
//        boolQueryBuilder.filter(QueryBuilders.rangeQuery("id").gte(1).lt(1000000));
//        //query
//        builder.setQuery(boolQueryBuilder);
//        //排序
//        builder.addSort("id", SortOrder.ASC);
//        //截取字段
//        builder.setFetchSource(new String[]{"id"},null);
//        //展示内容 获取查询结果
//        SearchResponse response = builder.get();
//        //获取当前数据
//        SearchHits hits = response.getHits();
//        System.out.println("total:"+hits.getTotalHits());
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSource());
//        }
//        connection.close();
//    }
//
//
//}

    class Demo {
        String name;
        String id;

        public Demo(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}