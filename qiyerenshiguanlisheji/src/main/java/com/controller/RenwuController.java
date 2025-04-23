
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 任务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/renwu")
public class RenwuController {
    private static final Logger logger = LoggerFactory.getLogger(RenwuController.class);

    @Autowired
    private RenwuService renwuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ZhigongService zhigongService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("职工".equals(role))
            params.put("zhigongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = renwuService.queryPage(params);

        //字典表数据转换
        List<RenwuView> list =(List<RenwuView>)page.getList();
        for(RenwuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        RenwuEntity renwu = renwuService.selectById(id);
        if(renwu !=null){
            //entity转view
            RenwuView view = new RenwuView();
            BeanUtils.copyProperties( renwu , view );//把实体数据重构到view中

                //级联表
                ZhigongEntity zhigong = zhigongService.selectById(renwu.getZhigongId());
                if(zhigong != null){
                    BeanUtils.copyProperties( zhigong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhigongId(zhigong.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody RenwuEntity renwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,renwu:{}",this.getClass().getName(),renwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("职工".equals(role))
            renwu.setZhigongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<RenwuEntity> queryWrapper = new EntityWrapper<RenwuEntity>()
            .eq("zhigong_id", renwu.getZhigongId())
            .eq("renwu_uuid_number", renwu.getRenwuUuidNumber())
            .eq("renwu_name", renwu.getRenwuName())
            .eq("renwu_types", renwu.getRenwuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenwuEntity renwuEntity = renwuService.selectOne(queryWrapper);
        if(renwuEntity==null){
            renwu.setInsertTime(new Date());
            renwu.setCreateTime(new Date());
            renwuService.insert(renwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RenwuEntity renwu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,renwu:{}",this.getClass().getName(),renwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("职工".equals(role))
//            renwu.setZhigongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<RenwuEntity> queryWrapper = new EntityWrapper<RenwuEntity>()
            .notIn("id",renwu.getId())
            .andNew()
            .eq("zhigong_id", renwu.getZhigongId())
            .eq("renwu_uuid_number", renwu.getRenwuUuidNumber())
            .eq("renwu_name", renwu.getRenwuName())
            .eq("renwu_types", renwu.getRenwuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenwuEntity renwuEntity = renwuService.selectOne(queryWrapper);
        if(renwuEntity==null){
            renwuService.updateById(renwu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        renwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<RenwuEntity> renwuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            RenwuEntity renwuEntity = new RenwuEntity();
//                            renwuEntity.setZhigongId(Integer.valueOf(data.get(0)));   //职工 要改的
//                            renwuEntity.setRenwuUuidNumber(data.get(0));                    //任务编号 要改的
//                            renwuEntity.setRenwuName(data.get(0));                    //任务标题 要改的
//                            renwuEntity.setRenwuTypes(Integer.valueOf(data.get(0)));   //任务类型 要改的
//                            renwuEntity.setKaishiTime(sdf.parse(data.get(0)));          //任务开始时间 要改的
//                            renwuEntity.setJieshuTime(sdf.parse(data.get(0)));          //任务计划结束时间 要改的
//                            renwuEntity.setRenwuContent("");//详情和图片
//                            renwuEntity.setInsertTime(date);//时间
//                            renwuEntity.setCreateTime(date);//时间
                            renwuList.add(renwuEntity);


                            //把要查询是否重复的字段放入map中
                                //任务编号
                                if(seachFields.containsKey("renwuUuidNumber")){
                                    List<String> renwuUuidNumber = seachFields.get("renwuUuidNumber");
                                    renwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> renwuUuidNumber = new ArrayList<>();
                                    renwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("renwuUuidNumber",renwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //任务编号
                        List<RenwuEntity> renwuEntities_renwuUuidNumber = renwuService.selectList(new EntityWrapper<RenwuEntity>().in("renwu_uuid_number", seachFields.get("renwuUuidNumber")));
                        if(renwuEntities_renwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(RenwuEntity s:renwuEntities_renwuUuidNumber){
                                repeatFields.add(s.getRenwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [任务编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        renwuService.insertBatch(renwuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = renwuService.queryPage(params);

        //字典表数据转换
        List<RenwuView> list =(List<RenwuView>)page.getList();
        for(RenwuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        RenwuEntity renwu = renwuService.selectById(id);
            if(renwu !=null){


                //entity转view
                RenwuView view = new RenwuView();
                BeanUtils.copyProperties( renwu , view );//把实体数据重构到view中

                //级联表
                    ZhigongEntity zhigong = zhigongService.selectById(renwu.getZhigongId());
                if(zhigong != null){
                    BeanUtils.copyProperties( zhigong , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhigongId(zhigong.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody RenwuEntity renwu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,renwu:{}",this.getClass().getName(),renwu.toString());
        Wrapper<RenwuEntity> queryWrapper = new EntityWrapper<RenwuEntity>()
            .eq("zhigong_id", renwu.getZhigongId())
            .eq("renwu_uuid_number", renwu.getRenwuUuidNumber())
            .eq("renwu_name", renwu.getRenwuName())
            .eq("renwu_types", renwu.getRenwuTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenwuEntity renwuEntity = renwuService.selectOne(queryWrapper);
        if(renwuEntity==null){
            renwu.setInsertTime(new Date());
            renwu.setCreateTime(new Date());
        renwuService.insert(renwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
