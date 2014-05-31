package ru.tusur.view;

import ru.tusur.domain.Mission;

public class MissionPresenter {

    private Mission mission;

    private String dispatchDate;

    private String returnDate;

    public MissionPresenter(Mission mission) {
        this.mission = mission;
    }

    public MissionPresenter(){
        mission = new Mission();
    }

    public Mission getMission() {
        return mission;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
