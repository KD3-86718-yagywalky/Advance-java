package com.sunbram.tester;

import org.hibernate.*;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Teams;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TeamRegistration {
	
	public static void main(String[] args) {
		
		try(SessionFactory sf = getSessionFactory()) {
			
			Scanner sc = new Scanner(System.in);
			
			TeamDao teamDao = new TeamDaoImpl();
			
			System.out.print("Enter team name :- ");
			String name = sc.next();
			System.out.print("Enter team abbreviation :- ");
			String abbreviation = sc.next();
			System.out.print("Enter team owner :- ");
			String owner = sc.next();
			System.out.print("Enter team  Maximum player name :- ");
			Integer maxPlayerAge = sc.nextInt();
			System.out.print("Enter team Batting Average :- ");
			Double avg = sc.nextDouble();
			System.out.print("Enter team Wicket Taken :- ");
			Integer wickets = sc.nextInt();
			
			Teams team = new Teams(name, abbreviation, owner, maxPlayerAge, avg, wickets);
			
			System.out.println(teamDao.signUpTeam(team));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
