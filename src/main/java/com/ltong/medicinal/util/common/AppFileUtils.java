package com.ltong.medicinal.util.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class AppFileUtils {

    /**
     * 文件上传的保存路径  默认值
     */
    public static String UPLOAD_PATH = "D:/upload/";

    static {
        //通过反射的方式，读取配置文件的存储地址
        InputStream stream = AppFileUtils.class.getClassLoader().getResourceAsStream("file.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String property = properties.getProperty("filepath");
        if (null != property) {
            UPLOAD_PATH = property;
        }
    }

    /**
     * 根据文件老名字得到新名字
     *
     * @param oldName 文件老名字
     * @return 新名字由32位随机数加图片后缀组成
     */
    public static String createNewFileName(String oldName) {
        //获取文件名后缀
        String stuff = oldName.substring(oldName.lastIndexOf("."), oldName.length());
        //将UUID与文件名后缀进行拼接，生成新的文件名  生成的UUID为32位
        return IdUtil.simpleUUID().toUpperCase() + stuff;
    }

    /**
     * 文件下载
     *
     * @param path
     * @return
     */
    public static ResponseEntity<Object> createResponseEntity(String path) {
        //1,构造文件对象
        File file = new File(UPLOAD_PATH, path);
        if (file.exists()) {
            //将下载的文件，封装byte[]
            byte[] bytes = null;
            try {
                bytes = FileUtil.readBytes(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //创建封装响应头信息的对象
            HttpHeaders header = new HttpHeaders();
            //封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
            header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //创建ResponseEntity对象
            ResponseEntity<Object> entity = new ResponseEntity<Object>(bytes, header, HttpStatus.CREATED);
            return entity;
        }
        return null;
    }

    /**
     * 更该图片的名字 去掉_temp
     *
     * @param goodsImg
     * @return
     */
    public static String renameFile(String goodsImg) {
        File file = new File(UPLOAD_PATH, goodsImg);
        String replace = goodsImg.replace("_temp", "");
        if (file.exists()) {
            file.renameTo(new File(UPLOAD_PATH, replace));
        }
        return replace;
    }

    /**
     * 根据老路径删除图片
     *
     * @param oldPath
     */
    public static void removeFileByPath(String oldPath) {
        //图片的路径不是默认图片的路径
        if (!oldPath.equals(GlobalConstant.DEFAULT_IMG_GOODS)) {
            File file = new File(UPLOAD_PATH, oldPath);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    /**
     * 下载微信图像到本地
     *
     * @param urlStr
     */

    public static Map downloadPicture(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            InputStream is = con.getInputStream();
            //得到当前日期的字符串
            String dirName = DateUtil.format(new Date(), "yyyy-MM-dd");
            //构造文件夹
            File dirFile = new File(AppFileUtils.UPLOAD_PATH, dirName);
            //判断当前文件夹是否存在
            if (!dirFile.exists()) dirFile.mkdirs();
            String newName = IdUtil.simpleUUID().toUpperCase();
            //构造文件对象
            File file = new File(dirFile, newName + ".jpg_temp");
            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            OutputStream os = new FileOutputStream(file);  // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("path", dirName + "/" + newName + ".jpg_temp");
            if (os != null) os.close();
            if (is != null) is.close();
            return map ;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return null ;
    }

}
