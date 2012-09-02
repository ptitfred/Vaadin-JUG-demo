package com.morevaadin.vaadin7.jugdemo;

import com.vaadin.navigator.Navigator.SimpleViewDisplay;
import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.Root;

@SuppressWarnings("serial")
public class DemoRoot extends Root {

	@Override
	protected void init(WrappedRequest request) {

		SimpleViewDisplay display = new SimpleViewDisplay();

		display.showView(new MainView());

		setContent(display);
	}
}
