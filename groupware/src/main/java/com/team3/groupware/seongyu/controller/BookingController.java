package com.team3.groupware.seongyu.controller;

import com.team3.groupware.common.model.EmployeeVO;
import com.team3.groupware.seongyu.model.BookingVO;
import com.team3.groupware.seongyu.model.fixtureVO;
import com.team3.groupware.seongyu.model.meetingroomVO;
import com.team3.groupware.seongyu.service.BookingServce;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookingController {

    @Autowired
    BookingServce bookingServce;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public ModelAndView booking_view(){
        ModelAndView mv = new ModelAndView();
        List<EmployeeVO> empList = bookingServce.emp_num_name_select();
        List<meetingroomVO> meetingroom = bookingServce.meetingroom_list();
        List<fixtureVO> fixture = bookingServce.fixture_list();


        mv.addObject("emp_info", empList);
        mv.addObject("meetingroom", meetingroom);
        mv.addObject("fixture", fixture);
        mv.setViewName("../views/seongyu/booking/booking");
        return mv;
    }

    @RequestMapping(value = "bookingList", method = RequestMethod.GET)
    @ResponseBody
    public JSONArray booking_List(){
        List<BookingVO> list = bookingServce.bookingList();
        HashMap<String, Object> map = new HashMap<String, Object>();

        JSONObject jsonObj = new JSONObject();
        JSONArray jsonArr = new JSONArray();


        for(int i = 0; i < list.size(); i++){
            map.put("id", list.get(i).getBooking_num());
            map.put("title", list.get(i).getBooking_title());
            map.put("start", list.get(i).getBooking_start_date());
            map.put("end", list.get(i).getBooking_end_date());
            map.put("backgroundColor", list.get(i).getBooking_color());
            HashMap<String, Object> extendedProps = new HashMap<String, Object>();
            extendedProps.put("content", list.get(i).getBooking_memo());
            extendedProps.put("attendees", list.get(i).getBooking_attendees());
            extendedProps.put("meetingroom", list.get(i).getMeetingroom_num());
            extendedProps.put("fixtures_num", list.get(i).getFixtures_num());
            map.put("extendedProps", extendedProps);

            jsonObj = new JSONObject(map);
            jsonArr.add(jsonObj);
        }
        return jsonArr;
    }

    @RequestMapping(value = "/booking_add", method = RequestMethod.POST)
    @ResponseBody
    public String booking_insert(@RequestParam Map<String, Object> param){

        BookingVO check = bookingServce.booking_add_check(param);

        if(check == null){
            this.bookingServce.insert(param);
            return "success";
        } else {
            return "error";
        }

    }

    @RequestMapping(value = "/booking_delete", method = RequestMethod.POST)
    @ResponseBody
    public String bookingRemove(@RequestParam Map<String, Object> map){

        int remove = this.bookingServce.delete(map);

        if (remove == 1){
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/bookingDateChange", method = RequestMethod.POST)
    @ResponseBody
    public String bookingDateChange(@RequestParam Map<String, Object> map){
        int date_update = this.bookingServce.bookingDateChange(map);
        if(date_update == 1){
            return "success";
        } else{
            return "error";
        }
    }

    @RequestMapping(value = "/booking_event_change", method = RequestMethod.POST)
    @ResponseBody
    public String booking_event_change(@RequestParam Map<String, Object> map){

        int event_update = this.bookingServce.booking_event_change(map);

        if(event_update == 1){
            return "success";
        } else{
            return "error";
        }
    }
}
