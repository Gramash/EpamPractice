package ua.nure.garmash.Practice8;

import ua.nure.garmash.Practice8.ExceptionHandlers.DBException;
import ua.nure.garmash.Practice8.entity.Group;
import ua.nure.garmash.Practice8.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static String url = "jdbc:mysql://localhost/mysql" +
            "?user=root&password=gibsonlp&useSSL=false";

    private static final String ADD_USER_RECORD = "INSERT INTO users VALUES (DEFAULT, ?)";
    private static final String FIND_ALL_USERS = "select * from users order by id";
    private static final String FIND_ALL_GROUPS = "select * from groups";
    private static final String ADD_GROUP_RECORD = "INSERT INTO groups VALUES (DEFAULT, ?)";
    private static final String GET_USER = "SELECT * FROM users WHERE login=?";
    private static final String GET_GROUP = "SELECT * FROM groups WHERE name = ?";
    private static final String CREATE_USERS_GROUPS = "INSERT INTO users_groups VALUES (?,?)";
    private static final String GET_GROUPS_FOR_USER = "select groups.id, groups.name from users_groups " +
            "INNER JOIN groups ON groups.id=users_groups.group_id " +
            "INNER JOIN users ON users.id=users_groups.user_id " +
            "WHERE user_id=?";
    private static final String DELETE_GROUP_BY_NAME = "DELETE FROM groups WHERE name =?";
    private static final String UPDATE_GROUP_BY_NAME = "UPDATE groups SET name = ? WHERE id = ?";
    private static DBManager instance; // == null

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
    }

    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(url);
        return con;
    }


    public void insertUser(User user) throws DBException {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(ADD_USER_RECORD, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            pstmt.setString(k++, user.getLogin());
            pstmt.execute();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("Cannot insert user" + user.getLogin(), e);
        } finally {
            close(pstmt);
            close(rs);
            close(con);
        }
    }

    public List<User> findAllUsers() throws DBException {
        List<User> users = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(FIND_ALL_USERS);
            while (rs.next()) {
                User user = extractUser(rs);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("can't find all users", e);
        }
        return users;
    }

    private User extractUser(ResultSet rs) {
        try {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                throw new DBException("cant extract user" + rs, e);
            } catch (DBException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }

    public void insertGroup(Group group) throws DBException {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(ADD_GROUP_RECORD, Statement.RETURN_GENERATED_KEYS);
            int k = 1;
            pstmt.setString(k++, group.getName());
            pstmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("cannot insert group", e);
        } finally {
            close(pstmt);
            close(con);
        }

    }

    public List<Group> findAllGroups() {
        List<Group> groups = new ArrayList<>();
        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(FIND_ALL_GROUPS);
            while (rs.next()) {
                Group group = extractGroup(rs);
                groups.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("cannot find all grous ", e);
        }
        return groups;
    }

    private Group extractGroup(ResultSet rs) {
        Group group = new Group();
        try {
            group.setId(rs.getInt("id"));
            group.setName(rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("cant extract Group " + rs, e);
        }
        return group;
    }

    public User getUser(String login) {
        try (Connection con = getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(GET_USER);
            int k = 1;
            pstmt.setString(k++, login);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("cannot get user " + login, e);
        }
        return null;
    }

    public Group getGroup(String name) {
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try (Connection con = getConnection()) {
            pstmt = con.prepareStatement(GET_GROUP);
            int k = 1;
            pstmt.setString(k, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractGroup(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("can't get for user " + name, e);
        }

        return null;
    }

    private static void close(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception ex) {
                throw new IllegalStateException("Cannot close " + ac);
            }
        }
    }

    public void setGroupsForUsers(User user, Group... groups) {
        PreparedStatement prst = null;
        try (Connection con = DriverManager.getConnection(url)) {
            prst = con.prepareStatement(CREATE_USERS_GROUPS);
            con.setAutoCommit(false);
            for (int i = 0; i < groups.length; i++) {
                int k = 1;
                prst.setInt(k++, user.getId());
                prst.setInt(k, groups[i].getId());
                prst.execute();
            }
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("cant set groups for user " + user.getLogin(), e);
        }
    }

    public List<Group> getUserGroups(User user) {
        List<Group> groups = new ArrayList<>();
        PreparedStatement getGroupsForUser;
        ResultSet rs;
        try (Connection con = getConnection()) {
            getGroupsForUser = con.prepareStatement(GET_GROUPS_FOR_USER);
            int k = 1;
            getGroupsForUser.setInt(k, user.getId());
            rs = getGroupsForUser.executeQuery();
            while (rs.next()) {
                Group group = extractGroup(rs);
                groups.add(group);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("failed to get all groups for user " + user, e);
        }
        return groups;
    }

    public void deleteGroup(Group group) {
        PreparedStatement prstm;
        try (Connection con = getConnection()) {
            prstm = con.prepareStatement(DELETE_GROUP_BY_NAME);
            prstm.setString(1, group.getName());
            prstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("can't delete group " + group.getName(), e);
        }
    }

    public void updateGroup(Group group) {
        PreparedStatement prstm;
        try (Connection con = getConnection()) {
            prstm = con.prepareStatement(UPDATE_GROUP_BY_NAME);
            int k = 1;
            prstm.setString(k++, group.getName());
            prstm.setInt(k, group.getId());
            prstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException("can't update group " + group.getName(), e);
        }
    }
}