package com.bowling.mauriziopietrantuono.bowling.presenter;

import com.bowling.mauriziopietrantuono.bowling.view.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {
    private Presenter presenter;
    @Mock MainView view;

    @Before
    public void setUp() throws Exception {
        presenter = new Presenter();
        presenter.bind(view);
    }

    @Test
    public void given_foo_when_bar_then_fobar() {

        // GIVEN


        // WHEN


        // THEN

    }
}