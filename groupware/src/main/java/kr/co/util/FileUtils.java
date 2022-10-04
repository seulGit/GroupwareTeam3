package kr.co.util;

import com.team3.groupware.seongyu.model.EDMS_docuVO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.*;

@Component("fileUtils")
public class FileUtils {
    private static final String filePath = "C:\\mp\\file\\";

    public List<Map<String, Object>> parseInsertFileInfo(EDMS_docuVO edms_docuVO,
                                                         MultipartHttpServletRequest mpRequest) throws Exception{
        Iterator<String> iterator = mpRequest.getFileNames();

        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> listMap = null;

        int edms_docu_num = edms_docuVO.getEDMS_docu_num();

        File file = new File(filePath);
        if(file.exists() == false) {
            file.mkdirs();
        }

        while(iterator.hasNext()){
            multipartFile = mpRequest.getFile(iterator.next());
            if(multipartFile.isEmpty() == false){
                originalFileName = multipartFile.getOriginalFilename();
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                storedFileName = getRandomString() + originalFileExtension;
                
                file = new File(filePath + storedFileName);
                multipartFile.transferTo(file);
                listMap = new HashMap<>();
                listMap.put("EDMS_docu_num", edms_docu_num);
                listMap.put("ORG_File_name", storedFileName);
                listMap.put("File_size", multipartFile.getSize());
                list.add(listMap);
            }
        }
        return list;
    }

    public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
