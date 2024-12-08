package com.sunbram.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TestOwnerAndAbbreviation {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			Integer maxAge; Double battingAvg;
			TeamDao teamDao = new TeamDaoImpl();
			System.out.print("Enter Max player age here :- ");
			maxAge = sc.nextInt();
			System.out.print("Enter Batting avg here :- ");
			battingAvg=sc.nextDouble();
			teamDao.getOwnerAndAbbreviation(maxAge, battingAvg)
			.forEach(team -> System.out.println(team.getOwner()+"  "+team.getAbbreviation()));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}