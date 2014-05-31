package ru.tusur.view;


import ru.tusur.domain.Statement;

public class StatementPresenter {

    private Statement statement;

    public StatementPresenter(Statement statement) {
        this.statement = statement;
    }

    public StatementPresenter(){
        statement = new Statement();
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
