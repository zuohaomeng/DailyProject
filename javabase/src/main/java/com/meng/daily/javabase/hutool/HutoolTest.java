package com.meng.daily.javabase.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZuoHao
 * @date 2022/9/2
 */
public class HutoolTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("150个ID信息调整.xlsx"), 0);
        List<Map<String, Object>> readAll = reader.readAll();
        readAll.forEach(map -> {
            Object memberId = map.get("id");
            Object area = map.get("pron");
            System.out.printf("hashMap.put(%sL,\"%s\");%n", memberId, area);
        });
    }
}
