package com.team3.groupware.nohyun.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.team3.groupware.nohyun.model.AddressAllVO;
import com.team3.groupware.nohyun.service.AddressAllService;

@RestController
public class AddressAllController {
	
	@Autowired
	AddressAllService addressAllService;
	
	@RequestMapping(value = "address_all")
	public ModelAndView list(@RequestParam Map<String, Object> map) {
		System.out.println(map.toString());
		List<Map<String, Object>> list = this.addressAllService.list(map);
		ModelAndView mv = new ModelAndView(); //
		mv.addObject("data", list);

		mv.setViewName("nohyun/address/address_all");
		return mv;

	}
	@RequestMapping(value="ajaxChosung")
	public ModelAndView list_chosung(@RequestParam Map<String, Object> chosung) {
		System.out.println(chosung.toString());
		List<Map<String, Object>> list = this.addressAllService.list_chosung(chosung);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("nohyun/address/address_all_list");
		mv.addObject("data", list);
		
		return mv;
	}
	@RequestMapping(value="ajaxChosungAll")
	public ModelAndView list_whole(@RequestParam Map<String, Object> whole) {
		System.out.println(whole.toString());
		List<Map<String, Object>> list = this.addressAllService.list_whole(whole);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("nohyun/address/address_all_list");
		mv.addObject("data", list);
		
		return mv;
	}
	
	@RequestMapping(value="ajaxSearch")
	public ModelAndView keyword_search(@RequestParam Map<String, Object> keyword) {
		
		List<Map<String, Object>> list = this.addressAllService.keyword_search(keyword);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("nohyun/address/address_all_list");
		mv.addObject("data", list);
		
		return mv;
	}
	
	@RequestMapping(value="address_all_info")
	public ModelAndView address_info(@RequestParam Map<String, Object> AllInfo) {

		List<Map<String, Object>> addressInfo = this.addressAllService.addressInfo(AllInfo);
		ModelAndView mv = new ModelAndView(); //
		mv.addObject("addressInfo", addressInfo);

		mv.setViewName("nohyun/address/address_all_info");
		return mv;

	}
	
	@RequestMapping("/address_all/excelDown")
	public void excelDownload(HttpServletResponse response,@ModelAttribute("ExcelDown")AddressAllVO ExcelDown) throws IOException{
		XSSFWorkbook wb=null;
		Sheet sheet=null;
		Row row=null;
		Cell cell=null; 
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("전사주소록");
		
		List<AddressAllVO> excelList = this.addressAllService.excelList(ExcelDown);
		
		//첫행   열 이름 표기 
				int cellCount=0;
				row = sheet.createRow(0); //0번째 행
				cell=row.createCell(cellCount++);
				cell.setCellValue("이름(표시명)");
				cell=row.createCell(cellCount++);
				cell.setCellValue("직위");
				cell=row.createCell(cellCount++);
				cell.setCellValue("휴대폰");
				cell=row.createCell(cellCount++);
				cell.setCellValue("이메일");
				cell=row.createCell(cellCount++);
				cell.setCellValue("부서");
				cell=row.createCell(cellCount++);
				cell.setCellValue("회사전화");
				cell=row.createCell(cellCount++);
				cell.setCellValue("주소");
				
				for(int i=0; i < excelList.size() ; i++  ) {
					row=sheet.createRow(i+1);  // '열 이름 표기'로 0번째 행 만들었으니까 1번째행부터
					cellCount=0; //열 번호 초기화
					cell=row.createCell(cellCount++);
					cell.setCellValue(excelList.get(i).getEmp_name());
					cell=row.createCell(cellCount++);
					cell.setCellValue(excelList.get(i).getPosition_grade());
					cell=row.createCell(cellCount++);
					cell.setCellValue(excelList.get(i).getEmp_phonenum());
					cell=row.createCell(cellCount++);
					cell.setCellValue(excelList.get(i).getEmp_email());
					cell=row.createCell(cellCount++);
					cell.setCellValue(excelList.get(i).getDept_name());
					cell=row.createCell(cellCount++);
					cell.setCellValue(excelList.get(i).getEmp_desk_num());
					cell=row.createCell(cellCount++);
					cell.setCellValue(excelList.get(i).getEmp_address());
					cell=row.createCell(cellCount++);
					
				}
		
		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename=addressAll.xlsx");  //파일이름지정.
		//response OutputStream에 엑셀 작성
		wb.write(response.getOutputStream());
	}
	

	
}
