package com.sunbeam.dao;

import com.sunbeam.entities.Players;
import com.sunbeam.entities.Teams;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.List;

import org.hibernate.*;
import org.hibernate.Transaction;

public class PlayerDaoImpl implements PlayerDao{

	@Override
	public String addPlayer(Long teamid, Players player) {
		String msg ="Not added !!!";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
				Teams team = session.get(Teams.class, teamid);
				
				if(team != null) {
					
					team.addPlayerInTeam(player);
					session.persist(player);
				}
				
			tx.commit();
			msg = "Added Successfully of player "+player.getId()+ "In team "+team.getName();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
				
		return msg;
	}

	@Override
	public String removePlayer(Long teamId, Long id) {
		
		String msg = "Not deleted yet ";
		
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			
			Players player = session.get(Players.class, id);
			Teams team = session.get(Teams.class, teamId);
			if(player != null && team != null) {
			
			team.deletePlayerFromTeam(player);
			}
			tx.commit();
			msg = "Deleted Successfully player "+player.getFirstName()+" from  "+team.getId();
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

	@Override
	public List<Players> displayAllPlayers(Long id) {
		
		List<Players> players = null;
		
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Teams team = session.get(Teams.class, id);
			players=team.getPlayer();
		
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return players;
	}

}
