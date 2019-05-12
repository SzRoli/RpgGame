package dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

/**
 * DBManager class is handling the JPA databse-connection.
 */
public class DBManager {
    /**
     * Logger instance for logging.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DBManager.class.getName());

    /**
     * One instance of DBManager class.
     */
    private static final DBManager DP_INSTANCE = new DBManager();

    /**
     * EntityManager instance.
     */
    public static EntityManager entityManager;

    /**
     * Private constructor..
     */
    private DBManager(){}

    /**
     * Say if the EntityManager is connected to the database.
     *
     * @return true, if it is.
     */
    public boolean connected() {

        return entityManager != null && entityManager.isOpen();
    }
    /**
     * Getter for DP_INSTANCE variable.
     *
     * @return a DBManager instance.
     *
     */
    public static DBManager getDpInstance(){
        return DP_INSTANCE;
    }

    /**
     * Create the database-connection with JPA.
     *
     * @throws Exception in case JPA fault.
     */
    public void connectDB() throws Exception{
        //etity menegereket tudok létrehozni
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tableb");
        entityManager = entityManagerFactory.createEntityManager();


    }

    /**
     * Close the databse-connection with JPA.
     *
     */
    public void disconnectDB(){

        entityManager.close();
        entityManager = null;


    }
}
