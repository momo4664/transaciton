package com.care.service;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.care.transaction_dao.TicketDAO;

public class TicketResultServiceImpl implements TicketService{
	private TicketDAO dao;
	public TicketResultServiceImpl() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext(config);
		dao = ctx.getBean("dao",TicketDAO.class);
	}
	public void execute(Model model) {
		model.addAttribute("result",dao.resultTicket());
	}
}















