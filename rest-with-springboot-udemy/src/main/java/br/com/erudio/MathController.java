package br.com.erudio;

import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationException;
import br.com.erudio.request.converters.NumberConverter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		String[] numbers = {numberOne, numberTwo};
		NumberConverter.numericArguments(numbers);
		return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
	}

	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		String[] numbers = {numberOne, numberTwo};
		NumberConverter.numericArguments(numbers);
		return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
	}

	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		String[] numbers = {numberOne, numberTwo};
		NumberConverter.numericArguments(numbers);
		return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
	}

	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		String[] numbers = {numberOne, numberTwo};
		NumberConverter.numericArguments(numbers);
		return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
	}

	@RequestMapping(value="/exponent/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double exponent(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		String[] numbers = {numberOne, numberTwo};
		NumberConverter.numericArguments(numbers);
		return Math.pow(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value="/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		String[] numbers = {numberOne, numberTwo};
		NumberConverter.numericArguments(numbers);
		return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo)) / 2.0;
	}

	@RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		String[] numbers = {number};
		NumberConverter.numericArguments(numbers);
		return Math.sqrt(NumberConverter.convertToDouble(number));
	}

}
