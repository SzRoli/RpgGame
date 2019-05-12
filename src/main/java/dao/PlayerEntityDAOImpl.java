package dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * Player Entity methods.
 */
public class PlayerEntityDAOImpl {
    /**
     * Create a PlayerEntityDAOimpl.
     */
    private static final PlayerEntityDAOImpl playerEntityDAOimpl = new PlayerEntityDAOImpl();

    /**
     * Method to get back the Player Entity.
     * @return a playerEntityDAOimpl
     */
    public static PlayerEntityDAOImpl getPlayerEntityDAOImpl(){
        return playerEntityDAOimpl;
    }
    /**
     * Constructor of the Player Entity.
     */
    private PlayerEntityDAOImpl(){}

    /**
     * Method to delete a entity.
     * @param entity to delete
     */
    public void delete(PlayerEntity entity) {
        if(entity == null){
            throw new IllegalArgumentException("Entity is null!");
        }

        PlayerEntity delEntity = DBManager.entityManager.find(PlayerEntity.class, entity.getId());

        DBManager.entityManager.getTransaction().begin();
        DBManager.entityManager.remove(delEntity);
        DBManager.entityManager.getTransaction().commit();
    }

    /**
     * Method to save a entity.
     * @param entity to save a entity
     * @return a player entity
     */
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


    /**
     * Method to get back a entity.
     * @param name of a player
     * @return a entity if it find in the database or null
     */
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





}
