package com.sunbram.tester;

import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Teams;

public class TestTeamDelete {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter user id to un subscribe :- ");
			Long id = sc.nextLong();
			
			System.out.println(teamDao.deleteTeam(id));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
