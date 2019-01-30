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
public class HomeController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController2.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "getDiskInfo.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		DBConnectDTO dbDto = new DBConnectDTO();
		Connection conn = dbDto.getConnection();
		String query = "select * from t_disk_info";
		
		ResultSet rs = null;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			int i = 0;
			while(rs.next()) {
				System.out.println(rs.getString(i));
				i++;				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return "home";
	}
		
}
