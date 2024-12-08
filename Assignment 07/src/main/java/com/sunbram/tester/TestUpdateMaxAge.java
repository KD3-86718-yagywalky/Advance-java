package com.sunbram.tester;

import org.hibernate.*;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TestUpdateMaxAge {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter Team name :- ");
			String name = sc.next();
			System.out.println("Enter max age for team :- ");
			Integer age = sc.nextInt();
			System.out.println(teamDao.updateMaxAge(age, name)); 
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
