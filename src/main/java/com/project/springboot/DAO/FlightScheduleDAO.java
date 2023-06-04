package com.project.springboot.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.project.springboot.VO.FlightScheduleVO;

@Mapper
public interface FlightScheduleDAO {
	List<FlightScheduleVO> search();
	FlightScheduleVO search(FlightScheduleVO fs_vo);
	List<FlightScheduleVO> searchName();
	FlightScheduleVO searchnum();
}
