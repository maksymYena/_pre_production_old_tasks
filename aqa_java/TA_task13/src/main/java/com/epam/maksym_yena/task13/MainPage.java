package com.epam.maksym_yena.task13;

import com.codeborne.selenide.Selenide;

public class MainPage {
    public static MainPage open() {
        Selenide.open("https://yandex.ru/");
        return new MainPage();
    }
    }

