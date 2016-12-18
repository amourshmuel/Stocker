package com.stocker.utils.serializer.csv;

import net.sf.jsefa.common.converter.SimpleTypeConverter;

/**
 * Created by AmourWin7 on 12/18/2016.
 */
public class DoubleConverter implements SimpleTypeConverter {

    private static final DoubleConverter INSTANCE = new DoubleConverter();
    public static DoubleConverter create() {
        return INSTANCE;
    }
    private DoubleConverter() {
    }
    @Override
    public Object fromString(String s) {
        if (s.equalsIgnoreCase("NA"))
            return null;
        return new Double(s);
    }

    @Override
    public String toString(Object d) {
        return d.toString();
    }

}
