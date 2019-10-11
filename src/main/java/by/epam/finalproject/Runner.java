package by.epam.finalproject;

import by.epam.finalproject.dao.FacultyDao;
import by.epam.finalproject.dao.UserDao;
import by.epam.finalproject.entity.Application;
import by.epam.finalproject.entity.Faculty;
import by.epam.finalproject.entity.ROLE;
import by.epam.finalproject.entity.User;
import by.epam.finalproject.exception.DaoException;
import by.epam.finalproject.filter.UserRoleFilter;
import by.epam.finalproject.service.ApplicationService;
import by.epam.finalproject.service.MarkService;
import by.epam.finalproject.utils.comparator.SumComparator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/university?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        User user = null;
        try {
            user = userDao.selectUserByLoginAndPassword("Ringo", "root");
        } catch (DaoException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        try {
            boolean isUnique = userDao.checkLoginForUnique("Ringo");
            System.out.println(isUnique);
        } catch (DaoException e) {
            e.printStackTrace();
        }
/*        User user2 = userDao.registerUser("egrgeg", "rrgegoot", "grgwgwrwg", "gwgwwrgwg");
        System.out.println(user2);*/


/*        ConnectionCreator creator = new ConnectionCreator();
        LinkedList<Connection> list = creator.createPool();*/
        FacultyDao facultyDAO = new FacultyDao();
        List<Faculty> faculties = null;
        try {
            faculties = facultyDAO.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        faculties.forEach(System.out::println);

        Faculty faculty = null;
        try {
            faculty = facultyDAO.findById("3");
        } catch (DaoException e) {
            e.printStackTrace();
        }
        System.out.println(faculty);

/*        UserDao userDao = new UserDao();
        User user = userDao.selectUserByLoginAndPassword("Admin", "root");
        System.out.println(user);*/

/*        boolean isUpdate = userDao.updateUserCertificate("88", "2");
        System.out.println(isUpdate);


        MarkService markService = new MarkService();
        boolean isUpdate3 = markService.isUpdate("2", "1", "99");
        System.out.println(isUpdate3);*/

        ApplicationService applicationService = new ApplicationService();
        List<Application> applications = null;
        try {
            applications = applicationService.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }

        applications.forEach(System.out::println);

        applications.sort(new SumComparator());
        for (Application a : applications) {
            System.out.println(a);
        }

/*        List<String> list = new ArrayList<>();
        list.add("/show_all_faculties");

        String string = "/University/controller?command=show_all_faculties";
        System.out.println(string.endsWith("show_all_faculties"));

        boolean isTrue = checkPath("/University/controller?command=show_all_faculties",
                list.get(0));
        System.out.println(isTrue);*/


        List<String> userCommands = new ArrayList<>
                (Arrays.asList("login", "logout", "common_register", "common_change_language",
                        "show_all_applications", "show_all_faculties",
                        "go_to_application_page", "create_application", "show_my_applications"));
        List<String> adminCommands = new ArrayList<>
                (Arrays.asList("login", "logout", "common_register", "common_change_language",
                        "show_all_applications", "show_all_faculties",
                        "show_all_users"));

        ROLE userRole = ROLE.USER;

        List<String> accessCommands = new ArrayList<>();
        switch (userRole) {
            case USER: {
                accessCommands = userCommands;
            }
            case ADMIN: {
                accessCommands = userCommands;
            }
        }

        String parameter = "show_all_applications";
        for (int i = 0; i < accessCommands.size(); i++) {
            if (accessCommands.get(i).equals(parameter)) {
                System.out.println(true);
                return;
            }
        }



    }



    private static boolean checkPath(String path, String pagePattern) {
        Pattern pattern = Pattern.compile(pagePattern);
        Matcher matcher = pattern.matcher(path);

        return matcher.matches();
    }
}
