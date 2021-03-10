package com.epam.rd.java.basic.practice8.db;

import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class DBManager {
    private static DBManager dbManager;
    private final Connection connection;
    private PreparedStatement ps = null;
    private Statement statement = null;
    private ResultSet rs = null;

    private static final String FIND_ALL_USERS = "SELECT * FROM users ORDER BY id";
    private static final String FIND_ALL_TEAMS = "SELECT * FROM teams ORDER BY id";
    private static final String INSERT_USER = "INSERT INTO users VALUES (DEFAULT ,?)";
    private static final String INSERT_TEAM = "INSERT INTO teams VALUES (DEFAULT ,?)";
    private static final String FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
    private static final String FIND_TEAM_BY_LOGIN = "SELECT * FROM teams WHERE name=?";
    private static final String FIND_TEAMS_BY_USER_ID = "SELECT t.id, t.name FROM users_teams ut\n"
            + "JOIN users u ON ut.user_id = u.id\n" + "JOIN teams t ON ut.team_id = t.id\n" + "WHERE u.id = ?";

    private static final String INSERT_USER_TO_TEAM = "INSERT INTO users_teams VALUES (?, ?)";
    private static final String DELETE_TEAM = "DELETE FROM teams WHERE name=?";
    private static final String UPDATE_TEAM = "UPDATE teams SET name=? WHERE id=?";

    public static Connection getConnection() {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream("app.properties")) {
            props.load(in);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        try {
            return DriverManager.getConnection(props.getProperty("connection.url"), props.getProperty("username"), props.getProperty("password"));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private DBManager() {
        connection = getConnection();
    }

    public static synchronized DBManager getInstance() {
        if (dbManager == null) {
            dbManager = new DBManager();
        }
        return dbManager;
    }

    public boolean insertUser(User user) {
        try {
            ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            if (ps.executeUpdate() != 1) {
                return false;
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                user.setId(id);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            close(rs);
            close(ps);
        }
        return true;
    }

    public boolean insertTeam(Team team) {
        try {
            ps = connection.prepareStatement(INSERT_TEAM, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, team.getName());
            if (ps.executeUpdate() != 1) {
                return false;
            }
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                team.setId(id);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            close(rs);
            close(ps);
        }
        return true;
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(FIND_ALL_USERS);
            while (rs.next()) {
                User user = new User();
                users.add(user);
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
            }
        } catch (Exception e) {
            return Collections.emptyList();
        } finally {
            close(rs);
            close(statement);
        }
        return users;
    }

    public List<Team> findAllTeams() {
        List<Team> teams = new ArrayList<>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(FIND_ALL_TEAMS);
            while (rs.next()) {
                Team team = new Team();
                teams.add(team);
                team.setId(rs.getInt(1));
                team.setName(rs.getString(2));
            }
        } catch (Exception e) {
            return Collections.emptyList();
        } finally {
            close(rs);
            close(statement);
        }
        return teams;
    }

    public User getUser(String login) {
        User user = null;
        try {
            ps = connection.prepareStatement(FIND_USER_BY_LOGIN);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }
        return user;
    }

    public Team getTeam(String name) {
        Team team = null;
        try {
            ps = connection.prepareStatement(FIND_TEAM_BY_LOGIN);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                team = new Team();
                team.setId(rs.getInt("id"));
                team.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            close(rs);
            close(ps);
        }
        return team;
    }

    public List<Team> getUserTeams(User user) {
        List<Team> teams = new ArrayList<>();
        try {
            ps = connection.prepareStatement(FIND_TEAMS_BY_USER_ID);
            ps.setInt(1, user.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                Team team = new Team();
                teams.add(team);
                team.setId(rs.getInt(1));
                team.setName(rs.getString(2));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return Collections.emptyList();
        } finally {
            close(rs);
            close(ps);
        }
        return teams;
    }

    public boolean setTeamsForUser(User user, Team... teams) {
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(INSERT_USER_TO_TEAM);
            for (Team t : teams) {
                ps.setInt(1, user.getId());
                ps.setInt(2, t.getId());
                ps.addBatch();
            }
            int[] usersTeams = ps.executeBatch();
            for (int i : usersTeams) {
                if (i != 1) {
                    return false;
                }
            }
            connection.commit();
            return true;
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } finally {
            close(rs);
            close(ps);
            setAutoCommit();
        }
        return false;
    }

    public boolean deleteTeam(Team team) {
        try {
            ps = connection.prepareStatement(DELETE_TEAM);
            ps.setString(1, team.getName());
            if (ps.executeUpdate() != 1) {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            close(ps);
        }
        return true;
    }

    public boolean updateTeam(Team team) {
        try {
            ps = connection.prepareStatement(UPDATE_TEAM);
            ps.setString(1, team.getName());
            ps.setInt(2, team.getId());
            if (ps.executeUpdate() != 1) {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            close(ps);
        }
        return true;
    }

    private void setAutoCommit() {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void close(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
