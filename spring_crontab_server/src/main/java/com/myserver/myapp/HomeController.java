package com.myserver.myapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myserver.model.User;
import com.myserver.model.Users;
import com.myserver.model.VO;
import com.myserver.model.VOList;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired private ResourceLoader resourceLoader;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public String parseXml(HttpServletResponse request) throws IOException {
		InputStream is = getClass().getResourceAsStream("/report.xml");
		Reader br = new InputStreamReader(is);
//	    BufferedReader br = new BufferedReader(new InputStreamReader(
//	    	    getClass().getResourceAsStream(
//	    	            "/resources/report.xml")));
//		String result = IOUtils.
	    
	    return null;
	}
    @RequestMapping(value = "/service")
    public @ResponseBody VOList test1(){
    	List<VO> list = new ArrayList<VO>();
		VOList volist = new VOList();
		list.add(new VO(1, "a", 2));
		list.add(new VO(2, "b", 3));
		list.add(new VO(3, "c", 4));
		volist.setList(list);
    	return volist;
    }
	@RequestMapping(value="/userlist.do", produces="application/xml")
	public @ResponseBody Users getUsersToXml() {
		
		/*-----------------------------------------------------------------------------------------------------
		 * 서비스, 스토어 없이 여기서 생성하겠다.
		 * --------------------------------------------------------------------------------------------------*/ 
		
		List<User> list = new ArrayList<User>();
		Users users = new Users();
		
		User u1 = new User();
		u1.setNo(1);
		u1.setId("abc");
		u1.setPw("123");
		u1.setName("강대봉");
		u1.setAddress("서울시");
	
		User u2 = new User();
		u2.setNo(1);
		u2.setId("adfgbc");
		u2.setPw("1234");
		u2.setName("홍구");
		u2.setAddress("서울시");
		
		list.add(u1);
		list.add(u2);
		
		users.setUsers(list);
		
		return users;
	}
}
