package ru.tusur.view;


import ru.tusur.domain.Statement;

public class StatementPresenter {

    private String dpDate;

    private String startDate;

    private String endDate;

    private Statement statement;

    public StatementPresenter(Statement statement) {
        this.statement = statement;
    }

    public StatementPresenter(){
        statement = new Statement();
    }

    public String getDpDate() {
        return dpDate;
    }

    public void setDpDate(String dpDate) {
        this.dpDate = dpDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
