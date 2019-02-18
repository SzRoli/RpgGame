package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;


public class PlayerEntityDAOImpl {

    private static final PlayerEntityDAOImpl playerEntityDAOimpl = new PlayerEntityDAOImpl();

    public static PlayerEntityDAOImpl getPlayerEntityDAOImpl(){
        return playerEntityDAOimpl;
    }

    private PlayerEntityDAOImpl(){}


    /*public Integer findPlayersCredit(String name) {
        try {
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayersCredit");
            query.setParameter("name", name);


            int entity = (Integer) query.getSingleResult();


            return entity;

        //olyan név ami nincs az adatbázisban
        } catch (NoResultException e) {

            return null;

        } catch (NullPointerException e) {

            return null;
        }
    }*/


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


    public PlayerEntity findPlayerbyName(String name) {
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

    public Integer getPlayerDoge(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerDoge");
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

    public Integer getPlayerDef(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerDef");
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

    public Integer getPlayerHp(String name){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerHp");
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

    /*public Integer getPlayerDmg(){
        try{
            Query query = DBManager.entityManager.createNamedQuery("PlayerEntity.findPlayerbyDmg");

            int entity = (Integer) query.getSingleResult();

            return entity;
        }catch (NoResultException e) {

            return null;
        }
    }*/

}
