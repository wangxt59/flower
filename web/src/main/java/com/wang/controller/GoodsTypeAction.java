//package com.wang.controller;
//
//
//import java.util.List;
//
//import com.wang.entity.GoodsType;
//import com.wang.service.GoodsTypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
///**
// * @author chengrui
// * @ClassName: GoodsTypeAction
// * @Description: 商品类型控制层
// * @date 2017年7月17日 上午11:09:47
// */
//@RestController // 等价于@Controller+@ResponseBody
//public class GoodsTypeAction {
//    // 业务逻辑
//    @Autowired
//    private GoodsTypeService typeService;
//
//    /**
//     * @return
//     * @throws Exception
//     * @Title: getGoodsTypeList
//     * @Description: 获取商品类型列表
//     */
//    @RequestMapping(value = "/getGoodsTypeList")
//    public List<GoodsType> getGoodsTypeList() throws Exception {
//        // 调用业务逻辑,返回数据
//        return typeService.getList();
//    }
//
//    @RequestMapping(value = "/getByTypeName")
//    public GoodsType getByTypeName(String typeName) throws Exception {
//        typeName = "生活用品";
//        return typeService.getByTypeName(typeName);
//    }
//
//}
