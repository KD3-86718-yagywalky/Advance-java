package com.sunbeam.dao;

import com.sunbeam.entities.Teams;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;


public class TeamDaoImpl implements TeamDao {
	
	String mesg="Team registration failed!!!!!";

	@Override
	public String signUpTeam(Teams team) {
		
		Session sf = getSessionFactory().getCurrentSession();
		
		Transaction tx = sf.beginTransaction();
		
		try {
			
			Serializable teamId = sf.save(team);
			
			tx.commit();
			mesg = "Team signed up ! , ID "+teamId;
		}catch (RuntimeException e) {
			
			if(tx != null) {
				tx.rollback();
			}
			throw e;
		}
		
		
		
		return mesg;
	}

	@Override
	public List<Teams> getAllTeams() {
		List<Teams> list = null;
		String jpql = "SELECT n FROM Teams n";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
				list = session.createQuery(jpql, Teams.class).getResultList();
				tx.commit();
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			
			throw e;
	
	}
		return list;

}

	@Override
	public List<Teams> getAllTeamsMaxAvgAge(Integer maxPlayerAge, Double battingAvg) {
		List<Teams> list = null;
		
		String jpql = "SELECT t FROM Teams t WHERE t.maxPlayerAge<=:max and t.battingAvg>=:avg";
		
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			list = session.createQuery(jpql, Teams.class)
					.setParameter("max", maxPlayerAge).
					setParameter("avg", battingAvg).getResultList();
			
			tx.commit();
		}catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return list;
	}

	@Override
	public List<Teams> getOwnerAndAbbreviation(Integer maxPlayerAge, Double battingAvg) {
		List<Teams> list = null;
		String jpql = "SELECT new com.sunbeam.entities.Teams(owner,abbreviation) FROM Teams t WHERE t.maxPlayerAge<=:max and t.battingAvg>=:avg";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			list = session.createQuery(jpql, Teams.class)
					.setParameter("max", maxPlayerAge).
					setParameter("avg", battingAvg).getResultList();
			tx.commit();
		}catch (Exception e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public Teams updateMaxAge(Integer age, String name) {
		Teams team = null;
		String jpql = "SELECT t FROM Teams t WHERE t.name=:na";
		
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			team = session.createQuery(jpql, Teams.class).setParameter("na", name).getSingleResult();
			
			team.setMaxPlayerAge(age);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return team;
	}

	@Override
	public String deleteTeam(Long id) {
		String msg = "Deleted failed";
		Teams team = null;
	
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			team = session.get(Teams.class, id);
			
			if(team != null) {
				session.delete(team);
				msg = "Deleted Successfully !!!";
			}
			tx.commit();
			
		}catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
}
