package com.project.springboot.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.springboot.VO.PlatformVO;

@Mapper
public interface PlatformDAO {
	List<PlatformVO> selectAll();
	List<PlatformVO> selectNum(int platformNum);
}
