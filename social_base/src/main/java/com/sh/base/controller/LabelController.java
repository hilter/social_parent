package com.sh.base.controller;

import com.sh.base.pojo.Label;
import com.sh.base.service.LabelService;
import com.sh.entity.Result;
import com.sh.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
@CrossOrigin//开启跨域访问的支持
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查询所有标签
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        //1.查询所有标签
        List<Label> labels = labelService.findAll();
        //2.返回结果
        return new Result(true, StatusCode.OK,"查询成功",labels);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Result findById(@PathVariable("id") String id){
        //1.根据id查询标签
        Label label = labelService.findById(id);
        //2.返回结果
        return new Result(true,StatusCode.OK,"查询成功",label);
    }

    /**
     * 保存
     * @param label
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public Result add(@RequestBody Label label){
        labelService.add(label);
        return new Result(true,StatusCode.OK,"保存成功");
    }


    /**
     * 更新
     * @param label
     * @return
     */
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public Result update(@RequestBody Label label,@PathVariable("id") String id){
        label.setId(id);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"更新成功");
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public Result delete(@PathVariable("id") String id){
        labelService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
