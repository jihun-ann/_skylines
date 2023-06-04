package com.project.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.springboot.DAO.FlightScheduleDAO;
import com.project.springboot.DAO.ReservationDAO;
import com.project.springboot.VO.FlightScheduleVO;
import com.project.springboot.VO.ReservationVO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ReservationController {

	ReservationDAO rsMapper;
	FlightScheduleDAO fsMapper;
	
	@Autowired
	public ReservationController(ReservationDAO rsMapper ,FlightScheduleDAO fsMapper) {
		super();

		this.rsMapper = rsMapper;
		this.fsMapper = fsMapper;
	}
	
	
	@PostMapping("/rs_search")
	public @ResponseBody FlightScheduleVO search(@RequestBody FlightScheduleVO fs_vo, Model model) {
		fs_vo.setDates(fs_vo.getDate().substring(13,23));
		fs_vo.setDate(fs_vo.getDate().substring(0,10));
		System.out.println("정말 됨? "+ fs_vo);
		FlightScheduleVO res = fsMapper.search(fs_vo);
		
		
		model.addAttribute("res", res);
		System.out.println("res>>>"+res);
		return res; 
	}

	
	
	@GetMapping("/rs_list")
	public String list(Model model) {
		List<ReservationVO> rs_vo = rsMapper.selectAll();
		model.addAttribute("rs_list",rs_vo);
		return "rs_list";
	}
	
	@PostMapping("/rs_insert")
	public String insert(ReservationVO rs_vo,Model model) {
		//System.out.println(rs_vo);
		int res = rsMapper.save(rs_vo);
		//model.addAttribute("res",res);
		//return "result";
		return"redirect:/rs_list";
		
		
		
		// redirect는 값을 못 넘김
	}
	
	@GetMapping("/rs_delete")
	public String delete(int reservationNum) {
		rsMapper.delete(reservationNum);
		return "redirect:/rs_list";
	}
	
}
	
