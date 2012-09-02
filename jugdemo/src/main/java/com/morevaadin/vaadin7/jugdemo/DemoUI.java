package com.morevaadin.vaadin7.jugdemo;

import com.vaadin.navigator.Navigator.SimpleViewDisplay;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DemoUI extends UI {

	private SimpleViewDisplay display = new SimpleViewDisplay();

	@Override
	protected void init(WrappedRequest request) {

		display.showView(new LoginView());

		setContent(display);
	}

	void login(String login, String password) {

		if ("juguser".equals(login)) {

			display.showView(new MainView());
		}
	}
}
