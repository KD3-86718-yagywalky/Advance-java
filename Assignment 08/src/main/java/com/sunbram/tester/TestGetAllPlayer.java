package com.sunbram.tester;

import org.hibernate.SessionFactory;
import com.sunbeam.entities.*;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;
import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Teams;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.List;
import java.util.Scanner;

public class TestGetAllPlayer {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			
			TeamDao teamDao = new TeamDaoImpl();
			
			System.out.println("Enter Team id :- ");
			Long id = sc.nextLong();
			
			Teams team = teamDao.getAllPlayerByTeam(id);
			
			System.out.println(team);
			
			System.out.println("All players :- ");
			List<Players> p = null;
			p = team.getPlayer();
			for(Players pp : p) {
				System.out.println(pp);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
