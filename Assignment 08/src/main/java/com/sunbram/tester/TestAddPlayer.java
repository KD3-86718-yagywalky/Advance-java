package com.sunbram.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;
import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Players;
import com.sunbeam.entities.Teams;

public class TestAddPlayer {

	public static void main(String[] args) {
	try(SessionFactory sf = getSessionFactory()) {
			
			Scanner sc = new Scanner(System.in);
			
			PlayerDao playerDao = new PlayerDaoImpl();
			
			System.out.print("Enter First Name :- ");
			String name = sc.next();
			System.out.print("Enter Last name  :- ");
			String lastName = sc.next();
			System.out.print("Enter Dob :- ");
			String dob = sc.next();
			System.out.print("Enter team Batting Average :- ");
			Double avg = sc.nextDouble();
			System.out.print("Enter team Wicket Taken :- ");
			Integer wickets = sc.nextInt();
			System.out.println("Enter team Id ");
			Long teamid = sc.nextLong();
			
			LocalDate date = LocalDate.parse(dob);
			
			Players team = new Players(name, lastName, date, avg, wickets);
			
			System.out.println(playerDao.addPlayer(teamid, team));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}


