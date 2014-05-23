package ru.tusur.view;

import ru.tusur.domain.Mission;

public class MissionPresenter {

    private Mission mission;

    public MissionPresenter(Mission mission) {
        this.mission = mission;
    }

    public MissionPresenter(){
        mission = new Mission();
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
