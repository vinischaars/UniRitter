'use strict';

/**
 * @file spec.js
 */
var ContactPage = require('./pages/contactPage.js');

// Casos de Teste
describe('ContactUs Suite Scenarios', function(){
	beforeEach(function(){
		browser.ignoreSynchronization = true;
		browser.driver.manage().window().maximize();
		ContactPage.get();
	});	
	
	it('Verifica se o título da página é Contact us - My Store', function(){
		browser.get('');
		expect(browser.getTitle()).toEqual('Contact us - My Store');
	});
	
	it('Verifica se o link Contact us é apresentado na tela', function(){
		browser.get('');
		expect(element(by.id('contact-link')).getText()).toEqual('Contact us');
	});
	
	it('Verifica se o link Sign in é apresentado na tela', function(){
		browser.get('');
		expect(element(by.css('.login')).getText()).toEqual('Sign in');
	});
	
	it('Realizar uma busca de produtos: Blouse', function() {
		browser.driver.get('http://automationpractice.com/index.php?controller=contact');   
		browser.driver.findElement(by.name('search_query')).sendKeys('Blouse');
	});
	
	it('Verifica se o Número de Telefone é apresentado na tela', function(){
		browser.get('');
		expect(element(by.css('.shop-phone')).getText()).toEqual('Call us now: 0123-456-789');
	});
	
	it('Verifica se título CUSTOMER SERVICE - CONTACT US é apresentado na tela', function(){
		browser.get('');
		expect(element(by.css('.page-heading.bottom-indent')).getText()).toEqual('CUSTOMER SERVICE - CONTACT US');
	});
	
	it('Verifica se a indicação de navegação Contact é apresentado na tela', function(){
		browser.get('');
		expect(element(by.css('.navigation_page')).getText()).toEqual('Contact');
	});
	
	it('Verifica se o título SEND A MESSAGE é apresentado na tela', function(){
		browser.get('');
		expect(element(by.css('.page-subheading')).getText()).toEqual('SEND A MESSAGE');
	});
	
	it('Verifica se o label Subject Heading é apresentado na tela', function(){
		browser.get('');
		expect(element(by.css('label[for="id_contact"]')).getText()).toEqual('Subject Heading');
	});
	
	it('Verifica se o label Email address é apresentado na tela', function(){
		browser.get('');
		expect(element(by.css('label[for="email"]')).getText()).toEqual('Email address');
	});

        it('Verifica se o label Order reference é apresentado na tela', function(){
		browser.get('');
		element.all(by.css('.selector1 label')).then(function(items){
			expect(items.length).toBe(2);
			expect(items[1].getText()).toBe('Order reference');
		});
	});
	 
	it('Verifica se o label Attach File é apresentado na tela', function(){
		browser.get('');
		expect(element(by.css('label[for="fileUpload"]')).getText()).toEqual('Attach File');
	});
	
	it('Verifica se o label Message é apresentado na tela', function(){
		browser.get('');
		expect(element(by.css('label[for="message"]')).getText()).toEqual('Message');
	});
	
	it('Envia a mensagem com sucesso, campos obrigatórios preenchidos', function () {
		ContactPage.submit('Webmaster', 'teste@gmail.com', '', '', 'teste lorem ipsum');
		expect(ContactPage.successMessage.isDisplayed()).toBe(true);
	});
	
	it('Não deve enviar a mensagem, campos obrigatórios em branco', function () {
		ContactPage.submit('', '', '', '', '');
		expect(ContactPage.successMessage.isPresent()).toBe(false);
		expect(element(by.css('.alert.alert-danger', 'There is 1 error Invalid email address.')));
	});
	
	it('Não deve enviar a mensagem, campo Subject Heading é obrigatório', function () {
		ContactPage.submit('', 'teste@gmail.com', '', '', 'teste lorem ipsum');
		expect(ContactPage.successMessage.isPresent()).toBe(false);
		expect(element(by.css('.alert.alert-danger', 'There is 1 error Please select a subject from the list provided.')));
	});
	
	it('Não deve enviar a mensagem, campo Email address é obrigatório', function () {
		ContactPage.submit('Webmaster', '', '', '', 'teste lorem ipsum');
		expect(ContactPage.successMessage.isPresent()).toBe(false);
		expect(element(by.css('.alert.alert-danger', 'There is 1 error Invalid email address.')));
	});
	
	it('Não deve enviar a mensagem, campo Message é obrigatório', function () {
		ContactPage.submit('Webmaster', 'teste@gmail.com', '', '', '');
		expect(ContactPage.successMessage.isPresent()).toBe(false);
		expect(element(by.css('.alert.alert-danger', 'There is 1 error The message cannot be blank.')));
	});

	it('Verifca a mensagem referente ao subject heading de customer', function(){
		ContactPage.subjectheading('customer');
		expect(element(by.css('p[id="desc_contact2"]')).getText()).toEqual('For any question about a product, an order');
		
	});

	it('Verifca a mensagem referente ao subject heading de webmaster', function(){
		ContactPage.subjectheading('webmaster');
		expect(element(by.css('p[id="desc_contact1"]')).getText()).toEqual('If a technical problem occurs on this website');
		
	});
	
	it('Verifica se o botão SEND é apresentado na tela', function(){
		browser.get('');
		expect(element(by.id('submitMessage')).getText()).toEqual('Send');
	});
	
	it('Verifica se o Logo do website é apresentado na tela', function(){
		browser.get('');
		var mypic = element(by.css("img[src*='http://automationpractice.com/img/logo.jpg']"));
		expect(mypic.isPresent()).toBe(true);
	});
});
