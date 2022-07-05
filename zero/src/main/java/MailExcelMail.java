import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

/**
 * @author ZuoHao
 * @date 2021/12/14
 */
public class MailExcelMail {
    public static void main(String[] args) {
        System.out.println(172683/60/60);
        System.out.println(5485.76 + 11081.59);
//        tacitQuestion();
//        trueWords();
    }
    public static void tacitQuestion(){
        String sql = "insert into TacitQuestion (id, question, useStatus, createUser, updateUser, createTime, updateTime) values (%s, '%s', 1, '左浩', '左浩', now(),now());";
        ExcelReader reader;
        reader = ExcelUtil.getReader(FileUtil.file("./升温话题与真心话文案12.14.xlsx"), 0);
        List<List<Object>> rols = reader.read();
        int id = 100;
        for (int i = 1; i < rols.size(); i++) {
            List<Object> rol = rols.get(i);
            System.out.println(String.format(sql,id,rol.get(0)));
            id++;
        }
    }
    public static void trueWords(){
        String sql = "insert into TrueWordsQuestion (id, useStatus, question, createUser, updateUser, createTime, updateTime) values (%s, 1, '%s', '左浩', '左浩', now(), now());";
        String answerSql = "insert into TrueWordsAnswer (questionId, optionContent, orderIndex, useStatus, createTime, updateUser, updateTime) values (%s, '%s', 1, 1, now(), '左浩', now());";
        ExcelReader reader;
        reader = ExcelUtil.getReader(FileUtil.file("./升温话题与真心话文案12.14.xlsx"), 1);
        List<List<Object>> rols = reader.read();
        int id = 100;
        for (int i = 1; i < rols.size(); i++) {
            List<Object> rol = rols.get(i);
            System.out.println(String.format(sql,id,rol.get(0)));

            String options = (String) rol.get(1);
            String[] split = options.split("\n");
            for (int j = 0; j < split.length; j++) {
                System.out.println(String.format(answerSql,id,split[j].trim().substring(2)));
            }
            id++;
        }
    }
}
