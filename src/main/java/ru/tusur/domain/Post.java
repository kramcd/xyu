package ru.tusur.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




public enum  Post {

    Бухгалтер("Бух"),
    Менеджер("Планктон"),
    Старший_Менеджер("ЙАКРЕВЕТКО"),
    Уборщик("Мистер Пропер"),
    Технолог("ЕдинственноШарящий"),
    Монтажник("СуперМэн"),
    Диспетчер("Разводящий"),
    Кладовщик("Кладовщик"),
    Управляющий_Персоналом("Управляющий_персоналом"),
    Кассир("Кассир"),
    Программист("Программист"),
    Специалист_по_ремонту("Специалист по ремонту"),
    Директор("Главный по тарелочкам");

    private String text;

    public String getText() {
        return text;
    }

    Post(String text){
        this.text = text;
    }
}
