package by.epam.finalproject;

import by.epam.finalproject.dao.FacultyDao;
import by.epam.finalproject.dao.UserDao;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.entity.User;

import java.util.Map;

public class Runner {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/university?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

/*        ConnectionCreator creator = new ConnectionCreator();
        LinkedList<Connection> list = creator.createPool();*/
        FacultyDao facultyDAO = new FacultyDao();
        Map<Integer, Faculty> faculties = facultyDAO.findAll();
        faculties.values().forEach(System.out::println);

        UserDao userDao = new UserDao();
        User user = userDao.selectUserByLoginAndPassword("Admin", "root");
        System.out.println(user);

        /*        List<Faculty> faculties = new ArrayList<>();
        try {
            Statement statement = list.getFirst().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from faculty");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int places = resultSet.getInt("places");
                int passingPoints = resultSet.getInt("passing_points");

                faculties.add(new Faculty(id, name, places, passingPoints));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (faculties.size() > 0) {
            faculties.forEach(System.out::println);
        } else {
            System.out.println("Not found");
        }*/

/*        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

}
