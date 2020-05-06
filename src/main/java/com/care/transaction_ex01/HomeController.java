package com.care.transaction_ex01;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.care.service.*;
import com.care.transaction_dto.TicketDTO;
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private TicketService ts;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping("buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
 }
	@RequestMapping("buy_ticket_card")
	public String buy_ticket_card(TicketDTO dto, Model model) {
		ts = new TicketServiceImpl();
		model.addAttribute("dto",dto);
		ts.execute(model);
		return "buy_ticket_end";
	}
	@RequestMapping("result")
	public String result(Model model) {
		ts = new TicketResultServiceImpl();
		ts.execute(model);
		return "result_ticket";
	}
}















