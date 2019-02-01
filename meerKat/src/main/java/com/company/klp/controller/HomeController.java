package com.company.klp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
	public String getCpuInfo(Locale locale, Model model, HttpServletResponse response) {
		

		DBConnectDTO dbDto = new DBConnectDTO();
		Connection conn = dbDto.getConnection();
		String query = "select * from t_cpu_info";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject dbObj = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				dbObj = new JSONObject();
				dbObj.put("_id", rs.getInt("_id"));
				dbObj.put("serverID", rs.getString("serverID"));
				dbObj.put("cpuNum", rs.getString("cpuNum"));
				dbObj.put("cpuUsed", rs.getString("cpuUsed"));
				dbObj.put("cpuFree", rs.getString("cpuFree"));
				dbObj.put("info1", rs.getString("info1"));
				dbObj.put("info2", rs.getString("info2"));
				dbObj.put("info3", rs.getString("info3"));
				jsonArr.add(dbObj);
				
				System.out.println("[_id] = "+rs.getInt("_id"));
				System.out.println("[serverID] = "+rs.getString("serverID"));
				System.out.println("[cpuNum] = "+rs.getString("cpuNum"));
				System.out.println("[cpuUsed] = "+rs.getString("cpuUsed"));
				System.out.println("[cpuFree] = "+rs.getString("cpuFree"));
				System.out.println("[info1] = "+rs.getString("info1"));
				System.out.println("[info2] = "+rs.getString("info2"));
				System.out.println("[info3] = "+rs.getString("info3"));
			}			
			jsonObj.put("serverCpuList", jsonArr);
			
			response.getWriter().print(jsonObj);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbDto.closeConnection(rs, pstmt, conn);
		}
		
		return null;
	}
	
	@RequestMapping(value = "getDiskInfo.do", method = RequestMethod.GET)
	public String getDiskInfo(Locale locale, Model model, HttpServletResponse response) {
		
		DBConnectDTO dbDto = new DBConnectDTO();
		Connection conn = dbDto.getConnection();
		String query = "select * from t_disk_info";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		JSONObject dbObj = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				dbObj = new JSONObject();
				dbObj.put("_id", rs.getInt("_id"));
				dbObj.put("serverID", rs.getString("serverID"));
				dbObj.put("DiskFileSystem", rs.getString("DiskFileSystem"));
				dbObj.put("DiskUsed", rs.getString("DiskUsed"));
				dbObj.put("DiskFree", rs.getString("DiskFree"));
				dbObj.put("DiskUsePerc", rs.getString("DiskUsePerc"));
				dbObj.put("DiskMountPath", rs.getString("DiskMountPath"));
				jsonArr.add(dbObj);
				
				System.out.println("[_id] = "+rs.getInt("_id"));
				System.out.println("[DiskFileSystem] = "+rs.getString("DiskFileSystem"));
				System.out.println("[DiskUsed] = "+rs.getString("DiskUsed"));
				System.out.println("[DiskFree] = "+rs.getString("DiskFree"));
				System.out.println("[DiskUsePerc] = "+rs.getString("DiskUsePerc"));
				System.out.println("[DiskMountPath] = "+rs.getString("DiskMountPath"));
			}			
			jsonObj.put("serverDiskList", jsonArr);
			
			response.getWriter().print(jsonObj);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbDto.closeConnection(rs, pstmt, conn);
		}
		
		return "home";
	}
	
}
