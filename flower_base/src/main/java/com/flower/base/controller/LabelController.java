package com.flower.base.controller;

import com.flower.base.pojo.Label;
import com.flower.base.service.LabelService;
import com.flower.common.entity.PageResult;
import com.flower.common.entity.Result;
import com.flower.common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 标签控制层
 */
//@CrossOrigin
//    处理跨域
@RestController
@RequestMapping("label")
public class LabelController {
    @Autowired
//    @Qualifier("labelService")
    private LabelService labelService;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Result eurekaTest() {
        System.out.println("微服务测试");
        return new Result(true, StatusCode.OK, "微服务测试",null);
    }



    /**
     * 查询全部列表
     *
     * @return
     */
    @RequestMapping(name = "get", method = RequestMethod.GET)
//    @RequestMapping("get")
    public Result findAll() {
        System.out.println(" 查询全部列表");
        return new Result(true, StatusCode.OK, "查询成功",
                labelService.findAll());
    }

    /**
     * 根据ID查询标签
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(id));
    }

    /**
     * 增加标签
     *
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改标签
     *
     * @param label
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Label label, @PathVariable String
            id) {
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除标签
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 根据条件查询
     *
     * @param searchMap
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result<List> findSearch(@RequestBody Map searchMap) {
        return new Result<>(true, StatusCode.OK, "查询成功",labelService.findSearch(searchMap));
    }

    /**
     * 条件+分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value="/search/{page}/{size}",method = RequestMethod.POST)
    public Result<List> findSearch( @RequestBody Map searchMap ,@PathVariable int page,@PathVariable int size ) {
        Page pageList = labelService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
    }
}