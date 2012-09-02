package com.morevaadin.vaadin7.jugdemo;

import static com.vaadin.ui.Notification.TYPE_ERROR_MESSAGE;

import com.vaadin.Application;
import com.vaadin.navigator.Navigator.SimpleViewDisplay;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
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

		Application.getCurrent().setLogoutURL(".");
	}

	void login(String login, String password) {

		if ("juguser".equals(login)) {

			Application.getCurrent().setUser("JUG User");

			display.showView(new MainView());

		} else {

			Notification.show("Authentication error", TYPE_ERROR_MESSAGE);
		}
	}

	void logout() {

		Application.getCurrent().close();
	}
}
