package com.sunbeam.dao;

import com.sunbeam.entities.Teams;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;

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

}
