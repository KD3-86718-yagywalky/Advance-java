package com.sunbram.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TestDeletePlayer {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			
			PlayerDao playerDao = new PlayerDaoImpl();
			
			System.out.print("Enter player id :- ");
			Long id = sc.nextLong();
			System.out.print("Enter team id :- ");
			Long teamId = sc.nextLong();
			
			System.out.println(playerDao.removePlayer(teamId, id));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
