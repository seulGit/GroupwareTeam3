package kr.co.util;

import com.team3.groupware.seongyu.model.EDMS_new_certificateVO;
import com.team3.groupware.seongyu.model.EDMS_new_expenseVO;
import com.team3.groupware.seongyu.model.EDMS_new_generalVO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.*;

@Component("fileUtils")
public class FileUtils {
    private static final String filePath = "C:\\mp\\file\\";

    public List<Map<String, Object>> parse_insert_file_info_general(EDMS_new_generalVO edms_new_generalVO,
                                                         MultipartHttpServletRequest mpRequest) throws Exception{
        Iterator<String> iterator = mpRequest.getFileNames();

        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> listMap = null;

        int edms_docu_num = edms_new_generalVO.getEDMS_docu_num();

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
                System.out.println(edms_docu_num);

                listMap.put("ORG_File_name", originalFileName);
                System.out.println(originalFileName);

                listMap.put("STORED_FILE_NAME", storedFileName);

                listMap.put("File_size", multipartFile.getSize());
                System.out.println(multipartFile.getSize());

                list.add(listMap);
            }
        }
        return list;
    }
    public List<Map<String, Object>> parse_insert_file_info_expense(EDMS_new_expenseVO edms_new_expenseVO,
                                                         MultipartHttpServletRequest mpRequest) throws Exception{
        Iterator<String> iterator = mpRequest.getFileNames();

        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> listMap = null;

        int edms_docu_num = edms_new_expenseVO.getEDMS_docu_num();

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
                System.out.println(edms_docu_num);

                listMap.put("ORG_File_name", originalFileName);
                System.out.println(originalFileName);

                listMap.put("STORED_FILE_NAME", storedFileName);

                listMap.put("File_size", multipartFile.getSize());
                System.out.println(multipartFile.getSize());

                list.add(listMap);
            }
        }
        return list;
    }
    public List<Map<String, Object>> parse_insert_file_info_certificate(EDMS_new_certificateVO edms_new_certificateVO,
                                                         MultipartHttpServletRequest mpRequest) throws Exception{
        Iterator<String> iterator = mpRequest.getFileNames();

        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> listMap = null;

        int edms_docu_num = edms_new_certificateVO.getEDMS_docu_num();

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
                System.out.println(edms_docu_num);

                listMap.put("ORG_File_name", originalFileName);
                System.out.println(originalFileName);

                listMap.put("STORED_FILE_NAME", storedFileName);

                listMap.put("File_size", multipartFile.getSize());
                System.out.println(multipartFile.getSize());

                list.add(listMap);
            }
        }
        return list;
    }

    public static String getRandomString(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
