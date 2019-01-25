package com.bai.easypoi.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;

@ExcelTarget("LineExcelEntity")
public class LineExcelEntity implements Serializable {

    @Excel(name = "编号1",orderNum = "0")
    private Long id;
    /**编号*/
    @Excel(name = "编号",orderNum = "1")
    private String lineCode;
    /**名称*/
    @Excel(name = "名称",orderNum = "2")
    private String lineName;
    /**状态*/
    @Excel(name = "状态",orderNum = "3")
    private Integer status;
    /**虚拟线路编号*/
    @Excel(name = "虚拟线路编号",orderNum = "4")
    private String lineVmNumber;
    /**线路备注*/
    @Excel(name = "备注",orderNum = "5")
    private String description;

    public LineExcelEntity() {
    }

    public LineExcelEntity(Long id, String lineCode, String lineName, Integer status, String lineVmNumber, String description) {
        this.id = id;
        this.lineCode = lineCode;
        this.lineName = lineName;
        this.status = status;
        this.lineVmNumber = lineVmNumber;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getLineVmNumber() {
        return lineVmNumber;
    }

    public void setLineVmNumber(String lineVmNumber) {
        this.lineVmNumber = lineVmNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
