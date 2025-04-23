
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
 * 职工
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhigong")
public class ZhigongController {
    private static final Logger logger = LoggerFactory.getLogger(ZhigongController.class);

    @Autowired
    private ZhigongService zhigongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service



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
        PageUtils page = zhigongService.queryPage(params);

        //字典表数据转换
        List<ZhigongView> list =(List<ZhigongView>)page.getList();
        for(ZhigongView c:list){
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
        ZhigongEntity zhigong = zhigongService.selectById(id);
        if(zhigong !=null){
            //entity转view
            ZhigongView view = new ZhigongView();
            BeanUtils.copyProperties( zhigong , view );//把实体数据重构到view中

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
    public R save(@RequestBody ZhigongEntity zhigong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhigong:{}",this.getClass().getName(),zhigong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhigongEntity> queryWrapper = new EntityWrapper<ZhigongEntity>()
            .eq("username", zhigong.getUsername())
            .or()
            .eq("zhigong_phone", zhigong.getZhigongPhone())
            .or()
            .eq("zhigong_id_number", zhigong.getZhigongIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhigongEntity zhigongEntity = zhigongService.selectOne(queryWrapper);
        if(zhigongEntity==null){
            zhigong.setCreateTime(new Date());
            zhigong.setPassword("123456");
            zhigongService.insert(zhigong);
            return R.ok();
        }else {
            return R.error(511,"账户或者职工手机号或者职工身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhigongEntity zhigong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhigong:{}",this.getClass().getName(),zhigong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZhigongEntity> queryWrapper = new EntityWrapper<ZhigongEntity>()
            .notIn("id",zhigong.getId())
            .andNew()
            .eq("username", zhigong.getUsername())
            .or()
            .eq("zhigong_phone", zhigong.getZhigongPhone())
            .or()
            .eq("zhigong_id_number", zhigong.getZhigongIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhigongEntity zhigongEntity = zhigongService.selectOne(queryWrapper);
        if("".equals(zhigong.getZhigongPhoto()) || "null".equals(zhigong.getZhigongPhoto())){
                zhigong.setZhigongPhoto(null);
        }
        if(zhigongEntity==null){
            zhigongService.updateById(zhigong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者职工手机号或者职工身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhigongService.deleteBatchIds(Arrays.asList(ids));
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
            List<ZhigongEntity> zhigongList = new ArrayList<>();//上传的东西
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
                            ZhigongEntity zhigongEntity = new ZhigongEntity();
//                            zhigongEntity.setUsername(data.get(0));                    //账户 要改的
//                            //zhigongEntity.setPassword("123456");//密码
//                            zhigongEntity.setZhigongName(data.get(0));                    //职工姓名 要改的
//                            zhigongEntity.setZhigongPhone(data.get(0));                    //职工手机号 要改的
//                            zhigongEntity.setZhigongIdNumber(data.get(0));                    //职工身份证号 要改的
//                            zhigongEntity.setZhigongPhoto("");//详情和图片
//                            zhigongEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            zhigongEntity.setZhigongEmail(data.get(0));                    //电子邮箱 要改的
//                            zhigongEntity.setBumenTypes(Integer.valueOf(data.get(0)));   //部门 要改的
//                            zhigongEntity.setZhiweiTypes(Integer.valueOf(data.get(0)));   //职位 要改的
//                            zhigongEntity.setCreateTime(date);//时间
                            zhigongList.add(zhigongEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //职工手机号
                                if(seachFields.containsKey("zhigongPhone")){
                                    List<String> zhigongPhone = seachFields.get("zhigongPhone");
                                    zhigongPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zhigongPhone = new ArrayList<>();
                                    zhigongPhone.add(data.get(0));//要改的
                                    seachFields.put("zhigongPhone",zhigongPhone);
                                }
                                //职工身份证号
                                if(seachFields.containsKey("zhigongIdNumber")){
                                    List<String> zhigongIdNumber = seachFields.get("zhigongIdNumber");
                                    zhigongIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhigongIdNumber = new ArrayList<>();
                                    zhigongIdNumber.add(data.get(0));//要改的
                                    seachFields.put("zhigongIdNumber",zhigongIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ZhigongEntity> zhigongEntities_username = zhigongService.selectList(new EntityWrapper<ZhigongEntity>().in("username", seachFields.get("username")));
                        if(zhigongEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhigongEntity s:zhigongEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //职工手机号
                        List<ZhigongEntity> zhigongEntities_zhigongPhone = zhigongService.selectList(new EntityWrapper<ZhigongEntity>().in("zhigong_phone", seachFields.get("zhigongPhone")));
                        if(zhigongEntities_zhigongPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhigongEntity s:zhigongEntities_zhigongPhone){
                                repeatFields.add(s.getZhigongPhone());
                            }
                            return R.error(511,"数据库的该表中的 [职工手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //职工身份证号
                        List<ZhigongEntity> zhigongEntities_zhigongIdNumber = zhigongService.selectList(new EntityWrapper<ZhigongEntity>().in("zhigong_id_number", seachFields.get("zhigongIdNumber")));
                        if(zhigongEntities_zhigongIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhigongEntity s:zhigongEntities_zhigongIdNumber){
                                repeatFields.add(s.getZhigongIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [职工身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhigongService.insertBatch(zhigongList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhigongEntity zhigong = zhigongService.selectOne(new EntityWrapper<ZhigongEntity>().eq("username", username));
        if(zhigong==null || !zhigong.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(zhigong.getId(),username, "zhigong", "职工");
        R r = R.ok();
        r.put("token", token);
        r.put("role","职工");
        r.put("username",zhigong.getZhigongName());
        r.put("tableName","zhigong");
        r.put("userId",zhigong.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZhigongEntity zhigong){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ZhigongEntity> queryWrapper = new EntityWrapper<ZhigongEntity>()
            .eq("username", zhigong.getUsername())
            .or()
            .eq("zhigong_phone", zhigong.getZhigongPhone())
            .or()
            .eq("zhigong_id_number", zhigong.getZhigongIdNumber())
            ;
        ZhigongEntity zhigongEntity = zhigongService.selectOne(queryWrapper);
        if(zhigongEntity != null)
            return R.error("账户或者职工手机号或者职工身份证号已经被使用");
        zhigong.setCreateTime(new Date());
        zhigongService.insert(zhigong);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ZhigongEntity zhigong = new ZhigongEntity();
        zhigong.setPassword("123456");
        zhigong.setId(id);
        zhigongService.updateById(zhigong);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ZhigongEntity zhigong = zhigongService.selectOne(new EntityWrapper<ZhigongEntity>().eq("username", username));
        if(zhigong!=null){
            zhigong.setPassword("123456");
            boolean b = zhigongService.updateById(zhigong);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZhigong(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhigongEntity zhigong = zhigongService.selectById(id);
        if(zhigong !=null){
            //entity转view
            ZhigongView view = new ZhigongView();
            BeanUtils.copyProperties( zhigong , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
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
        PageUtils page = zhigongService.queryPage(params);

        //字典表数据转换
        List<ZhigongView> list =(List<ZhigongView>)page.getList();
        for(ZhigongView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhigongEntity zhigong = zhigongService.selectById(id);
            if(zhigong !=null){


                //entity转view
                ZhigongView view = new ZhigongView();
                BeanUtils.copyProperties( zhigong , view );//把实体数据重构到view中

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
    public R add(@RequestBody ZhigongEntity zhigong, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhigong:{}",this.getClass().getName(),zhigong.toString());
        Wrapper<ZhigongEntity> queryWrapper = new EntityWrapper<ZhigongEntity>()
            .eq("username", zhigong.getUsername())
            .or()
            .eq("zhigong_phone", zhigong.getZhigongPhone())
            .or()
            .eq("zhigong_id_number", zhigong.getZhigongIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhigongEntity zhigongEntity = zhigongService.selectOne(queryWrapper);
        if(zhigongEntity==null){
            zhigong.setCreateTime(new Date());
        zhigong.setPassword("123456");
        zhigongService.insert(zhigong);
            return R.ok();
        }else {
            return R.error(511,"账户或者职工手机号或者职工身份证号已经被使用");
        }
    }


}
