package com.slconnected.springRelayTest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

@RestController
public class RelayController {
	
	public static GpioPinDigitalOutput relayOnePin;
	public static GpioPinDigitalOutput relayTwoPin;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home.html");
	}
	
	@RequestMapping("/relay1")
	public void relayOne() {
		if(relayOnePin==null) {
			GpioController gpio = GpioFactory.getInstance();
			relayOnePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03,"RelayOne",PinState.HIGH);
		}
		relayOnePin.toggle();
	}
	
	@RequestMapping("/relay2")
	public void relayTwo() {
		if(relayTwoPin==null) {
			GpioController gpio = GpioFactory.getInstance();
			relayTwoPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,"RelayTwo",PinState.HIGH);
		}
		relayTwoPin.toggle();
	}

}
