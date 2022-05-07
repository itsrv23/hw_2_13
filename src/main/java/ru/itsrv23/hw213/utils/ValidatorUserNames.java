package ru.itsrv23.hw213.utils;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.itsrv23.hw213.exceptions.EmployeeValidateException;

public class ValidatorUserNames {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatorUserNames.class);

    public static String check(@NotNull String str){
        //Примеры Александр Васильевич Суворов-Рымникский, Румянцев-Задунайский, Долгоруков-Крымский
        String[] arrName = str.trim().split("-");
        for (int i = 0; i < arrName.length; i++) {
            if(!StringUtils.isAlpha(arrName[i])){
                LOGGER.info("Error in string: " + str);
                throw new EmployeeValidateException();
            }
            arrName[i] = StringUtils.capitalize(arrName[i]);
        }
        return StringUtils.join(arrName,"-");

    }
}
