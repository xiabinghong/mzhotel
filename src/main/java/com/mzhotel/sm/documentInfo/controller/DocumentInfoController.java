package com.mzhotel.sm.documentInfo.controller;

import com.mzhotel.sm.documentInfo.dto.DocumentInfo;
import com.mzhotel.sm.documentInfo.service.DocumentInfoService;
import com.mzhotel.sm.userInfo.service.UserInfoService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping(value = "/documentInfo")
public class DocumentInfoController {

    @Autowired
    DocumentInfoService documentInfoService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public DocumentInfo upload(@RequestPart(value = "file") MultipartFile file, HttpServletRequest request) {
        try {
            String path = request.getServletContext().getRealPath("/sm/upload/image");
            if (file != null) {
                String originalFilename = file.getOriginalFilename();
                String fileName = new Date().getTime() + "" + originalFilename;
                String savePath = path + "\\" + fileName;
                FileOutputStream fos = FileUtils.openOutputStream(new File(savePath));//打开FileOutStrean流
                IOUtils.copy(file.getInputStream(), fos);
                fos.close();
                DocumentInfo documentInfo = new DocumentInfo();
                documentInfo.setCreatedBy(userInfoService.getCurrUser());
                documentInfo.setCreatedDate(new Date());
                documentInfo.setName(originalFilename);
                documentInfo.setUrl(savePath);
                documentInfo.setSaveName(fileName);
                return documentInfoService.insert(documentInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteByPrimaryKey(@PathVariable(value = "id") String id) {
        return documentInfoService.deleteByPrimaryKey(id);
    }

    @RequestMapping(value = "/insertSelective", method = RequestMethod.POST)
    public int insertSelective(@RequestBody @Valid DocumentInfo record) {
        return documentInfoService.insertSelective(record);
    }

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)
    public DocumentInfo selectByPrimaryKey(@PathVariable(value = "id") String id) {
        return documentInfoService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective", method = RequestMethod.DELETE)
    public int updateByPrimaryKeySelective(@PathVariable(value = "id") String id,
                                           @RequestBody @Valid DocumentInfo record) {
        return documentInfoService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.DELETE)
    public int updateByPrimaryKey(@PathVariable(value = "id") String id,
                                  @RequestBody @Valid DocumentInfo record) {
        return documentInfoService.updateByPrimaryKey(record);
    }

}
