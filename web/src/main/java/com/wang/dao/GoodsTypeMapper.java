package com.wang.dao;

import com.wang.entity.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author cheng
 * @ClassName: GoodsTypeDao
 * @Description: 商品类型数据访问接口
 * @date 2017年7月17日 上午9:45:41
 */
//@Mapper
@Repository
public interface GoodsTypeMapper {

    /**
     * @param goodsType
     * @throws Exception
     * @Title: saveGoodsType
     * @Description: 添加一个商品类型
     */
    void saveGoodsType(GoodsType goodsType) throws Exception;

    /**
     * @param typeId
     * @throws Exception
     * @Title: deleteGoodsType
     * @Description: 删除一个商品类型
     */
    void deleteGoodsType(String typeId) throws Exception;

    /**
     * @param goodsType
     * @throws Exception
     * @Title: updateGoodsType
     * @Description: 修改一个商品类型
     */
    void updateGoodsType(GoodsType goodsType) throws Exception;

    /**
     * @return
     * @throws Exception
     * @Title: getList
     * @Description: 获取所有商品类型列表
     */
    List<GoodsType> getList() throws Exception;

    /**
     * @param typeName
     * @return
     * @throws Exception
     * @Title: getByTypeName
     * @Description: 依据商品名称查询
     */
    GoodsType getByTypeName(String typeName) throws Exception;
}