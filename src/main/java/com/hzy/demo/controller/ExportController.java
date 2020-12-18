package com.hzy.demo.controller;

import com.hzy.demo.pojo.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ExportController {

    @GetMapping("exportExcel")
    public void exportExcel(HttpServletResponse response) {
        OutputStream oStream = null;
        try {
            HSSFWorkbook wb = new HSSFWorkbook();
            /*创建sheet*/
            HSSFSheet sheet = wb.createSheet("列表");
            /*创建表头*/
            HSSFRow row = sheet.createRow(0);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("用户名");
            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue("密码");
            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue("年龄");
            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue("身高");

            List<User> userArrayList = new ArrayList<>();

            userArrayList.add(new User("张三", "123", "23", "1.7"));
            userArrayList.add(new User("李四", "1234", "24", "1.8"));
            userArrayList.add(new User("王五", "12345", "25", "1.9"));
            userArrayList.add(new User("赵六", "123456", "26", "2.0"));
            userArrayList.add(new User("孙七", "1234567", "27", "2.1"));
            int i = 0;
            for (User user : userArrayList) {
                //创建表头
                HSSFRow lrow = sheet.createRow(i + 1);
                //创建单元格
                HSSFCell lcell = lrow.createCell(0);
                lcell.setCellValue(user.getUsername());
                HSSFCell lcell1 = lrow.createCell(1);
                lcell1.setCellValue(user.getPassword());
                HSSFCell lcell2 = lrow.createCell(2);
                lcell2.setCellValue(user.getAge());
                HSSFCell lcell3 = lrow.createCell(3);
                lcell3.setCellValue(user.getSex());
            }
            //根据response获取输出流
            response.setContentType("application/force-download"); // 设置下载类型
            response.setHeader("Content-Disposition", "attachment;filename=sxlb.xls"); // 设置文件的名称
            oStream = response.getOutputStream();
            //把工作薄写入到输出流
            wb.write(oStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
