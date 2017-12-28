package com.example.demo.util;

import au.com.bytecode.opencsv.CSVWriter;
import com.csvreader.CsvWriter;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/12/13.
 */
public class CsvUtil {


    /**
     * 推荐导出应用
     * @param results 封装的数据
     * @param filePath 导出文件的路径
     * @param format 格式化  ，分割
     * @param paramCharset  导出文件的编码格式
     * @return
     */
    public File exportCsv(List<String[]> results, String filePath, char format, String paramCharset ){
        try {
            CsvWriter writer = new CsvWriter(filePath, format, Charset.forName(paramCharset));
            for(String[] re:results){
                writer.writeRecord(re);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(filePath);

    }

    /**
     * 根据传入的集合导出成csv文件,可指定行数
     * @param datas   集合
     * @param name    文件名
     * @param size    文件行数
     */
    public static void  exportCsvName(List<String[]> datas,String name,int size) {
        try {
            int listSize = datas.size();
            int num = listSize%size==0?listSize/size:(listSize/size+1);
            int start = 0;
            int end = 0;
            File fileM = new File("/tmp/" + name);

            if (!fileM.exists()) {
                fileM.mkdir();
            }

            for(int i=1;i<=num;i++)
            {
                start = (i-1)*size;
                end = i*size > listSize ? listSize : i*size;
                System.out.println(start+":"+end);
                List<String[]> dataN = datas.subList(start, end);
                String path = "/tmp/"+ name + "/" + (null==name?System.currentTimeMillis():name)+ "-"+ i + ".csv";
                File file = new File(path);
                //Writer writer = new FileWriter(file);
                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");

                CSVWriter csvWriter =  new CSVWriter(osw, ',');
                csvWriter.writeAll(dataN);
                csvWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<ArrayList<String>> readCSVFile(String fileName) {
        ArrayList<ArrayList<String>> listFile = new ArrayList<ArrayList<String>>();
        try {
            File txtName = new File(fileName);
            InputStreamReader fr = new InputStreamReader(new FileInputStream(txtName), "UTF-8");
            BufferedReader br = new BufferedReader(fr);
            String rec = null;// 一行
            String str;// 一个单元格
            while ((rec = br.readLine()) != null) { // 读取每个单元格
                Pattern pCells = Pattern
                        .compile("(\"[^\"]*(\"{2})*[^\"]*\")*[^,]*,?");
                Matcher mCells = pCells.matcher(rec);
                ArrayList<String> cells = new ArrayList<String>();// 每行记录一个list
                while (mCells.find()) {// 读取每个单元格
                    str = mCells.group();
                    byte[] bytes = str.trim().getBytes();
                    str = new String(bytes, "UTF-8");
                    str = str.replaceAll(
                            "(?sm)\"?([^\"]*(\"{2})*[^\"]*)\"?.*", "$1");
                    str = str.replaceAll("(?sm)(\"(\"))", "$2");
                    str = str.replaceAll("\"", "");
                    str = totalReplace(str);
                    if(StringUtils.isNotEmpty(str)) {
                        str = str.trim();
                        if (str.endsWith(",")) {
                            str = str.substring(0, str.length() -1);
                        }
                    }
                    cells.add(str);
                }
                listFile.add(cells);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listFile;
    }

    public String totalReplace(String str) {
        Pattern p = Pattern.compile("-?\\d+[.,/,]\\d+|-?\\d+[.,/,]\\d+[.,/,]\\d+");
        String u = str.trim();
        Matcher m = p.matcher(u);
        if (m.matches()) {
            Pattern p2 = Pattern.compile("-?\\d+,\\d+|-?\\d+,\\d+[.,/,]\\d+");
            if (p2.matcher(u).matches()) {
                Pattern p3 = Pattern.compile("-?\\d+,\\d+");
                if (p3.matcher(u).matches()) {
                    u = u.replace(",", ".");
                } else {
                    u = u.replaceFirst(",", "");
                    u = u.replace(",", ".");
                }
            } else {
                p2 = Pattern.compile("-?\\d+.\\d+,\\d+");
                if (p2.matcher(u).matches()) {
                    u = u.replace(".", "");
                    u = u.replaceFirst(",", ".");
                }
            }
        }
        return u;
    }

}
