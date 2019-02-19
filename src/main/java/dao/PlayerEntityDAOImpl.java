package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;


public class PlayerEntityDAOImpl {

    private static final PlayerEntityDAOImpl playerEntityDAOimpl = new PlayerEntityDAOImpl();

    public static PlayerEntityDAOImpl getPlayerEntityDAOImpl(){
        return playerEntityDAOimpl;
    }

    private PlayerEntityDAOImpl(){}

    public void delete(PlayerEntity entity) {
        if(entity == null){
            throw new IllegalArgumentException("Entity is null!");
        }

        PlayerEntity delEntity = DBManager.entityManager.find(PlayerEntity.class, entity.getId());

        DBManager.entityManager.getTransaction().begin();
        DBManager.entityManager.remove(delEntity);
        DBManager.entityManager.getTransaction().commit();
    }


    public PlayerEntity save(PlayerEntity entity) {
        if(entity == null){
            throw new IllegalArgumentException("Entity is null!");
        }

        DBManager.entityManager.getTransaction().begin();

        if(entity.getId() == null){
            DBManager.entityManager.persist(entity);
        } else { DBManager.entityManager.merge(entity);}

        DBManager.entityManager.getTransaction().commit();

        return entity;
    }


    public PlayerEntity findPlayerByName(String name) {
        try {
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerByName");
            query.setParameter("name", name);

            PlayerEntity entity = (PlayerEntity) query.getSingleResult();

            return entity;


        } catch (NoResultException e) {

            return null;
        }
    }

    public String getPlayerName(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerName");
            query.setParameter("name", name);
            String entity = (String) query.getSingleResult();

            return entity;
        }catch (NoResultException e) {
            System.out.println("Nem található ilyen Entity");
            return null;
        }catch (NullPointerException e) {

            System.out.println("Ilyen Entity nincs az adatbázisban");
            return null;
        }
    }

    public Integer getPlayerMoney(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerMoney");
            query.setParameter("name", name);
            int entity = (Integer) query.getSingleResult();

            return entity;
        }catch (NoResultException e) {
            System.out.println("Nem található ilyen Entity");
            return null;
        }catch (NullPointerException e) {

            System.out.println("Ilyen Entity nincs az adatbázisban");
            return null;
        }
    }
    public Integer getPlayerDmg(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerDmg");
            query.setParameter("name", name);
            int entity = (Integer) query.getSingleResult();

            return entity;
        }catch (NoResultException e) {
            System.out.println("Nem található ilyen Entity");
            return null;
        }catch (NullPointerException e) {

            System.out.println("Ilyen Entity nincs az adatbázisban");
            return null;
        }
    }
    public Integer getPlayerLvl(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerLvl");
            query.setParameter("name", name);
            int entity = (Integer) query.getSingleResult();

            return entity;
        }catch (NoResultException e) {
            System.out.println("Nem található ilyen Entity");
            return null;
        }catch (NullPointerException e) {

            System.out.println("Ilyen Entity nincs az adatbázisban");
            return null;
        }
    }

    public Integer getPlayerCriticalDmg(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerCriticalDmg");
            query.setParameter("name", name);
            int entity = (Integer) query.getSingleResult();

            return entity;
        }catch (NoResultException e) {
            System.out.println("Nem található ilyen Entity");
            return null;
        }catch (NullPointerException e) {

            System.out.println("Ilyen Entity nincs az adatbázisban");
            return null;
        }
    }

    public Integer getPlayerCritical(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerCritical");
            query.setParameter("name", name);
            int entity = (Integer) query.getSingleResult();

            return entity;
        }catch (NoResultException e) {
            System.out.println("Nem található ilyen Entity");
            return null;
        }catch (NullPointerException e) {

            System.out.println("Ilyen Entity nincs az adatbázisban");
            return null;
        }
    }

    public Integer getPlayerResetCount(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerResetCount");
            query.setParameter("name", name);
            int entity = (Integer) query.getSingleResult();

            return entity;
        }catch (NoResultException e) {
            System.out.println("Nem található ilyen Entity");
            return null;
        }catch (NullPointerException e) {

            System.out.println("Ilyen Entity nincs az adatbázisban");
            return null;
        }
    }



}
