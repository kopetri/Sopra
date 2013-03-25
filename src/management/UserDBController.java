package management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class UserDBController {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static String query = null;
    private static PreparedStatement pStatement;
    // CONNECTIONSTRING anpassen!!
    static final String CONNECTIONSTRING = "jdbc:mysql://localhost/test?user=monty&password=greatsqldb";


    public UserDBController() {

	super();
	connect();
	resultSet = null;
	try {
	    connection.createStatement();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }


    public List<User> getAllUsers() throws SQLException {

	List<User> userList = null;
	query = "SELECT * FROM User";
	resultSet = statement.executeQuery(query);
	while (resultSet.next()) {
	    // FEHLER: Konstruktor der Klasse User sieht stat Array, ein
	    // Boolean[] und List<String> vor
	    // LÖSUNG: ?? Casten ??
	    User user = new User(resultSet.getString("login"),
		    resultSet.getString("firstName"),
		    resultSet.getString("lastName"),
		    resultSet.getString("mail"), resultSet.getArray("rights"),
		    resultSet.getString("session"),
		    resultSet.getString("faculty"),
		    resultSet.getArray("institute"),
		    resultSet.getString("represantative"),
		    resultSet.getString("supervisor"));
	    userList.add(user);
	}
	close();
	return userList;
    }


    private void connect() {

	try {
	    Class.forName("com.mysql.jdbc.Driver").newInstance();
	    connection = DriverManager.getConnection(CONNECTIONSTRING);
	} catch (InstantiationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }


    public void createUser(User user) throws SQLException {

	query = "INSERT INTO User VALUES(?,?,?,?,?,?,?,?,?,?)";
	pStatement = connection.prepareStatement(query);
	pStatement.setString(1, user.getLogin());
	pStatement.setString(2, user.getFirstName());
	pStatement.setString(3, user.getLastName());
	pStatement.setString(4, user.getMail());
	pStatement.setArray(5, user.getRights());
	pStatement.setString(6, user.getSession());
	pStatement.setString(7, user.getFaculty());
	pStatement.setArray(8, user.getInstitute());
	pStatement.setString(9, user.getRepresentative());
	pStatement.setString(10, user.getSupervisor());

	pStatement.executeUpdate();

    }


    public void changeUser(User oldUser, User newUser) throws SQLException {

	String login = oldUser.getLogin();
	query = "SELECT 1 FROM User WHERE login=?";
	pStatement = connection.prepareStatement(query);
	pStatement.setString(1, login);
	resultSet = pStatement.executeQuery();
	// checks if user exists in database
	if (resultSet.next()) {
	    query = "UPDATE User SET login=?, firstName=?, lastName=?, mail=?, rights=?, session=?, faculty=?, institute=?, representative=?, supervisor=? WHERE login=?";
	    pStatement = connection.prepareStatement(query);
	    pStatement.setString(1, newUser.getLogin());
	    pStatement.setString(2, newUser.getFirstName());
	    pStatement.setString(3, newUser.getLastName());
	    pStatement.setString(4, newUser.getMail());
	    pStatement.setArray(5, newUser.getRights());
	    pStatement.setString(6, newUser.getSession());
	    pStatement.setString(7, newUser.getFaculty());
	    pStatement.setArray(8, newUser.getInstitute());
	    pStatement.setString(9, newUser.getRepresentative());
	    pStatement.setString(10, newUser.getSupervisor());
	    pStatement.setString(11, login);

	    pStatement.executeUpdate();
	} else {
	    System.out.println("That user was not found in database!");
	}
    }


    private void close() {

	try {
	    statement.close();
	    resultSet.close();
	    connection.close();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
