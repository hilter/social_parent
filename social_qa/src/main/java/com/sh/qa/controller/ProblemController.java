package com.sh.qa.controller;
import java.util.List;
import java.util.Map;

import com.sh.entity.Result;
import com.sh.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sh.qa.pojo.Problem;
import com.sh.qa.service.ProblemService;

import com.sh.entity.PageResult;

/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true, StatusCode.OK,"查询成功",problemService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",problemService.findById(id));
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
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Problem>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",problemService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param problem
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Problem problem  ){
		problemService.add(problem);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param problem
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.PUT)
	public Result update(@RequestBody Problem problem, @PathVariable String id ){
		problem.setId(id);
		problemService.update(problem);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable String id ){
		problemService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

	/**
	 * 查询最新回复列表
	 * @param labelid
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/newlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
	public Result findNewList(@PathVariable("labelid") String labelid,@PathVariable("page")int page,@PathVariable("size")int size){
		//1.获取查询结果
		Page<Problem> problemPage = problemService.findNewList(labelid,page,size);
		//2.创建分页结果集对象
		PageResult pageResult = new PageResult(problemPage.getTotalElements(),problemPage.getContent());
		//3.创建返回值并返回
		return new Result(true,StatusCode.OK,"查询成功",pageResult);
	}


	/**
	 * 获取热门问题列表
	 * @param labelid
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/hotlist/{labelid}/{page}/{size}",method = RequestMethod.GET)
	public Result findHotList(@PathVariable("labelid") String labelid,@PathVariable("page")int page,@PathVariable("size")int size){
		//1.获取查询结果
		Page<Problem> problemPage = problemService.findHotList(labelid,page,size);
		//2.创建分页结果集对象
		PageResult pageResult = new PageResult(problemPage.getTotalElements(),problemPage.getContent());
		//3.创建返回值并返回
		return new Result(true,StatusCode.OK,"查询成功",pageResult);
	}
}
