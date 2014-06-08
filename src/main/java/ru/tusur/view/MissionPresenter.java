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
    public String getDispatchDate() {
        return dispatchDate;
    }
    public String getDispatchDate(String s) {
        return dispatchDate;
    }
    public String getReturnDate() {
        return returnDate;
    }
    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public String getReturnDate(String s) {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Mission getMission() {
        return mission;
    }



    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
