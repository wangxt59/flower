package com.flower.qa.controller;

import com.flower.common.entity.PageResult;
import com.flower.common.entity.Result;
import com.flower.common.entity.StatusCode;
import com.flower.qa.pojo.Pl;
import com.flower.qa.service.PlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * pl控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/pl")
public class PlController {

	@Autowired
	private PlService plService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true, StatusCode.OK,"查询成功",plService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param problemid ID
	 * @return
	 */
	@RequestMapping(value="/{problemid}",method= RequestMethod.GET)
	public Result findById(@PathVariable String problemid){
		return new Result(true,StatusCode.OK,"查询成功",plService.findById(problemid));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Pl> pageList = plService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Pl>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",plService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param pl
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Pl pl  ){
		plService.add(pl);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param pl
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Pl pl, @PathVariable String problemid ){
		pl.setProblemid(problemid);
		plService.update(pl);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param problemid
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String problemid){
		plService.deleteById(problemid);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
