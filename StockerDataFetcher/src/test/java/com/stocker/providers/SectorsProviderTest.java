package com.stocker.providers;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by AmourWin7 on 12/16/2016.
 */
public class SectorsProviderTest {
    @org.junit.Test
    public void getSectors() throws Exception {

      List<?> list = SectorsProvider.getInstance().getSectors();

    }

}