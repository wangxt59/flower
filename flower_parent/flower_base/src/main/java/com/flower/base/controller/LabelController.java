package com.flower.base.controller;

import com.flower.base.pojo.Label;
import com.flower.base.service.LabelService;
import com.flower.common.entity.Result;
import com.flower.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * 标签控制层
 */
@RestController
@RequestMapping("label")
public class LabelController {
    @Autowired
//    @Qualifier("labelService")
    private LabelService labelService;
    /**
     * 查询全部列表
     * @return
     */
//    @RequestMapping(name = "get",method = RequestMethod.GET)
    @RequestMapping("get")
    public Result findAll(){
        System.out.println(" 查询全部列表");
        return new Result(true, StatusCode.OK,"查询成功",
                labelService.findAll() );
    }
    /**
     * 根据ID查询标签
     * @param id
     * @return
     */
//    @RequestMapping(value="/{id}",method = RequestMethod.GET)
//    public Result findById(@PathVariable String id){
//        return new Result(true,StatusCode.OK,"查询成功",labelService.findById(id));
//    }
    /**
     * 增加标签
     5.2.3 功能测试
     （1）测试查询全部数据
     使用浏览器测试GET方法 http://localhost:9001/label
     （2）测试根据ID查询标签
     * @param label
     * @return
     */
//    @RequestMapping(method = RequestMethod.POST)
//    public Result add( @RequestBody Label label){
//        labelService.add(label);
//        return new Result(true,StatusCode.OK,"增加成功");
//    }
    /**
     * 修改标签
     * @param label
     * @return
     */
//    @RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
//    public Result update( @RequestBody Label label,@PathVariable String
//            id){
//        label.setId(id);
//        labelService.update(label);
//        return new Result(true,StatusCode.OK,"修改成功");
//    }
    /**
     * 删除标签
     * @param id
     * @return
     */
//    @RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
//    public Result deleteById(@PathVariable String id){
//        labelService.deleteById(id);
//        return new Result(true,StatusCode.OK,"删除成功");
//    }
}