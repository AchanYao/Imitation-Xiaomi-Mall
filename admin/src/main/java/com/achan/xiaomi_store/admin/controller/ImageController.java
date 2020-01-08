package com.achan.xiaomi_store.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Achan
 */
@RestController
@RequestMapping("/api/admin/image")
@Api("图片")
public class ImageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageController.class);

    @PostMapping("/upload")
    @ApiOperation("图片上传")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {

        String path = "/upload/";
        HashMap<String, String> result = new HashMap<>(4);
        String realPath = request.getServletContext().getRealPath(path);
        String format = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String newName = uuid + oldName.substring(oldName.lastIndexOf('.'), oldName.length());
        File newFile = new File(folder, newName);
        file.transferTo(newFile);
        String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + path + format + "/" + newName;
        result.put("uuid", uuid);
        result.put("oldName", oldName);
        result.put("url", filePath);
        result.put("path", newFile.getAbsolutePath());
        LOGGER.info("文件保存路径：{}", result.get("path"));
        return filePath;
    }
}
