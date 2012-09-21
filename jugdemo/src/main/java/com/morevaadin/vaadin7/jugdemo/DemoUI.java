package com.morevaadin.vaadin7.jugdemo;

import com.vaadin.terminal.WrappedRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class DemoUI extends UI {

	@Override
	protected void init(WrappedRequest request) {

		HorizontalLayout layout = new HorizontalLayout();
		
		Label label = new Label("Hello JUG!");
		
		layout.addComponent(label);
		
		setContent(layout);
	}
}
