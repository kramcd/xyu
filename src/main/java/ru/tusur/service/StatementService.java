package ru.tusur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tusur.data.StatementRepository;
import ru.tusur.domain.Statement;

import java.util.List;

@Service("StatementService")
public class StatementService {

    private static final String MAIL_FROM = "noreply@rustv.ru";

    private static final String MAIL_SUBJECT = "Статус вашего заявления изменен !";

    private static final String MAIL_BODY = "%s %s %s, статус по вашему заявлению изменен<br/>"+
            "Посмореть статус вы можете в своем личном кабинете<br/>"+
            "Да прибудет с вами сила (: !";

   @Autowired
    private StatementRepository repository;

    @Autowired
    private Notifier notifier;

    public Statement Save(Statement statement){
        String body = String.format(MAIL_BODY,
                statement.getEmployees().getFamaly(),
                statement.getEmployees().getName(),
                statement.getEmployees().getMiddleName());

        String to = statement.getEmployees().getEmail();
        notifier.sendNotification(MAIL_FROM, to, MAIL_SUBJECT, body);
        return repository.save(statement);
    }

    public List<Statement> GetAll(){
        return repository.findAll();
    }

    public void Delete(Statement statement){
        repository.delete(statement);
    }

    public List<Statement> FindByEmployees_id(Integer code){
        return repository.findByEmployees_Id(code);
    }



    public Statement FindById(Integer code){
        return repository.findOne(code);
    }



}
