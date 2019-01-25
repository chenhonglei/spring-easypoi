package com.bai.easypoi.controller;

import com.bai.easypoi.response.CommonResponse;
import com.bai.easypoi.service.EasyPoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/easy/poi")
public class EasyPoiController {

    @Autowired
    private EasyPoiService easyPoiService;
    /**
     * 文件批量导入操作
     * @param uploadFile
     * @param flowCode
     * @return
     */
    @PostMapping(value = "upload/excel")
    public CommonResponse uploadExcel(@RequestParam MultipartFile uploadFile,
                               String flowCode){

        CommonResponse res = this.easyPoiService.uploadExcel(uploadFile,flowCode);
        return res;

    }
}
