package dao;

import javax.persistence.*;

public class DBManager {

    private static final DBManager DP_INSTANCE = new DBManager();

    public static EntityManager entityManager;
    //private hogy ne érje el senki
    private DBManager(){}

    public boolean connected() {

        return entityManager != null && entityManager.isOpen();
    }
    //lekérem az objektumot
    public static DBManager getDpInstance(){
        return DP_INSTANCE;
    }

    public void connectDB() throws Exception{
        //etity menegereket tudok létrehozni
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tableb");
        entityManager = entityManagerFactory.createEntityManager();


    }

    public void disconnectDB(){

        entityManager.close();
        entityManager = null;


    }
}
