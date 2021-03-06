package com.bai.easypoi.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.bai.easypoi.excel.LineExcelEntity;
import com.bai.easypoi.response.CommonResponse;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class EasyPoiService {


    public CommonResponse uploadExcel(MultipartFile uploadFile, String flowCode) {
        CommonResponse res = new CommonResponse();

        ImportParams params = new ImportParams();
        //数据处理
        params.setHeadRows(1);
        params.setTitleRows(1);
        //验证 备注：3.0的poi版本开启验证的设置setNeedVerfiy 名称错误
       params.setNeedVerify(true);
        try {
            //NO.1 第一种方式map的格式
            long start = System.currentTimeMillis();
            List<Map> entities1 = ExcelImportUtil.importExcel(
                    uploadFile.getInputStream(),
                    Map.class,
                    params
            );
            System.out.println("EasyPoiService.uploadExcel 导入执行时间为：" +(System.currentTimeMillis()-start) +"毫秒");

            for (Map map: entities1){
                System.out.println(map);
            }
            /**
             * NO.2 第二种格式数据对象的格式
             * 需要注意的是 数据对象里的实体类型要与 excel模板中的数据类型对应
             */

            ImportParams p = new ImportParams();
            p.setHeadRows(1);
            p.setTitleRows(1);
            //开启验证
            p.setNeedVerify(true);

            ExcelImportResult<LineExcelEntity> result = ExcelImportUtil.importExcelMore(uploadFile.getInputStream(),
                                                        LineExcelEntity.class,
                                                        p);
            //获取读取成功的数据
            List<LineExcelEntity> entities = result.getList();
            for(LineExcelEntity lee:entities){
                System.out.println(ReflectionToStringBuilder.toString(lee));
            }
            System.out.println("EasyPoiService.uploadExcel:" + entities.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
