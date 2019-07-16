package com.wang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wang.Log.ResponseResult;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/solr")
public class SolrController {

    /**
     * 装载SolrClient实例，前提是solr的host地址配对后
     */
    @Autowired
    SolrClient solrClient;

    @RequestMapping("/add")
    @ResponseBody
    public String Test() throws Exception {

        List<SolrInputDocument> docs = new ArrayList<>();

        SolrInputDocument doc = new SolrInputDocument();

        /**
         * 添加字段索引，id一样，为修改，id不一样，为新增
         */
        doc.setField("id", "1");
        /**
         * 商品类目
         */
        doc.setField("item_cat_name", "电脑办公类");
        /**
         * 商品名称
         */
        doc.setField("item_name", "联想天逸510S");
        /**
         * 商品简单描述
         */
        doc.setField("item_desc", "联想（Lenovo）天逸510S商用台式办公电脑整机（i3-7100 4G 1T 集显 WiFi 蓝牙 三年上门 win10）19.5英寸");
        /**
         * 商品价格
         */
        doc.setField("item_price", "3099.00");
        /**
         * 将创建好的单个SolrInputDocument对象添加进Solr文档集合列表中
         */
        docs.add(doc);

        doc = new SolrInputDocument();
        doc.setField("id", "2");
        doc.setField("item_cat_name", "电脑办公类");
        doc.setField("item_name", "联想天逸510S");
        doc.setField("item_desc", "联想（Lenovo）天逸510S商用台式办公电脑整机（i3-7100 4G1T 集显 WiFi 蓝牙 三年上门 win10）21.5英寸");
        doc.setField("item_price", "3299.00");
        docs.add(doc);

        doc = new SolrInputDocument();
        doc.setField("id", "3");
        doc.setField("item_cat_name", "电脑办公类");
        doc.setField("item_name", "MacBook Pro");
        doc.setField("item_desc", "APPLE 苹果MacBook Pro 17年新款 笔记本电脑高端轻薄时尚游戏办公 15.4英寸 Bar i7 16G 256G闪存 2016款 银色");
        doc.setField("item_price", "13838.00");
        docs.add(doc);

        doc = new SolrInputDocument();
        doc.setField("id", "4");
        doc.setField("item_cat_name", "电脑办公类");
        doc.setField("item_name", "华为MateBook X");
        doc.setField("item_desc", "华为(HUAWEI) MateBook X 13英寸超轻薄微边框笔记本(i5-7200U 8G 256G 拓展坞 2K屏 指纹 office)玫瑰金");
        doc.setField("item_price", "7688.00");
        docs.add(doc);

        doc = new SolrInputDocument();
        doc.setField("id", "4");
        doc.setField("item_cat_name", "电脑办公类");
        doc.setField("item_name", "苹果（Apple） MacBook PRO");
        doc.setField("item_desc", "苹果（Apple） MacBook PRO苹果笔记本电脑 2016/2017新款原装日版 17款15英寸灰MPTT2Bar/16G/512G");
        doc.setField("item_price", "17688");
        docs.add(doc);

        /**
         * 一次性全部添加
         */
        solrClient.add(docs);
        /**
         * 提交
         */
        solrClient.commit();

        return "OK";
    }

    @RequestMapping("quary")
    @ResponseBody
    public ModelAndView Query(@RequestBody Map<String,Object> map) throws Exception {
        System.out.println(map.toString());
        SolrQuery solrQuery = new SolrQuery();

        /**
         * *:*:表示查询全部 *Mac*代表左右模糊匹配，如果写Mac代表绝对匹配
         */
        solrQuery.set("q", "item_name:P*");

        /**
         * 过滤条件:电脑办公类，10000元以上 [A TO B] 范围A到B之间 [A TO *] A到无穷 [* TO B] B以下
         * 相当于sql语句中的where ----->fq = filter query
         */
        solrQuery.set("fq", "item_cat_name:电脑办公类");
        solrQuery.set("fq", "item_price:[10000 TO *]");

        // 分页，0开始，每页5条，setStart设置的就是显示第几页
        solrQuery.setStart(0);
        solrQuery.setRows(5);

        // 开启高亮
        solrQuery.setHighlight(true);
        // 添加高亮字段，多个字段之间逗号隔开比如: A,B,C
        solrQuery.addHighlightField("item_name,item_price");
        // 设置高亮字段的前缀
        solrQuery.setHighlightSimplePre("<font color='red'>");
        // 设置高亮字段的后缀
        solrQuery.setHighlightSimplePost("</font>");

        // 执行查询
        QueryResponse response = solrClient.query(solrQuery);

        // 文档结果集
        SolrDocumentList docs = response.getResults();

        System.err.println("-------------------高亮效果部分展示-------------------------");
        // 高亮显示的返回结果
        Map<String, Map<String, List<String>>> maplist = response.getHighlighting();
        /**
         * 静态html资源里面的对象 -- ${list}
         */
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> m;
        // 返回高亮之后的结果..
        for (SolrDocument solrDocument : docs) {

            String id = solrDocument.getFirstValue("id").toString();
            String item_cat_name = solrDocument.getFirstValue("item_cat_name").toString();
            String item_desc = solrDocument.getFirstValue("item_desc").toString();
            String item_price = solrDocument.getFirstValue("item_price").toString();

            System.err.println(id);
            System.err.println(item_cat_name);
            Map<String, List<String>> fieldMap = maplist.get(solrDocument.get("id"));
            List<String> stringlist = fieldMap.get("item_name");

            String item_name = stringlist.get(0);

            System.err.println(item_name);
            System.err.println(item_desc);
            System.err.println(item_price);
            m = new HashMap<String, Object>();
            m.put("id", id);
            m.put("item_cat_name", item_cat_name);
            m.put("item_name", item_name);
            m.put("item_desc", item_desc);
            m.put("item_price", item_price);
            list.add(m);
            System.err.println("============分割线==============");

        }

        System.err.println("查询到的总条数:" + docs.getNumFound() + ", 内容:" + docs);
        map.put("list", list);
        return new ModelAndView("/page/quary",map);

    }

    @RequestMapping("/deleteall")
    @ResponseBody
    public String DeleteAll() throws Exception {

        // 清空所有数据
        solrClient.deleteByQuery("*:*");
        solrClient.commit();

        return "OK";
    }

}