package com.application.db;

import com.application.entities.*;

import java.sql.*;
import java.util.Vector;
import java.util.Date;

public final class DatabaseController {
    //Transactions functions
    public static Vector<Transaction> getAllTransactions() {
        Vector<Transaction> transactions = new Vector<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            // Execute a query to get all transaction values
            String query = "SELECT * FROM agence.transactions ;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Extract data from result set and add to Vector
                while (resultSet.next()) {
                    int transaction_id = resultSet.getInt("transaction_id");
                    TransactionType transactionType = TransactionType.valueOf(resultSet.getString("transactionType"));
                    int agent_id = resultSet.getInt("agent_id");
                    int Client_id = resultSet.getInt("Client_id");
                    String Client_Fn = resultSet.getString("Client_Fn");
                    String Client_Ln = resultSet.getString("Client_Ln");
                    int Client_PN = resultSet.getInt("Client_PN");
                    String Owner_info = resultSet.getString("Owner_info");
                    int Owner_PN = resultSet.getInt("Owner_PN");
                    int RealEstate_id = resultSet.getInt("RE_id");
                    Date date = resultSet.getDate("trsc_date");

                    Transaction transaction = new Transaction(transaction_id, transactionType, agent_id, Client_id, Client_Fn, Client_Ln, Client_PN, Owner_info, Owner_PN, RealEstate_id, date);
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public static Vector<Transaction> getTransactionsById(int id) {
        Vector<Transaction> transactions = new Vector<>();
        String querySQL = "SELECT * FROM agence.transactions WHERE trsc_id = ? ;";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(querySQL)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    TransactionType transactionType = TransactionType.valueOf(resultSet.getString("TransactionType"));
                    int agentId = resultSet.getInt("Agent_id");
                    int clientId = resultSet.getInt("Client_id");
                    String clientFN = resultSet.getString("Client_Fn");
                    String clientLN = resultSet.getString("Client_Ln");
                    int clientPN = resultSet.getInt("Client_PN");
                    String ownerInfo = resultSet.getString("Owner_info");
                    int ownerPN = resultSet.getInt("Owner_PN");
                    int reId = resultSet.getInt("RealEstate_id");
                    Date date = resultSet.getDate("trsc_date");

                    // Create Transaction object and add to vector
                    Transaction transaction = new Transaction(id, transactionType, agentId, clientId, clientFN, clientLN, clientPN, ownerInfo, ownerPN, reId, date);
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return transactions;
    }
    public void addTransaction(int trscId, String transactionType, int agentId, int clientId,
                               String clientFN, String clientLN, String clientPN,
                               String ownerInfo, String ownerPN, int reId, Date date) {
        String insertSQL = "INSERT INTO agence.transactions VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set the parameter values in the query
            preparedStatement.setInt(1, trscId);
            preparedStatement.setString(2, transactionType);
            preparedStatement.setInt(3, agentId);
            preparedStatement.setInt(4, clientId);
            preparedStatement.setString(5, clientFN);
            preparedStatement.setString(6, clientLN);
            preparedStatement.setString(7, clientPN);
            preparedStatement.setString(8, ownerInfo);
            preparedStatement.setString(9, ownerPN);
            preparedStatement.setInt(10, reId);
            preparedStatement.setDate(11, new java.sql.Date(date.getTime()));

            // Execute the insert
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if the row was successfully inserted

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void removeTransaction(int id) {
        String deleteSQL = "DELETE FROM agence.transactions WHERE trsc_id = ?;";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            // Set the parameter value in the query
            preparedStatement.setInt(1, id);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    //Agents Functions
    public static Vector<Agent> getAllAgents() {
        Vector<Agent> agents = new Vector<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM agence.agents;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int agentId = resultSet.getInt("Agent_id");
                    String firstName = resultSet.getString("First_Name");
                    String lastName = resultSet.getString("Last_Name");
                    int phoneNumber = resultSet.getInt("Phone_num");

                    Agent agent = new Agent(agentId, firstName, lastName, phoneNumber);
                    agents.add(agent);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return agents;
    }
    public static Agent getAgentDetails(int ID) {
        Agent agent = null;
        String selectSQL = "SELECT * FROM agence.agents WHERE Agent_id = ?;";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            // Set the ID parameter in the query
            preparedStatement.setInt(1, ID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString("First_Name");
                    String lastName = resultSet.getString("Last_Name");
                    int phoneNum = resultSet.getInt("Phone_num");

                    // Create Agent object
                    agent = new Agent(ID, firstName, lastName, phoneNum);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return agent;
    }
    //Real Estate Functions
    public static Vector<RealEstate> getAllRealEstate() {
        Vector<RealEstate> realEstateList = new Vector<>();

        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM agence.agenceimmob;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int realEstateId = resultSet.getInt("RE_id");
                    TransactionType transactionType = TransactionType.valueOf(resultSet.getString("Transaction_Type"));
                    RealEstateType realEstateType = RealEstateType.valueOf(resultSet.getString("RealEst_Type"));
                    int surface = resultSet.getInt("Surface");
                    double price = resultSet.getDouble("Price");
                    String address = resultSet.getString("Address");
                    int floors = resultSet.getInt("Floors");
                    boolean hasContract = resultSet.getBoolean("Contract");
                    boolean pool = resultSet.getBoolean("Pool");
                    int agentId = resultSet.getInt("Agent_id");
                    int numberOfRooms = resultSet.getInt("Rooms");
                    int trscId = resultSet.getInt("Transac_id");
                    String description = resultSet.getString("Description");

                    RealEstate realEstate = new RealEstate(realEstateId, transactionType, realEstateType, surface, price, address, floors, hasContract, pool, agentId, numberOfRooms, trscId, description);
                    realEstateList.add(realEstate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return realEstateList;
    }
    public void addRealEstate(int id, RealEstateType realEstateType, double price, int surface, String address,
                              TransactionType transactionType, String description, int agentId) {
        String insertSQL = "INSERT INTO agence.agenceimmob (RE_id, RealEst_Type, Price, Surface, Address, Transaction_Type, Description, Agent_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set the parameter values in the query
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, realEstateType.toString());
            preparedStatement.setDouble(3, price);
            preparedStatement.setInt(4, surface);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, transactionType.toString());
            preparedStatement.setString(7, description);
            preparedStatement.setInt(8, agentId);

            // Execute the insert
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void modifyRealEstate(int id, RealEstateType realEstateType, double price, int surface, String address,
                                 TransactionType transactionType, String description, int agentId) {
        String updateSQL = "UPDATE agence.agenceimmob SET RealEst_Type = ?, Price = ?, Surface = ?, Address = ?, " +
                "Transaction_Type = ?, Description = ?, Agent_id = ? WHERE RE_id = ?;";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            // Set the parameter values in the query
            preparedStatement.setString(1, realEstateType.toString());
            preparedStatement.setDouble(2, price);
            preparedStatement.setInt(3, surface);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, transactionType.toString());
            preparedStatement.setString(6, description);
            preparedStatement.setInt(7, agentId);
            preparedStatement.setInt(8, id);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static boolean isAvailable(int id) {
        String querySQL = "SELECT Contract FROM agence.agenceimmob WHERE id = ?;";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(querySQL)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    boolean contract = resultSet.getBoolean("Contract");
                    return !contract; // Return true if contract is false (0), false otherwise
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;  // In case the ID is not found, we assume false
    }
    public static Vector<RealEstate> getDetails(int re_id, int ag_id) {
        Vector<RealEstate> realEstates = new Vector<>();
        String selectSQL = "SELECT * FROM your_table WHERE RE_id = ? OR Agent_id = ?;";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            // Set the parameter values in the query
            preparedStatement.setInt(1, re_id);
            preparedStatement.setInt(2, ag_id);

            // Execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                // Iterate over the result set
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    TransactionType typeOfTransaction = TransactionType.valueOf(resultSet.getString("Transac_type"));
                    String typeOfRealEstate = resultSet.getString("Realest_type");
                    int surface = resultSet.getInt("Surface");
                    double price = resultSet.getDouble("Price");
                    String address = resultSet.getString("Address");
                    int floors = resultSet.getInt("Floors");
                    boolean hasContract = resultSet.getBoolean("Contract");
                    int numRooms = resultSet.getInt("Rooms");
                    int agentId = resultSet.getInt("Agent_id");
                    String description = resultSet.getString("Description");

                    // Create RealEstate object and add to vector
                    RealEstate realEstate = new RealEstate(id, typeOfTransaction, RealEstateType.valueOf(typeOfRealEstate), surface, price, address, floors, hasContract, false, agentId, numRooms, 0, description);
                    realEstates.add(realEstate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return realEstates;
    }
    public static void deleteRealEstateById(int realEstateId) {
        try (Connection connection = DatabaseConnector.getConnection()) {
            String query = "DELETE FROM agence.agenceimmob WHERE RE_id = ?;";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, realEstateId);

                // Execute the delete statement
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions or throw them further as needed
        }
    }

    //Client functions
    public Vector<Transaction> getClientHistory(int ID) {
        Vector<Transaction> transactions = new Vector<>();
        String selectSQL = "SELECT * FROM agence.transactions WHERE Client_id = ?;";
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            // Set the parameter value in the query
            preparedStatement.setInt(1, ID);

            // Execute the query
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                // Iterate over the result set
                while (resultSet.next()) {
                    int trscId = resultSet.getInt("trsc_id");
                    TransactionType transactionType = TransactionType.valueOf(resultSet.getString("Transaction_type"));
                    int agentId = resultSet.getInt("Agent_id");
                    String clientFN = resultSet.getString("Client_FN");
                    String clientLN = resultSet.getString("Client_LN");
                    int clientPN = resultSet.getInt("Client_PN");
                    String ownerInfo = resultSet.getString("Owner_info");
                    int ownerPN = resultSet.getInt("Owner_PN");
                    int reId = resultSet.getInt("RE_id");
                    Date date = resultSet.getDate("trsc_date");

                    // Create a new Transaction object and add it to the vector
                    Transaction transaction = new Transaction(trscId, transactionType, agentId, ID, clientFN, clientLN, clientPN, ownerInfo, ownerPN, reId, date);
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return transactions;
    }
    public boolean hasTransactionHistory(int clientId) {
        String querySQL = "SELECT COUNT(*) FROM agence.transactions WHERE Client_id = ?;";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(querySQL)) {

            preparedStatement.setInt(1, clientId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return false;
    }
    public static void addClient(int clientId, String clientFN, String clientLN, int clientPN, String clientType) {
        String insertSQL = "INSERT INTO agence.clients (Client_id, Client_FN, Client_LN, Client_PN, Client_type) VALUES (?, ?, ?, ?, ?);";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set the parameter values in the query
            preparedStatement.setInt(1, clientId);
            preparedStatement.setString(2, clientFN);
            preparedStatement.setString(3, clientLN);
            preparedStatement.setInt(4, clientPN);
            preparedStatement.setString(5, clientType);

            // Execute the insert
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static void deleteClientById(int clientId) {
        String deleteSQL = "DELETE FROM agence.clients WHERE Client_id = ?;";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            // Set the parameter value in the query
            preparedStatement.setInt(1, clientId);

            // Execute the delete
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    //Preferences functions
    public static Vector<RealEstatePreferences> getAllPreferences() {
        Vector<RealEstatePreferences> preferences = new Vector<>();

        String query = "SELECT * FROM agence.preferences;";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int clientId = resultSet.getInt("Client_id");
                int minSurface = resultSet.getInt("Min_Surface");
                int maxSurface = resultSet.getInt("Max_Surface");
                double minBudget = resultSet.getDouble("Min_Budget");
                double maxBudget = resultSet.getDouble("Max_Budget");
                String address = resultSet.getString("Address");
                RealEstateType realEstateType = RealEstateType.valueOf(resultSet.getString("Realest_type"));

                RealEstatePreferences preference = new RealEstatePreferences(clientId, minSurface, maxSurface, address, realEstateType, minBudget, maxBudget);
                preferences.add(preference);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving preferences from database", e);
        }

        return preferences;
    }
    public static void addPreference(int clientId, int minSurface, int maxSurface, String address,
                                     RealEstateType realEstateType, double minBudget, double maxBudget) {
        String insertSQL = "INSERT INTO agence.preferences (Client_id, Min_Surface, Max_Surface, Address, Realest_type, Min_Budget, Max_Budget) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set the parameter values in the query
            preparedStatement.setInt(1, clientId);
            preparedStatement.setInt(2, minSurface);
            preparedStatement.setInt(3, maxSurface);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, realEstateType.name());
            preparedStatement.setDouble(6, minBudget);
            preparedStatement.setDouble(7, maxBudget);

            // Execute the insert
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding preference to the database", e);
        }
    }
    public static void deletePreferencesByClientId(int clientId) {
        String deleteSQL = "DELETE FROM agence.preferences WHERE Client_id = ?;";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {

            // Set the parameter value in the query
            preparedStatement.setInt(1, clientId);

            // Execute the delete operation
            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting preferences from the database", e);
        }
    }
}


