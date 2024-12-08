package com.sunbram.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;


public class TestDisplayAll {
	
	public static void main(String[] args) {
		
		try (SessionFactory sf = getSessionFactory()){
		
			TeamDao teamDao = new TeamDaoImpl();
			teamDao.getAllTeams().forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
