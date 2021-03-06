package com.epam.rd.java.basic.practice8;

import java.util.List;

import com.epam.rd.java.basic.practice8.db.DBManager;
import com.epam.rd.java.basic.practice8.db.entity.Team;
import com.epam.rd.java.basic.practice8.db.entity.User;

public class Demo {
    private static final String SEPARATOR = "===========================";

    private static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {

        DBManager dbManager = DBManager.getInstance();

        dbManager.insertUser(User.createUser("petrov"));
        dbManager.insertUser(User.createUser("obama"));
        printList(dbManager.findAllUsers());

        System.out.println(SEPARATOR);

        dbManager.insertTeam(Team.createTeam("teamB"));
        dbManager.insertTeam(Team.createTeam("teamC"));
        printList(dbManager.findAllTeams());

        System.out.println(SEPARATOR);

        User userPetrov = dbManager.getUser("petrov");
        User userIvanov = dbManager.getUser("ivanov");
        User userObama = dbManager.getUser("obama");

        Team teamA = dbManager.getTeam("teamA");
        Team teamB = dbManager.getTeam("teamB");
        Team teamC = dbManager.getTeam("teamC");

        dbManager.setTeamsForUser(userIvanov, teamA);
        dbManager.setTeamsForUser(userPetrov, teamA, teamB);
        dbManager.setTeamsForUser(userObama, teamA, teamB, teamC);

        for (User user : dbManager.findAllUsers()) {
            printList(dbManager.getUserTeams(user));
        }

        System.out.println(SEPARATOR);

        dbManager.deleteTeam(teamA);

        teamC.setName("teamX");
        dbManager.updateTeam(teamC);

        printList(dbManager.findAllTeams());

    }
}
