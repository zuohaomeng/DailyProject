import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author ZuoHao
 * @date 2021/12/1
 */
public class ExcelMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n\n\n");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);


        Random random = new Random();
        System.out.println(random.nextInt(list.size()));
        System.out.println(random.nextInt(list.size()));
//        ExcelReader reader;
//        reader = ExcelUtil.getReader(FileUtil.file("./聊天助手内容文案优化.xlsx"), 1);
//        List<List<Object>> rols = reader.read();
//        commonConverter(rols,2,22,"INTRODUCE");
//        commonConverter(rols,25,49,"INTRODUCE_BOTH");


//        reader = ExcelUtil.getReader(FileUtil.file("./聊天助手内容文案优化.xlsx"), 2);
//        List<List<Object>> rols = reader.read();
//        commonConverter(rols,2,34,"MARRIAGE_VIEW");
//        commonConverter(rols,37,69,"MARRIAGE_VIEW_BOTH");
//        commonConverter(rols,72,96,"MARRIAGE_VIEW_DIFF");



//        reader = ExcelUtil.getReader(FileUtil.file("./聊天助手内容文案优化.xlsx"), 3);
//        List<List<Object>> rols = reader.read();
//        commonConverter(rols,20,34,"PROFILE_OCCUPATION_BOTH");
//        commonConverter(rols,49,53,"PROFILE_PLACE_BOTH");
//        commonConverter(rols,56,67,"PROFILE_CONSTELLATION");
//        commonConverter(rols,70,81,"PROFILE_CONSTELLATION_BOTH");
//        commonConverter(rols,83,100,"PROFILE_CONSTELLATION_DIFF");
//        commonConverter(rols,83,100,"PROFILE_CONSTELLATION_DIFF");
//        commonConverter(rols,103,109,"PROFILE_WORKCITY_BOTH");
//        commonConverter(rols,112,115,"PROFILE_NATIONALITY_BOTH");

//        reader = ExcelUtil.getReader(FileUtil.file("./聊天助手内容文案优化.xlsx"), 4);
//        List<List<Object>> rols = reader.read();
//        commonConverter(rols,2,6,"INTEREST");

//        reader = ExcelUtil.getReader(FileUtil.file("./聊天助手内容文案优化.xlsx"), 5);
//        List<List<Object>> rols = reader.read();
//        commonConverter(rols,1,30,"RANDOM");

//        reader = ExcelUtil.getReader(FileUtil.file("./聊天助手内容文案优化.xlsx"), 7);
//        List<List<Object>> rols = reader.read();
//        occupation(rols,1,205,"PROFILE_OCCUPATION");

        System.out.println("\n\n\n");
    }

    /**
     * 1.内心独白
     * @param rols
     */
    private static void occupation(List<List<Object>> rols,int start,int end,String typeStr) {
        String name = "";
        int num = 0;
        for (int i = start; i <= end; i++) {
            List<Object> rol = rols.get(i);
            if(Objects.equals(name,rol.get(1))){
                continue;
            }
            String manStr = (String)rol.get(3);
            num++;
            StringBuilder sb = new StringBuilder();
            sb.append(typeStr+"_KEY").append(num);

            sb.append("("+typeStr+".getType(),")
                    .append(num+"00")

                    .append(",\"")
                    .append(rol.get(1))
                    .append("\"")

                    .append(",\"")
                    .append(rol.get(3))
                    .append("\"")

                    .append(",\"")
                    .append(rol.get(4))
                    .append("\"")

                    .append("),");
            name = (String) rol.get(1);

            System.out.println(sb.toString());
        }
    }
    private static void commonConverter(List<List<Object>> rols,int start,int end,String typeStr){
        for (int i = start; i <= end; i++) {
            List<Object> rol = rols.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append(typeStr+"_KEY").append(rol.get(1));

            sb.append("("+typeStr+".getType(),")
                    .append(rol.get(1))

                    .append(",\"")
                    .append(rol.get(2))
                    .append("\"")

                    .append(",\"")
                    .append(rol.get(3))
                    .append("\"")

                    .append(",\"")
                    .append(rol.get(4))
                    .append("\"")

                    .append("),");

            System.out.println(sb.toString());
        }
    }


}
