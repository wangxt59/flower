package com.flower.spit.controller;

import com.flower.common.entity.PageResult;
import com.flower.common.entity.Result;
import com.flower.common.entity.StatusCode;
import com.flower.spit.pojo.Spit;
import com.flower.spit.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
/**
 * spit控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

	@Autowired
	private SpitService spitService;

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 吐槽点赞
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/thumbup/{id}", method = RequestMethod.PUT)
	public Result updateThumbup(@PathVariable String id){
		//判断用户是否点过赞
		String userid="2023";// 后边我们会修改为当前登陆的用户
		if(redisTemplate.opsForValue().get("thumbup_"+userid+"_"+ id)!=null){
			return new Result(false,StatusCode.REPERROR,"你已经点过赞了");
		}
		spitService.updateThumbup(id);
		redisTemplate.opsForValue().set( "thumbup_"+userid+"_"+ id,"1");
		return new Result(true,StatusCode.OK,"点赞成功");
	}



	/**
	 * 根据上级ID查询吐槽分页数据
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/comment/{parentId}/{page}/{size}",method=RequestMethod.GET)
	public Result findByParentid(@PathVariable String parentId, @PathVariable int page,@PathVariable int size){
		Page<Spit> pageList = spitService.findByParentid(parentId,page, size);
		return new Result(true,StatusCode.OK,"查询成功",new PageResult<Spit>(pageList.getTotalElements(), pageList.getContent() ) );
	}


	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true, StatusCode.OK,"查询成功",spitService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param Id ID
	 * @return
	 */
	@RequestMapping(value="/{Id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String Id){
		return new Result(true,StatusCode.OK,"查询成功",spitService.findById(Id));
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
		Page<Spit> pageList = spitService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Spit>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",spitService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param spit
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Spit spit  ){
		spitService.add(spit);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param spit
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Spit spit, @PathVariable String Id ){
		spit.setId(Id);
		spitService.update(spit);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param Id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String Id){
		spitService.deleteById(Id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
