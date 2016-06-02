package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.Dao.BoardDao;
import com.board.beans.BoardDto;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myFunction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		myFunction(request, response);
	}
	
	protected void myFunction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String actionMode = request.getParameter("actionMode");
		
		if(actionMode.equals("INS")) {
			BoardDto dto = new BoardDto();
			dto.setTitle(request.getParameter("title"));
			dto.setImg_name(request.getParameter("img_name"));
			dto.setImg_oname(request.getParameter("img_oname"));
			dto.setImg_path(request.getParameter("img_path"));
			dto.setContent(request.getParameter("content"));
			
			BoardDao dao = new BoardDao();
			dao.bInsert(dto);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Controller?actionMode=LIST");
			rd.forward(request, response);
		}
	}
}
