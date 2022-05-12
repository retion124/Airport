package dao.impl;

import dao.AirlineDAO;
import dao.IDAOFactory;

public class DAOFactory implements IDAOFactory {

    private static IDAOFactory factory;

    private DAOFactory() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loading success!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public static synchronized IDAOFactory getInstance() {
            if (factory == null) {
                factory = new DAOFactory();
            }
            return factory;
        }

    @Override
    public AirlineDAO getAirlineDAO() {
        return null;
    }
}
