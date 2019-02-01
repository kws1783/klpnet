package com.company.klp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.klp.dto.DBConnectDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "list2.do", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "getCpuInfo.do", method = RequestMethod.GET)
	public String getCpuInfo(Locale locale, Model model) {
		
		DBConnectDTO dbDto = new DBConnectDTO();
		Connection conn = dbDto.getConnection();
		//PreparedStatement pstmt = 
		
		
		return "home2";
	}
	
	@RequestMapping(value = "getDiskInfo.do", method = RequestMethod.GET)
	public String getDiskInfo(Locale locale, Model model) {
		
		DBConnectDTO dbDto = new DBConnectDTO();
		Connection conn = dbDto.getConnection();
		String query = "select * from t_cpu_info";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				System.out.println(rs.getInt("_id"));
				System.out.println(rs.getString("serverID"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbDto.closeConnection(rs, pstmt, conn);
		}
		
		
		
		return "home";
	}
	
}
