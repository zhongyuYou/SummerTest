package com.zretc.student_backed.controller;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.zretc.student_backed.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/*文件上传控制类*/
@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${files.upload.path}")
    private String fileUploadPath;
    @Value("${files.upload.fileMapper}")
    private String fileMapper;   //图标映射路径
    /**
     * 文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public R upload(@RequestParam MultipartFile file) throws IOException {
        //获取文件名
        String originalFilename = file.getOriginalFilename();
        //获取文件的后缀（类型）
        String fileType = FileUtil.extName(originalFilename);
        long size = file.getSize();//文件大小
//将文件先存储到磁盘
        File uploadParentFile = new File(fileUploadPath);
        //判断存储文件的目录是否存在，不存在则创建
        if (!uploadParentFile.exists()){
            uploadParentFile.mkdirs();
        }
        //定义唯一标识码，从新命名文件
        String uuid = IdUtil.fastSimpleUUID();
        String fileName = uuid+ StrUtil.DOT+fileType;
        //文件路径与下载接口路径一样
        String url = fileMapper + fileName;
        //将文件写入磁盘
        File uploadFile = new File(fileUploadPath + fileName);
        file.transferTo(uploadFile);
        return R.success(url);
    }
    @GetMapping("/download/{fileUUID}")
    public void downLoad(@PathVariable String fileUUID, HttpServletResponse
            response) throws IOException {
        //根据文件标识码获取文件
        File file = new File(fileUploadPath + fileUUID);
        //设置输出流对象
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Context-Disposition","attachment;filename="+
                URLEncoder.encode(fileUUID,"UTF-8"));
        response.setContentType("application/octet-stream");
        //读取字节流
        os.write(FileUtil.readBytes(file));
        os.flush();
        os.close();
    }
}
