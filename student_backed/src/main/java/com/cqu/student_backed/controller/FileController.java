package com.cqu.student_backed.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.cqu.student_backed.utils.R;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传控制类
 */
@RestController
@RequestMapping("/file")
public class FileController {
    //读取文件上传的路径
    @Value("${files.upload.path}")
    private String fileUpload;

    //读取文件映射路径
    @Value("${files.upload.fileMapper}")
    private String fileMapper;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R upload(@RequestParam MultipartFile file) throws IOException {
        //1.获取文件名
        String originalFilename = file.getOriginalFilename();
        //2.获取文件的后缀
        String fileType = FileUtil.extName(originalFilename);
        //3.获取文件的大小
        long size = file.getSize();
        //4.创建文件对象
        File uploadParentFile = new File(fileUpload);
        //5.判断存储文件的目录是否存在，不存在则创建
        if (!uploadParentFile.exists()){
            //创建目录
            uploadParentFile.mkdirs();
        }
        //6.重新命名文件 uuid
        String uuid = IdUtil.fastSimpleUUID();
        String fileName = uuid+ StrUtil.DOT+fileType;
        //7.设置文件路径
        String url = fileMapper + fileName;
        //8.将文件写入磁盘
        File uploadFile = new File(fileUpload+"/"+fileName);
        file.transferTo(uploadFile);
        //9.文件上传成功以后，返回路径给前端
        return R.success(url);
    }
}

